package calculationTests.timeTest;

import com.mongodb.client.MongoCollection;
import edu.brown.cs.student.main.Call.TestCalls;
import edu.brown.cs.student.main.CommandHelpers.BeginningAlgorithm;
import edu.brown.cs.student.main.CommandHelpers.BestMatchCalculator;
import edu.brown.cs.student.main.Commands.RandomMatch;
import edu.brown.cs.student.main.Connection.DatabaseConnect;
import edu.brown.cs.student.main.Creation.CreateTestStudents;
import edu.brown.cs.student.main.Creation.HandleStudent;
import edu.brown.cs.student.main.Objects.Course;
import edu.brown.cs.student.main.Objects.Student;
import org.bson.Document;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static com.mongodb.internal.connection.tlschannel.util.Util.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class TestWithConnection {

  @Test
  public void testCall1() {
    TestCalls tc = new TestCalls();
    List<String> matches = tc.call3();
    assertEquals(matches.get(0), "cheese cake");
  }

  @Test
  public void testCall2() {
    TestCalls tc = new TestCalls();
    List<String> matches = tc.call2();
    assertEquals("viv amdfa", matches.get(0));
  }

  @Test
  public void testCall3() {
    CreateTestStudents cts = new CreateTestStudents();
    List<Student> stuLst = cts.studentList();
    Student first = stuLst.get(0);
    stuLst.remove(0);
    BestMatchCalculator bMC = new BestMatchCalculator(first, stuLst,2);
    assertEquals(bMC.matchScore(stuLst.get(1)), 25);
    assertEquals(bMC.matchScore(stuLst.get(0)), 0);
    for(Student s : bMC.getBestMatchList()){
      System.out.println(s.getName());
    }
    assertEquals(bMC.getBestMatchList().get(0).getName(), stuLst.get(1).getName());
  }

  @Test
  public void testCall4() {
    DatabaseConnect dbc = new DatabaseConnect();
    MongoCollection<Document> collection = dbc.databaseConnect("CourseDB", "bestMatchStudents");
    HandleStudent handleStudent = new HandleStudent();
    List<Student> studentList = handleStudent.getStudentLst(collection);
    Student student = studentList.get(1);
    studentList.remove(student);
    Course course = student.getCourseList().get(0);
    BeginningAlgorithm ba = new BeginningAlgorithm(student, course, studentList);
    BestMatchCalculator bmc = new BestMatchCalculator(student, ba.setupAlgorithm(), 5);
    HashMap<Student, Integer> studentScore = bmc.calcScores();
    List<Student> bestMatches = bmc.getBestMatchList();
    for(int i = 1; i < bestMatches.size(); i++){
      boolean greater = studentScore.get(bestMatches.get(i-1)) >=
          studentScore.get(bestMatches.get(i));
      assertTrue(greater);
    }
  }

  @Test
  public void testCall5() {
    DatabaseConnect dbc = new DatabaseConnect();
    MongoCollection<Document> collection = dbc.databaseConnect("CourseDB", "bestMatchStudents");
    HandleStudent handleStudent = new HandleStudent();
    List<Student> studentList = handleStudent.getStudentLst(collection);
    Student student = studentList.get(1);
    studentList.remove(student);
    Course course = student.getCourseList().get(0);
    BeginningAlgorithm ba = new BeginningAlgorithm(student, course, studentList);
    List<Student> lst = ba.setupAlgorithm();
    RandomMatch rm = new RandomMatch(student, course, studentList);
    Student match = rm.getRandomMatch();
    assertTrue(lst.contains(match));
  }
}
