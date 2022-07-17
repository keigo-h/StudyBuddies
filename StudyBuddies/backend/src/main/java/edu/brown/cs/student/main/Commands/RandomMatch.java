package edu.brown.cs.student.main.Commands;


import edu.brown.cs.student.main.CommandHelpers.BeginningAlgorithm;
import edu.brown.cs.student.main.Objects.Course;
import edu.brown.cs.student.main.Objects.Student;

import java.util.List;
import java.util.Random;

/**
 * Class that executes the BestMatch algorithm.
 */
public class RandomMatch {

  private final Student student;
  private final Course course;
  private final List<Student> studentList;

  /**
   * Constructor for the BestMatch object.
   *
   * @param student     - the current student
   * @param course      - the shared course
   * @param studentList - the current student list
   */
  public RandomMatch(Student student, Course course, List<Student> studentList) {
    this.student = student;
    this.course = course;
    this.studentList = studentList;
  }

  /**
   * Method that calculates the best match study buddy of the current student in the shared course.
   *
   * @return - the best match study buddy
   */
  public Student getRandomMatch() {
    BeginningAlgorithm begin = new BeginningAlgorithm(this.student, this.course, this.studentList);
    List<Student> potentialMatches = begin.setupAlgorithm();
    Random rand = new Random();
    //have to error check 0
    Student match = null;
    if (potentialMatches.size() > 0) {
      int randomIndex = rand.nextInt(potentialMatches.size());
      match = potentialMatches.get(randomIndex);
    }
    return match;
  }

}
