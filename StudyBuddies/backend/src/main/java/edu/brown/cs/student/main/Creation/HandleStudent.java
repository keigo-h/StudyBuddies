package edu.brown.cs.student.main.Creation;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import edu.brown.cs.student.main.Enums.Location;
//import edu.brown.cs.student.main.Enums.PersonalityType;
import edu.brown.cs.student.main.Enums.PersonalityType;
import edu.brown.cs.student.main.Enums.Sex;
import edu.brown.cs.student.main.Enums.StudySpace;
import edu.brown.cs.student.main.Objects.Course;
import edu.brown.cs.student.main.Objects.Student;
import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Class for methods to do with the student.
 */
public class HandleStudent {
  /**
   * creates a student from the database info.
   *
   * @param data             the data from the frontend.
   * @param courseCollection the collection of courses
   * @return the student that is created.
   */
  public Student create(JSONObject data, MongoCollection<Document> courseCollection) {
    String firstName = data.getString("firstName");
    String lastName = data.getString("lastName");
    String email = data.getString("email");
    String name = firstName + " " + lastName;
    Student student = new Student(name, email);
    student.setClassYear(data.getString("year"));
    student.setSex(stringToSex(data.getString("gender")));
    student.setConcentration(data.getString("concentration"));
    student.setCourseList(jsonToCourseLst(data.getJSONArray("enteredCourses"), courseCollection));

    student.setTimeSlots(jsonToTimeSlots(data.getJSONObject("timeSlots")));

    student.setSncGrade(data.getString("gradeMode").equals("snc"));
    student.setPersonalityType(stringToPersonality(data.getString("personality")));
    student.setMinHours(data.getInt("enteredMinTime"));
    student.setLocation(stringToLoc(data.getString("enteredLocation")));
    student.setStudySpace(stringToSpace(data.getString("enteredStudySpace")));
    student.setAthlete(data.getString("enteredAthlete").equals("athlete"));

    JSONObject prefs = data.getJSONObject("preferenceState");
    student.setPreferences(jsonToPrefWeight(prefs));

    student.setPrefSex(stringToSex(prefs.getString("gender")));
    student.setPrefConcentration(prefs.getString("concentration"));
    student.setPrefAthlete(prefs.getString("athletes").equals("athlete"));
    student.setPrefLoc(stringToLoc(prefs.getString("location")));
    student.setPrefPersonality(stringToPersonality(prefs.getString("personality")));
    student.setPrefSncGrade(prefs.getString("grade").equals("snc"));
    student.setPrefStudySpace(stringToSpace(prefs.getString("studyLocation")));
    student.setPrefClassYear(prefs.getString("classYear"));

    return student;
  }

  /**
   * get the course list from the data.
   *
   * @param courseListJSON   the json data for course
   * @param courseCollection the connection to the course db
   * @return a list of courses
   */
  public List<Course> jsonToCourseLst(JSONArray courseListJSON,
                                      MongoCollection<Document> courseCollection) {
    List<Course> courseList = new ArrayList<>();
    for (int i = 0; i < courseListJSON.length(); i++) {
      courseList.add(checkCourse((String) courseListJSON.get(i), courseCollection));
    }
    return courseList;
  }

