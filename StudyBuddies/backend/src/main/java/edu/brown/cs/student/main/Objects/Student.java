package edu.brown.cs.student.main.Objects;

import edu.brown.cs.student.main.Enums.Location;
import edu.brown.cs.student.main.Enums.PersonalityType;
import edu.brown.cs.student.main.Enums.Sex;
import edu.brown.cs.student.main.Enums.StudySpace;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Student {

  private final String name;
  private final String email;

  private List<Course> courseList;
  private HashMap<String, List<Integer[]>> timeSlots;
  private int minHours;

  //  private String personality;
  private boolean sncGrade;
  private String classYear;
  private String concentration;
  private PersonalityType personalityType;
  private Location location;
  private boolean athlete;
  private StudySpace studySpace;
  private Sex sex;

  private boolean prefSncGrade;
  private String prefClassYear;
  private String prefConcentration;
  private PersonalityType prefPersonality;
  private Location prefLoc;
  private boolean prefAthlete;
  private StudySpace prefStudySpace;
  private Sex prefSex;

  /**
   * class representing the student.
   *
   * @param name  the name of the student
   * @param email the email of the student
   */
  public Student(String name, String email) {
    this.courseMatches = new HashMap<>();
    this.name = name;
    this.email = email;
  }

  private Map<String, List<MatchStudent>> courseMatches;
  private HashMap<String, Integer> preferences;

  /**
   * method to get the value of a specific field given a string value.
   *
   * @param preference the name of the field
   * @return the value of the septic field.
   */
  public Object getField(String preference) {
    return switch (preference) {
      case "snc" -> getSncGrade();
      case "class" -> getClassYear();
      case "concentration" -> getConcentration();
      case "personality" -> getPersonalityType();
      case "location" -> getLocation();
      case "athlete" -> getAthlete();
      case "studySpace" -> getStudySpace();
      case "gender" -> getSex();
      default -> throw new IllegalArgumentException("invalid input");
    };
  }

  /**
   * method to get the value of a specific preferred field given a string value.
   *
   * @param preference the name of the field
   * @return the value of the septic field.
   */
  public Object getPrefField(String preference) {
    return switch (preference) {
      case "snc" -> getPrefSncGrade();
      case "class" -> getPrefClassYear();
      case "concentration" -> getPrefConcentration();
      case "personality" -> getPrefPersonality();
      case "location" -> getPrefLoc();
      case "athlete" -> getPrefAthlete();
      case "studySpace" -> getPrefStudySpace();
      case "gender" -> getPrefSex();
      default -> throw new IllegalArgumentException("invalid input");
    };
  }

  /**
   * gets the name of the student.
   *
   * @return the name of the student
   */
  public String getName() {
    return name;
  }

  /**
   * gets the email of the student.
   *
   * @return the email of the student
   */
  public String getEmail() {
    return email;
  }

  /**
   * gets the course list of the student.
   *
   * @return a list of course objects
   */
  public List<Course> getCourseList() {
    return courseList;
  }

  /**
   * gets the students timeslots.
   *
   * @return a hashmap of day to availalbe timeslots
   */
  public HashMap<String, List<Integer[]>> getTimeSlots() {
    return timeSlots;
  }

  /**
   * gets the grade-mode of the student. True if snc false otherwise.
   *
   * @return True if snc false otherwise
   */
  public boolean getSncGrade() {
    return sncGrade;
  }

  /**
   * get the min hours of a student.
   *
   * @return the min hours of a student
   */
  public int getMinHours() {
    return minHours;
  }

  /**
   * gets the class year of the student.
   *
   * @return the class year of the student
   */
  public String getClassYear() {
    return classYear;
  }

  /**
   * gets the concentration of the student.
   *
   * @return the student's concentration
   */
  public String getConcentration() {
    return concentration;
  }

  /**
   * gets the location of the student.
   *
   * @return Location of the student
   */
  public Location getLocation() {
    return location;
  }

  /**
   * gets whether the student is an athlete or not.
   *
   * @return a boolean if true, false otherwise
   */
  public boolean getAthlete() {
    return athlete;
  }

  /**
   * gets the StudySpace of the student.
   *
   * @return studySpace ENUM of the student.
   */
  public StudySpace getStudySpace() {
    return studySpace;
  }

  /**
   * gets the gender of the student.
   *
   * @return ENUM Sex of the student's gender
   */
  public Sex getSex() {
    return sex;
  }

  /**
   * gets the personality type of the student.
   *
   * @return PersonalityType ENUM of the student
   */
  public PersonalityType getPersonalityType() {
    return this.personalityType;
  }

  /**
   * gets the preference map of the student.
   *
   * @return a hashmap of field to weight
   */
  public HashMap<String, Integer> getPreferences() {
    return preferences;
  }

  /**
   * sets the students courseList.
   *
   * @param courseList the students courseLsit
   */
  public void setCourseList(List<Course> courseList) {
    this.courseList = courseList;
  }

  /**
   * sets the time slots for the student.
   *
   * @param timeSlots timeslots of the student.
   */
  public void setTimeSlots(HashMap<String, List<Integer[]>> timeSlots) {
    this.timeSlots = timeSlots;
  }

  /**
   * sets the grading type for the student.
   *
   * @param sncGrade true if snc false otherwise
   */
  public void setSncGrade(boolean sncGrade) {
    this.sncGrade = sncGrade;
  }

  /**
   * sets the min hours the student is willing to work.
   *
   * @param minHours the min hours in int form
   */
  public void setMinHours(int minHours) {
    this.minHours = minHours;
  }

  /**
   * sets the class year for the student.
   *
   * @param classYear the class year of the student
   */
  public void setClassYear(String classYear) {
    this.classYear = classYear;
  }

  /**
   * sets the concentration of the student.
   *
   * @param concentration the concentration of the student
   */
  public void setConcentration(String concentration) {
    this.concentration = concentration;
  }

  /**
   * sets the location of the student.
   *
   * @param location the location of the student
   */
  public void setLocation(Location location) {
    this.location = location;
  }

  /**
   * sets whether if the student is an athlete or not.
   *
   * @param athlete true if athlete false otherwise.
   */
  public void setAthlete(boolean athlete) {
    this.athlete = athlete;
  }

  /**
   * sets the study space for the student.
   *
   * @param studySpace the study-space for the student
   */
  public void setStudySpace(StudySpace studySpace) {
    this.studySpace = studySpace;
  }

  /**
   * sets the gender of the student.
   *
   * @param sex the gender of the student
   */
  public void setSex(Sex sex) {
    this.sex = sex;
  }

  /**
   * sets the preference map for the student.
   *
   * @param preferences the preference hashmap for the student
   */
  public void setPreferences(HashMap<String, Integer> preferences) {
    this.preferences = preferences;
  }

  /**
   * sets the personality type for the student.
   *
   * @param personalityType the personality type of the studnet.
   */
  public void setPersonalityType(PersonalityType personalityType) {
    this.personalityType = personalityType;
  }

  /**
   * gets the students the student has matched in he past.
   *
   * @return a map of course to a list of matches.
   */
  public Map<String, List<MatchStudent>> getCourseMatches() {
    return this.courseMatches;
  }

  /**
   * gets the preferred grading type of the student.
   *
   * @return true if snc false otherwise
   */
  public boolean getPrefSncGrade() {
    return this.prefSncGrade;
  }

  /**
   * gets the preferred class year of the student.
   *
   * @return the class year
   */
  public String getPrefClassYear() {
    return this.prefClassYear;
  }

  /**
   * gets the preferred concentration of the student.
   *
   * @return the preferred concentration
   */
  public String getPrefConcentration() {
    return this.prefConcentration;
  }

  /**
   * gets the preferred personality of the student.
   *
   * @return the personality type of the student
   */
  public PersonalityType getPrefPersonality() {
    return this.prefPersonality;
  }

  /**
   * gets the preferred location of the student.
   *
   * @return the location of the student
   */
  public Location getPrefLoc() {
    return this.prefLoc;
  }

  /**
   * gets the preference of whether the student wants to be matched with an athlete of not.
   *
   * @return true if athlete false otherwise
   */
  public boolean getPrefAthlete() {
    return this.prefAthlete;
  }

  /**
   * gets the preferred study-space of the student.
   *
   * @return the preferred study-space of the student
   */
  public StudySpace getPrefStudySpace() {
    return this.prefStudySpace;
  }

  /**
   * gets the preferred gender of the student.
   *
   * @return the gender in SEX enum
   */
  public Sex getPrefSex() {
    return this.prefSex;
  }

  /**
   * sets the preferred grade mode of the student.
   *
   * @param pref true in snc false otherwise
   */
  public void setPrefSncGrade(boolean pref) {
    this.prefSncGrade = pref;
  }

  /**
   * sets the preferred class year of the student.
   *
   * @param pref the preferred class year of the student.
   */
  public void setPrefClassYear(String pref) {
    this.prefClassYear = pref;
  }

  /**
   * sets the preferred concentration of the student.
   *
   * @param pref the preferred concentration of the student
   */
  public void setPrefConcentration(String pref) {
    this.prefConcentration = pref;
  }

  /**
   * sets the preferred personality of the student.
   *
   * @param prefPersonality the preferred personality of the student.
   */
  public void setPrefPersonality(PersonalityType prefPersonality) {
    this.prefPersonality = prefPersonality;
  }

  /**
   * sets the preferred location of the student.
   *
   * @param pref Location ENUM of the preferred location of the student
   */
  public void setPrefLoc(Location pref) {
    this.prefLoc = pref;
  }

  /**
   * sets if the student prefers and athlete or not.
   *
   * @param pref true if athlete false otherwise
   */
  public void setPrefAthlete(boolean pref) {
    this.prefAthlete = pref;
  }

  /**
   * sets the preferred study space of the student.
   *
   * @param pref StudySpace ENUM of the preferred study space of the student.
   */
  public void setPrefStudySpace(StudySpace pref) {
    this.prefStudySpace = pref;
  }

  /**
   * sets the preferred gender of the student.
   *
   * @param pref Sex ENUM of the preferred gender of the student.
   */
  public void setPrefSex(Sex pref) {
    this.prefSex = pref;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Student student = (Student) o;
    return Objects.equals(name, student.name)
        && Objects.equals(email, student.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, email);
  }
}
