package edu.brown.cs.student.main.Call;

import com.mongodb.client.MongoCollection;
import edu.brown.cs.student.main.Commands.BestMatch;
import edu.brown.cs.student.main.Commands.RandomMatch;
import edu.brown.cs.student.main.Connection.DatabaseConnect;
import edu.brown.cs.student.main.Creation.CreateTestStudents;
import edu.brown.cs.student.main.Creation.HandleStudent;
import edu.brown.cs.student.main.Objects.Course;
import edu.brown.cs.student.main.Objects.Student;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for method calls for testing purposes.
 */
public class TestCalls {

  /**
   * test call for hard coded students.
   *
   * @return a list of names that are matched.
   */
  public List<String> call3() {
    CreateTestStudents cts = new CreateTestStudents();
    List<Student> studentList = cts.studentList();
    Student student = studentList.get(0);
    Course course = student.getCourseList().get(0);
    System.out.println("STUDENT: " + student.getName() + " " + student.getEmail());
    BestMatch bm = new BestMatch(student, course, studentList, 1);
    List<Student> matches = bm.getBestMatchList();
    List<String> names = new ArrayList<>();
    for (Student match : matches) {
      System.out.println("MATCH: " + match.getName() + " " + match.getEmail());
      names.add(match.getName());
    }
    return names;
  }

  /**
   * test for best match for dummy students in the database.
   *
   * @return a list of matches via name
   */
  public List<String> call2() {
    DatabaseConnect dbc = new DatabaseConnect();
    MongoCollection<Document> collection = dbc.databaseConnect("CourseDB", "bestMatchStudents");
    HandleStudent handleStudent = new HandleStudent();
    List<Student> studentList = handleStudent.getStudentLst(collection);
    Student student = studentList.get(1);
    Course course = student.getCourseList().get(0);
    System.out.println("STUDENT: " + student.getName() + " " + student.getEmail());
    BestMatch rM = new BestMatch(student, course, studentList, 1);
    List<Student> matchList = rM.getBestMatchList();
    List<String> matchNames = new ArrayList<>();
    for (Student s : matchList) {
      matchNames.add(s.getName());
    }
    return matchNames;
  }

  /**
   * test for random match for dummy students in the database.
   *
   * @return the name of the match
   */
  public String call() {
    CallCommands cC = new CallCommands();
    DatabaseConnect dbc = new DatabaseConnect();
    MongoCollection<Document> collection = dbc.databaseConnect("CourseDB", "bestMatchStudents");
    HandleStudent handleStudent = new HandleStudent();
    List<Student> studentList = handleStudent.getStudentLst(collection);
    Student student = studentList.get(0);
    Course course = student.getCourseList().get(0);
    System.out.println("STUDENT: " + student.getName() + " " + student.getEmail());
    cC.getRandomMatch(student, course, collection);
    RandomMatch rM = new RandomMatch(student, course, studentList);
    Student stu = rM.getRandomMatch();
    return stu.getName();
  }
}
