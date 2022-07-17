package edu.brown.cs.student.main.Objects;

/**
 * Class representing the matched student.
 * Data is extracted to maintain privacy
 */
public class MatchStudent {
  private final String name;
  private final String email;
  private final String classYear;

  /**
   * Constructor for a match student.
   *
   * @param name      the name of the student
   * @param email     the email of the student
   * @param classYear
   */
  public MatchStudent(String name, String email, String classYear) {
    this.name = name;
    this.email = email;
    this.classYear = classYear;
  }
}
