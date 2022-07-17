package edu.brown.cs.student.main.CommandHelpers;

import edu.brown.cs.student.main.Objects.Course;
import edu.brown.cs.student.main.Objects.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Record that starts the algorithm for both RandomMatch and BestMatch.
 *
 * @param student     - the student to find the match for
 * @param course      - the course to find the match in
 * @param studentList - the list of students
 */
public record BeginningAlgorithm(Student student, Course course, List<Student> studentList) {

  /**
   * Method that calculates a list of students who can be potential matches for the current student
   * and the shared course.
   *
   * @return - the list of potential study buddies
   */
  public List<Student> setupAlgorithm() {
    List<Student> sharingCourse = new ArrayList<>();
    for (Student other : this.studentList) {
      if (!other.equals(this.student)) {
        CourseSharingCalculator courseShare =
            new CourseSharingCalculator(this.student, other, this.course);
        if (courseShare.checkSharedCourse()) {
          sharingCourse.add(other);
        }
      }
    }
    List<Student> potentialMatch = new ArrayList<>();
    for (Student other : sharingCourse) {
      PotentialMatchCalculator potentialCalc = new PotentialMatchCalculator(this.student, other);
      if (potentialCalc.checkMatch()) {
        potentialMatch.add(other);
      }
    }
    return potentialMatch;
  }
}
