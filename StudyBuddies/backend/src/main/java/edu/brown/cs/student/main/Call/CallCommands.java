package edu.brown.cs.student.main.Call;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Updates;
import edu.brown.cs.student.main.Commands.BestMatch;
import edu.brown.cs.student.main.Commands.RandomMatch;
import edu.brown.cs.student.main.Creation.HandleStudent;
import edu.brown.cs.student.main.Objects.Course;
import edu.brown.cs.student.main.Objects.MatchStudent;
import edu.brown.cs.student.main.Objects.Student;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class for handling calls to major methods.
 */
public class CallCommands {

  /**
   * Gets a random match for a student in a certain class.
   *
   * @param student    the student to find the match for
   * @param course     the course the student wants the match in
   * @param collection connection to the database's collection
   * @return a JSON string representing the random match
   */
  public String getRandomMatch(Student student, Course course,
                               MongoCollection<Document> collection) {
    HandleStudent handleStudent = new HandleStudent();
    List<Student> studentList = handleStudent.getStudentLst(collection);
    studentList.remove(student);
    RandomMatch rM = new RandomMatch(student, course, studentList);
    Gson gson = new Gson();
    if (rM.getRandomMatch() == null) {
      //handle
      System.out.println("no matches found");
      return null;
    } else {
      String jsonStr = gson.toJson(rM.getRandomMatch());
      JsonObject jsonObj = JsonParser.parseString(jsonStr).getAsJsonObject();
      List<MatchStudent> matchStudents = new ArrayList<>();
      Map<String, Object> retVal = new HashMap<>();
      MatchStudent match = makeMatchStudent(jsonObj);
      matchStudents.add(match);
      updateStudentMatchMap(student, course, collection, matchStudents);
      retVal.put("matches", matchStudents);
      retVal.put("course", course);
      return gson.toJson(retVal);
    }
  }

  /**
   * Gets the top three best matches for a student in particular class.
   *
   * @param student    the student to find the match for
   * @param course     the course the student wants the match in
   * @param numMatches the number of matches to find: default is 3
   * @param collection the connection to the collection
   * @return a JSON string of the list of matches
   */
  public String getBestMatch(Student student, Course course, int numMatches,
                             MongoCollection<Document> collection) {
    HandleStudent handleStudent = new HandleStudent();
    List<Student> studentList = handleStudent.getStudentLst(collection);
    studentList.remove(student);
    BestMatch rM = new BestMatch(student, course, studentList, numMatches);
    Gson gson = new Gson();
    List<Student> matchList = rM.getBestMatchList();
    if (matchList.isEmpty()) {
      System.out.println("no matches found");
      return null;
    } else {
      List<MatchStudent> matchStudents = new ArrayList<>();
      HashMap<String, Object> dataMap = new HashMap<>();
      for (Student match : matchList) {
        MatchStudent newStu = new MatchStudent(match.getName(), match.getEmail(),
            match.getClassYear());
        matchStudents.add(newStu);
      }
      dataMap.put("matches", matchStudents);
      dataMap.put("course", course);
      updateStudentMatchMap(student, course, collection, matchStudents);
      return gson.toJson(dataMap);
    }
  }

  /**
   * Makes MatchStudent object.
   *
   * @param jsonObj th json object
   * @return a MatchStudent object
   */
  public MatchStudent makeMatchStudent(JsonObject jsonObj) {
    String name = jsonObj.get("name").toString().replace("\"", "");
    String email = jsonObj.get("email").toString().replace("\"", "");
    String year = jsonObj.get("classYear").toString().replace("\"", "");
//    System.out.println("MATCH: " + name + " " + email + " YEAR: " + year);
    return new MatchStudent(name, email, year);
  }

  /**
   * method to delete a student from the database.
   * @param student the student to delete
   * @param collection the connection to the database
   */
  public void delete(Student student, MongoCollection<Document> collection) {
    HandleStudent handleStudent = new HandleStudent();
    Document s = handleStudent.studentToDocument(student);
    collection.deleteOne(s);
  }

  /**
   * Method which will update the student's match in the MongoDB database.
   *
   * @param currStudent   the student to add the matches for
   * @param course        the course in which to find matches
   * @param collection    the connection to the collection
   * @param matchStudents the list of student matches to add
   */
  public void updateStudentMatchMap(Student currStudent, Course course,
                                    MongoCollection<Document> collection,
                                    List<MatchStudent> matchStudents) {
    HandleStudent handleStudent = new HandleStudent();
    Document curr = handleStudent.studentToDocument(currStudent);
    Student dbStudent = handleStudent.authenticateUser(currStudent.getEmail(), collection);
    Map<String, List<MatchStudent>> courseMatchMap = dbStudent.getCourseMatches();
    courseMatchMap.put(course.getName(), matchStudents);
    Gson gson = new Gson();
    Map<String, List<Document>> testmap = new HashMap<>();
    for (String c : courseMatchMap.keySet()) {
      List<Document> matchList = new ArrayList<>();
      for (MatchStudent matchStudent : courseMatchMap.get(c)) {
        matchList.add(Document.parse(gson.toJson(matchStudent)));
      }
      testmap.put(c, matchList);
    }
    Bson update = Updates.set("courseMatches", testmap);
    try {
      collection.updateOne(curr, update);
    } catch (MongoException e) {
      System.out.println(e);
    }
  }
}
