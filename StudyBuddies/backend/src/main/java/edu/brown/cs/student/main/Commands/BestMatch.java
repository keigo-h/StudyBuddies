package edu.brown.cs.student.main.Commands;

import edu.brown.cs.student.main.CommandHelpers.BeginningAlgorithm;
import edu.brown.cs.student.main.CommandHelpers.BestMatchCalculator;
import edu.brown.cs.student.main.Objects.Course;
import edu.brown.cs.student.main.Objects.Student;

import java.util.List;

/**
 * Class that executes the BestMatch algorithm.
 */
public class BestMatch {

  private final Student student;
  private final Course course;
  private final List<Student> studentList;
  private final int numMatches;

  /**
   * Constructor for the BestMatch object.
   *
   * @param student     - the current student
   * @param course      - the shared course
   * @param numMatches  - the number of desired matches
   * @param studentList - the current student list
   */
  public BestMatch(Student student, Course course, List<Student> studentList, int numMatches) {
    this.student = student;
    this.course = course;
    this.studentList = studentList;
    this.numMatches = numMatches;
  }

  /**
   * Method that calculates the best match study buddies of the current student in the
   * shared course.
   *
   * @return - the best match study buddy
   */
  public List<Student> getBestMatchList() {
    BeginningAlgorithm begin = new BeginningAlgorithm(this.student, this.course, this.studentList);
    List<Student> potentialMatches = begin.setupAlgorithm();
    BestMatchCalculator bestMatch =
        new BestMatchCalculator(this.student, potentialMatches, this.numMatches);
    return bestMatch.getBestMatchList();
  }
}
