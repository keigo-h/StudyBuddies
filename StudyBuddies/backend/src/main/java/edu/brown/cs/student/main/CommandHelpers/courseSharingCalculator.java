package edu.brown.cs.student.main.CommandHelpers;

import edu.brown.cs.student.main.Objects.Course;
import edu.brown.cs.student.main.Objects.Student;

/**
 * Record that checks whether two students share the given course.
 *
 * @param student1 - the first student
 * @param student2 - the second student
 * @param course   - the course
 */
public record CourseSharingCalculator(Student student1, Student student2, Course course) {

  /**
   * Method that checks whether two students share the input course.
   *
   * @return - a boolean indicating whether two students share the course
   */
  public boolean checkSharedCourse() {
    return this.student1.getCourseList().contains(course)
        && this.student2.getCourseList().contains(course);
  }
}
