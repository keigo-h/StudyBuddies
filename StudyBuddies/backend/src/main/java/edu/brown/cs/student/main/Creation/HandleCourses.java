package edu.brown.cs.student.main.Creation;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import edu.brown.cs.student.main.Objects.Course;
import org.bson.Document;

/**
 * class for methods to handle courses.
 */
public class HandleCourses {
  /**
   * sends a course object to the database.
   *
   * @param course           the course to send to the database
   * @param courseCollection the connection to the course database.
   */
  public void coursesToDB(Course course, MongoCollection<Document> courseCollection) {
    HandleCourses handleCourses = new HandleCourses();
    courseCollection.insertOne(handleCourses.courseToDocument(course));
  }

  /**
   * creates a course given a string repressing the course.
   *
   * @param courseName the name of the course
   * @return the Course object
   */
  public Course createCourseFromString(String courseName) {
    String[] courseNameComp = courseName.split(" ");
    return new Course(courseNameComp[0], courseNameComp[1]);
  }

  /**
   * gets the course from the course database return null if not found.
   *
   * @param courseName the name of the course
   * @param collection the connection to the course database.
   * @return the Course object if found, null otherwise
   */
  public Course getCourse(String courseName, MongoCollection<Document> collection) {
    String[] courseComponenets = courseName.split(" ");
    String department = courseComponenets[0];
    String courseNumber = courseComponenets[1];
    BasicDBObject findCourse = new BasicDBObject();
    findCourse.put("department", department);
    findCourse.put("courseNumber", courseNumber);
    Document course = collection.find(findCourse).first();
    if (course == null) {
      return null;
    } else {
      return documentToCourse(course);
    }
  }

  /**
   * method which makes a Document from a Course object.
   *
   * @param course a Course object
   * @return A Document object
   */
  public Document courseToDocument(Course course) {
    Gson gson = new Gson();
    String json = gson.toJson(course);
    return Document.parse(json);
  }

  /**
   * method which makes a Course object form a Document object.
   *
   * @param document a document object
   * @return a course object
   */
  public Course documentToCourse(Document document) {
    String json = document.toJson();
    Gson gson = new Gson();
    return gson.fromJson(json, Course.class);
  }

}
