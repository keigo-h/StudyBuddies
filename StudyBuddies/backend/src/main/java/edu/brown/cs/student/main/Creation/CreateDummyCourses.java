package edu.brown.cs.student.main.Creation;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import edu.brown.cs.student.main.Connection.DatabaseConnect;
import edu.brown.cs.student.main.Objects.Course;
import org.bson.Document;


import java.util.ArrayList;
import java.util.List;

/**
 * Class which will create predetermined courses for testing purposes.
 */
public class CreateDummyCourses {
  /**
   * method which initializes 6 courses.
   *
   * @return the list of courses
   */
  public List<Course> createCourseList() {
    List<Course> courseList = new ArrayList<>();
    Course afri0090 = new Course("AFRI", "0090");
    Course afri0670 = new Course("AFRI", "0670");
    Course afri0840 = new Course("AFRI", "0840");
    Course apma0200 = new Course("APMA", "0200");
    Course apma0350 = new Course("APMA", "0350");
    Course apma0360 = new Course("APMA", "0360");
    Course cs0020 = new Course("CSCI", "0020");
    Course cs0081 = new Course("CSCI", "0081");
    Course cs0082 = new Course("CSCI", "0082");
    Course econ0110 = new Course("ECON", "0110");
    Course econ0170 = new Course("ECON", "0170");
    Course econ0710 = new Course("ECON", "0710");
    courseList.add(afri0090);
    courseList.add(afri0670);
    courseList.add(afri0840);
    courseList.add(apma0200);
    courseList.add(apma0350);
    courseList.add(apma0360);
    courseList.add(cs0020);
    courseList.add(cs0081);
    courseList.add(cs0082);
    courseList.add(econ0110);
    courseList.add(econ0170);
    courseList.add(econ0710);
//    Course econ0110 = new Course("ECON", "0170");
//    Course math0180 = new Course("MATH", "0180");
//    Course cs0200 = new Course("CSCI", "0200");
//    Course biol0200 = new Course("BIOL", "0200");
//    Course cs0170 = new Course("CSCI", "0170");
//    Course cs0150 = new Course("CSCI", "0150");
//    courseList.add(econ0110);
//    courseList.add(math0180);
//    courseList.add(cs0200);
//    courseList.add(biol0200);
//    courseList.add(cs0170);
//    courseList.add(cs0150);
    return courseList;
  }

  public void coursesToDB() {
    List<Course> courseList = createCourseList();
    DatabaseConnect dbc = new DatabaseConnect();
    MongoClient mongoClient = dbc.clientConnect();
    MongoCollection<Document> collection = dbc.databaseConnect("CourseDB", "frontEndCourses");
    HandleCourses handleCourses = new HandleCourses();
    for (Course course : courseList) {
      collection.insertOne(handleCourses.courseToDocument(course));
    }
    mongoClient.close();
  }
}
