package edu.brown.cs.student.main.CommandHelpers;

import edu.brown.cs.student.main.Objects.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * The record that does a lot of the work behind the BestMatch algorithm.
 *
 * @param student     - the student
 * @param studentList - the list of students
 * @param numMatches  - the number of matches
 */
public record BestMatchCalculator(Student student, List<Student> studentList, int numMatches) {

  private static final int SCORE_VAL_ONE = 1;
  private static final int SCORE_VAL_TWO = 3;
  private static final int SCORE_VAL_THREE = 10;
  private static final int SCORE_VAL_FOUR = 25;

  /**
   * Method that puts student's and their associated match score with the current student in a
   * hashmap.
   *
   * @return - the hashmap with student and the match score
   */
  public HashMap<Student, Integer> calcScores() {
    HashMap<Student, Integer> values = new HashMap<>();
    for (Student other : studentList) {
      values.put(other, matchScore(other));
    }
    return values;
  }

  /**
   * Calculates the match score by adding the two paired scores together.
   *
   * @param other - the other student
   * @return - the match score of the current student and the other student
   */
  public int matchScore(Student other) {
    return getThisStudentScore(other) + getOtherStudentScore(other);
  }

  /**
   * Method that calculates the match score of the current student with the other student.
   *
   * @param other - the other student
   * @return - the match score of the current student with the other student
   */
  public int getThisStudentScore(Student other) {
    int score = 0;
    for (Map.Entry<String, Integer> entry : this.student.getPreferences().entrySet()) {
      if (this.student.getPrefField(entry.getKey()).equals(other.getField(entry.getKey()))) {
        score = addPoints(score, entry);
      }
    }
    return score;
  }

  /**
   * Method that calculates the match score of the other student with the current student.
   *
   * @param other - the other student
   * @return - the match score of the other student with the current student
   */
  public int getOtherStudentScore(Student other) {
    int score = 0;
    for (Map.Entry<String, Integer> entry : other.getPreferences().entrySet()) {
      if (other.getPrefField(entry.getKey()).equals(this.student.getField(entry.getKey()))) {
        score = addPoints(score, entry);
      }
    }
    return score;
  }

  /**
   * Adds points to the score depending on what the value of the trait is to the student.
   *
   * @param score - the current score
   * @param entry - a hashmap entry
   * @return - the score after the points have been added
   */
  private int addPoints(int score, Map.Entry<String, Integer> entry) {
    int val = entry.getValue();
    if (val == 1) {
      score += SCORE_VAL_ONE;
    } else if (val == 2) {
      score += SCORE_VAL_TWO;
    } else if (val == 3) {
      score += SCORE_VAL_THREE;
    } else if (val == 4) {
      score += SCORE_VAL_FOUR;
    }
    return score;
  }

  /**
   * Method that sorts the hashmap of students mapping to their match score in descending order.
   *
   * @param studentMap - the hashmap of students to their match score
   * @return - the sorted hashmap of students to their match score
   */
  public ArrayList<Student> sortStudentList(HashMap<Student, Integer> studentMap) {
    List<Map.Entry<Student, Integer>> list = new LinkedList<>(studentMap.entrySet());
    list.sort(Map.Entry.comparingByValue(new ScoreCompare()));
    ArrayList<Student> sortedStudentList = new ArrayList<>();
    for (Map.Entry<Student, Integer> entry : list) {
      sortedStudentList.add(entry.getKey());
    }
    return sortedStudentList;
  }

  /**
   * Method that calculates multiple best matches in order for the correct student.
   *
   * @return - a list of best match study buddies
   */
  public List<Student> getBestMatchList() {
    List<Student> bestMatches = new ArrayList<>();
    List<Student> allMatches = sortStudentList(calcScores());
    int iter = 0;
    while (iter < this.numMatches && iter < allMatches.size()) {
      bestMatches.add(allMatches.get(iter));
      iter++;
    }
    return bestMatches;
  }
}
