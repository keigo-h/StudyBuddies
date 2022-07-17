package edu.brown.cs.student.main.Objects;

import java.util.Objects;

/**
 * class representing a course.
 */
public class Course {

  private final String department;
  private final String courseNumber;

  /**
   * Constructor for the course object.
   *
   * @param department   the department name
   * @param courseNumber the course number in string form
   */
  public Course(String department, String courseNumber) {
    this.department = department;
    this.courseNumber = courseNumber;
  }

  /**
   * returns the course in string from.
   *
   * @return the string version of the course name.
   */
  public String getName() {
    return this.department + " " + this.courseNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Course course = (Course) o;
    return Objects.equals(department, course.department) &&
        Objects.equals(courseNumber, course.courseNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(department, courseNumber);
  }

}