  /**
   * creates a map of timeslots by day.
   *
   * @param jsonTimeData the json data for time.
   * @return a hashmap of day to available times
   */
  public HashMap<String, List<Integer[]>> jsonToTimeSlots(JSONObject jsonTimeData) {
    HashMap<String, List<Integer[]>> timeSlots = new HashMap<>();
    String[] week =
        new String[] {"sunday", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday"};
    for (String day : week) {
      JSONArray courseListTimes = jsonTimeData.getJSONArray(day);
      timeSlots.put(day, new ArrayList<>());
      for (int i = 0; i < courseListTimes.length(); i++) {
        JSONArray t = (JSONArray) courseListTimes.get(i);
        Integer[] time = new Integer[] {(Integer) t.get(0), (Integer) t.get(1)};
        timeSlots.get(day).add(time);
      }
    }
    return timeSlots;
  }

  /**
   * Creates a hashmap to preference to its respective weight.
   *
   * @param prefs the json data of weights.
   * @return a map of preference to its weight
   */
  public HashMap<String, Integer> jsonToPrefWeight(JSONObject prefs) {
    HashMap<String, Integer> prefweight = new HashMap<>();
    prefweight.put("snc", prefs.getInt("gradeModePref"));
    prefweight.put("class", prefs.getInt("classYearPref"));
    prefweight.put("concentration", prefs.getInt("concPref"));
    prefweight.put("personality", prefs.getInt("personalityPref"));
    prefweight.put("location", prefs.getInt("locPref"));
    prefweight.put("athlete", prefs.getInt("athletePref"));
    prefweight.put("studySpace", prefs.getInt("studySpacePref"));
    prefweight.put("gender", prefs.getInt("genderPref"));
    return prefweight;
  }

  /**
   * finds the ENUM values for each personality from a string.
   *
   * @param personality string representation of the personality.
   * @return the ENUM for personality
   */
  public PersonalityType stringToPersonality(String personality) {
    if (personality.equals("ISTJ")) {
      return PersonalityType.ISTJ;
    } else if (personality.equals("ISTP")) {
      return PersonalityType.ISTP;
    } else if (personality.equals("ISFJ")) {
      return PersonalityType.ISFJ;
    } else if (personality.equals("ISFP")) {
      return PersonalityType.ISFP;
    } else if (personality.equals("INFJ")) {
      return PersonalityType.INFJ;
    } else if (personality.equals("INFP")) {
      return PersonalityType.INFP;
    } else if (personality.equals("INTJ")) {
      return PersonalityType.INTJ;
    } else if (personality.equals("INTP")) {
      return PersonalityType.INTP;
    } else if (personality.equals("ESTP")) {
      return PersonalityType.ESTP;
    } else if (personality.equals("ESTJ")) {
      return PersonalityType.ESTJ;
    } else if (personality.equals("ESFP")) {
      return PersonalityType.ESFP;
    } else if (personality.equals("ESFJ")) {
      return PersonalityType.ESFJ;
    } else if (personality.equals("ENFP")) {
      return PersonalityType.ENFP;
    } else if (personality.equals("ENFJ")) {
      return PersonalityType.ENFJ;
    } else if (personality.equals("ENTP")) {
      return PersonalityType.ENTP;
    } else {
      return PersonalityType.ENTJ;
    }
  }

  /**
   * finds the ENUM values for each location from a string.
   *
   * @param location string representation of the location.
   * @return the ENUM for location
   */
  public Location stringToLoc(String location) {
    if (location.equals("mid")) {
      return Location.MidCampus;
    } else if (location.equals("north")) {
      return Location.NorthCampus;
    } else if (location.equals("south")) {
      return Location.SouthCampus;
    } else {
      return Location.OffCampus;
    }
  }

  /**
   * finds the ENUM values for each studySpace from a string.
   *
   * @param studySpace string representation of the studySpace.
   * @return the ENUM for studySpace
   */
  public StudySpace stringToSpace(String studySpace) {
    if (studySpace.equals("cit")) {
      return StudySpace.CIT;
    } else if (studySpace.equals("gradcenter")) {
      return StudySpace.GradCenter;
    } else if (studySpace.equals("maingreen")) {
      return StudySpace.MainGreen;
    } else if (studySpace.equals("scili")) {
      return StudySpace.SciLi;
    } else if (studySpace.equals("ratty")) {
      return StudySpace.Ratty;
    } else if (studySpace.equals("mochamp")) {
      return StudySpace.MoChamp;
    } else if (studySpace.equals("rock")) {
      return StudySpace.Rock;
    } else {
      return StudySpace.Bedroom;
    }
  }

  /**
   * finds the ENUM values for each gender from a string.
   *
   * @param sex string representation of the gender.
   * @return the ENUM for gender
   */
  public Sex stringToSex(String sex) {
    if (sex.equals("male")) {
      return Sex.Male;
    } else if (sex.equals("female")) {
      return Sex.Female;
    } else if (sex.equals("other")) {
      return Sex.Other;
    } else {
      return Sex.None;
    }
  }

  /**
   * chekcs the existence of a course, if not make the course.
   *
   * @param courseName       the name of the course
   * @param courseCollection the connection to the course database.
   * @return a Course object.
   */
  public Course checkCourse(String courseName, MongoCollection<Document> courseCollection) {
    HandleCourses handleCourses = new HandleCourses();
    Course course = handleCourses.getCourse(courseName, courseCollection);
    if (course == null) {
      Course newCourse = handleCourses.createCourseFromString(courseName);
      handleCourses.coursesToDB(newCourse, courseCollection);
      return newCourse;
    } else {
      return course;
    }
  }

  /**
   * Sends the new student to the database.
   *
   * @param student    the student to send.
   * @param collection the connection to the student database
   */
  public void sendNewStudent(Student student, MongoCollection<Document> collection) {
    Document s1 = studentToDocument(student);
    collection.insertOne(s1);
  }

  /**
   * makes a student object into a document object.
   *
   * @param student the student to parse
   * @return a Document object of the student
   */
  public Document studentToDocument(Student student) {
    Gson gson = new Gson();
    String json = gson.toJson(student);
    return Document.parse(json);
  }

  /**
   * makes a student from a document object.
   *
   * @param document the document
   * @return a student obeject
   */
  public Student documentToStudent(Document document) {
    String json = document.toJson();
    Gson gson = new Gson();
    return gson.fromJson(json, Student.class);
  }

  /**
   * makes a json string from a student.
   *
   * @param student a student object
   * @return string form of json data
   */
  public String studentToJson(Student student) {
    Gson gson = new Gson();
    return gson.toJson(student);
  }

  /**
   * gets all students from the database.
   *
   * @param collection the connection to the database
   * @return the list of students
   */
  public List<Student> getStudentLst(MongoCollection<Document> collection) {
    List<Student> stdntLst = new ArrayList<>();
    FindIterable<Document> findIterable = collection.find(new Document());
    Gson gson = new Gson();
    for (Document d : findIterable) {
      String json = d.toJson();
      Student s = gson.fromJson(json, Student.class);
      stdntLst.add(s);
    }
    return stdntLst;
  }

  /**
   * checks the existence of a user in the database.
   *
   * @param email      the email of the user
   * @param collection the connection to the student database.
   * @return the student if found or null otherwise
   */
  public Student authenticateUser(String email, MongoCollection<Document> collection) {
    BasicDBObject findByEmail = new BasicDBObject();
    findByEmail.put("email", email);
    Document user = collection.find(findByEmail).first();
    if (user == null) {
      return null;
    } else {
      HandleStudent handleStudent = new HandleStudent();
      return handleStudent.documentToStudent(user);
    }
  }

}
