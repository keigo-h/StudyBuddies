package edu.brown.cs.student.main.Creation;

import edu.brown.cs.student.main.Enums.Location;
import edu.brown.cs.student.main.Enums.PersonalityType;
import edu.brown.cs.student.main.Enums.Sex;
import edu.brown.cs.student.main.Enums.StudySpace;
import edu.brown.cs.student.main.Objects.Course;
import edu.brown.cs.student.main.Objects.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * class which creates specific students for testing.
 */
public class CreateTestStudents {
  private static final int EIGHT = 8;

  /**
   * makes a list of students.
   *
   * @return a list of students
   */
  public List<Student> studentList() {
    List<Student> retList = new ArrayList<>();
    retList.add(makeStudent1());
    retList.add(makeStudent2());
    retList.add(makeStudent3());
    return retList;
  }

  /**
   * student 1.
   *
   * @return a student object
   */
  public Student makeStudent1() {
    CreateDummyCourses cc = new CreateDummyCourses();
    List<Course> courseLst = cc.createCourseList();
    Student s1 = new Student("apple pie", "apple_pie@brown.edu");
    HashMap<String, List<Integer[]>> timeslots = new HashMap<>();
    List<Integer[]> monTime = new ArrayList<>();
    monTime.add(new Integer[] {3, EIGHT});
    timeslots.put("monday", monTime);
    List<Integer[]> sunTime = new ArrayList<>();
    timeslots.put("sunday", sunTime);
    List<Integer[]> tueTime = new ArrayList<>();
    timeslots.put("tuesday", tueTime);
    List<Integer[]> wedTime = new ArrayList<>();
    timeslots.put("wednesday", wedTime);
    List<Integer[]> thurTime = new ArrayList<>();
    timeslots.put("thursday", thurTime);
    List<Integer[]> friTime = new ArrayList<>();
    timeslots.put("friday", friTime);
    List<Integer[]> satTime = new ArrayList<>();
    timeslots.put("saturday", satTime);
    List<Course> studentCourseList = new ArrayList<>();
    studentCourseList.add(courseLst.get(0));
    boolean gradetype = true;
    String year = "2023";
    String concentration = "APMA";
    Location loc = Location.NorthCampus;
    boolean athlete = true;
    StudySpace space = StudySpace.Rock;
    Sex sex = Sex.Male;
    HashMap<String, Integer> prefer = new HashMap<>();
    prefer.put("snc", 0);
    prefer.put("class", 0);
    prefer.put("concentration", 0);
    prefer.put("personality", 0);
    prefer.put("location", 4);
    prefer.put("athlete", 0);
    prefer.put("studySpace", 4);
    prefer.put("gender", 0);
    int minTime = 3;
    s1.setMinHours(minTime);
    s1.setTimeSlots(timeslots);
    s1.setCourseList(studentCourseList);
    s1.setSncGrade(gradetype);
    s1.setClassYear(year);
    s1.setConcentration(concentration);
    s1.setPersonalityType(PersonalityType.ENTJ);
    s1.setLocation(loc);
    s1.setAthlete(athlete);
    s1.setStudySpace(space);
    s1.setSex(sex);
    s1.setPreferences(prefer);
    s1.setPrefSncGrade(gradetype);
    s1.setPrefClassYear(year);
    s1.setPrefConcentration(concentration);
    s1.setPrefPersonality(PersonalityType.ENFJ);
    s1.setPrefLoc(Location.SouthCampus);
    s1.setPrefAthlete(athlete);
    s1.setPrefStudySpace(space);
    s1.setPrefSex(sex);
    return s1;
  }

  /**
   * student 2.
   *
   * @return a student object
   */
  public Student makeStudent2() {
    CreateDummyCourses cc = new CreateDummyCourses();
    List<Course> courseLst = cc.createCourseList();
    Student s1 = new Student("rice cake", "rice_cake@brown.edu");
    HashMap<String, List<Integer[]>> timeslots = new HashMap<>();
    List<Integer[]> monTime = new ArrayList<>();
    monTime.add(new Integer[] {3, EIGHT});
    timeslots.put("monday", monTime);
    List<Integer[]> sunTime = new ArrayList<>();
    timeslots.put("sunday", sunTime);
    List<Integer[]> tueTime = new ArrayList<>();
    timeslots.put("tuesday", tueTime);
    List<Integer[]> wedTime = new ArrayList<>();
    timeslots.put("wednesday", wedTime);
    List<Integer[]> thurTime = new ArrayList<>();
    timeslots.put("thursday", thurTime);
    List<Integer[]> friTime = new ArrayList<>();
    timeslots.put("friday", friTime);
    List<Integer[]> satTime = new ArrayList<>();
    timeslots.put("saturday", satTime);
    List<Course> studentCourseList = new ArrayList<>();
    studentCourseList.add(courseLst.get(0));
    boolean gradetype = true;
    String year = "2023";
    String concentration = "APMA";
    Location loc = Location.NorthCampus;
    boolean athlete = true;
    StudySpace space = StudySpace.SciLi;
    Sex sex = Sex.Male;
    HashMap<String, Integer> prefer = new HashMap<>();
    prefer.put("snc", 0);
    prefer.put("class", 0);
    prefer.put("concentration", 0);
    prefer.put("personality", 0);
    prefer.put("location", 0);
    prefer.put("athlete", 0);
    prefer.put("studySpace", 0);
    prefer.put("gender", 0);
    int minTime = 3;
    s1.setMinHours(minTime);
    s1.setTimeSlots(timeslots);
    s1.setCourseList(studentCourseList);
    s1.setSncGrade(gradetype);
    s1.setClassYear(year);
    s1.setConcentration(concentration);
    s1.setPersonalityType(PersonalityType.ENTJ);
    s1.setLocation(loc);
    s1.setAthlete(athlete);
    s1.setStudySpace(space);
    s1.setSex(sex);
    s1.setPreferences(prefer);
    s1.setPrefSncGrade(gradetype);
    s1.setPrefClassYear(year);
    s1.setPrefConcentration(concentration);
    s1.setPrefPersonality(PersonalityType.INTP);
    s1.setPrefLoc(loc);
    s1.setPrefAthlete(athlete);
    s1.setPrefStudySpace(space);
    s1.setPrefSex(sex);
    return s1;
  }

  /**
   * student 3.
   *
   * @return a student object
   */
  public Student makeStudent3() {
    CreateDummyCourses cc = new CreateDummyCourses();
    List<Course> courseLst = cc.createCourseList();
    Student s1 = new Student("cheese cake", "cheese_cake@brown.edu");
    HashMap<String, List<Integer[]>> timeslots = new HashMap<>();
    List<Integer[]> monTime = new ArrayList<>();
    monTime.add(new Integer[] {3, EIGHT});
    timeslots.put("monday", monTime);
    List<Integer[]> sunTime = new ArrayList<>();
    timeslots.put("sunday", sunTime);
    List<Integer[]> tueTime = new ArrayList<>();
    timeslots.put("tuesday", tueTime);
    List<Integer[]> wedTime = new ArrayList<>();
    timeslots.put("wednesday", wedTime);
    List<Integer[]> thurTime = new ArrayList<>();
    timeslots.put("thursday", thurTime);
    List<Integer[]> friTime = new ArrayList<>();
    timeslots.put("friday", friTime);
    List<Integer[]> satTime = new ArrayList<>();
    timeslots.put("saturday", satTime);
    List<Course> studentCourseList = new ArrayList<>();
    studentCourseList.add(courseLst.get(0));
    boolean gradetype = true;
    String year = "2023";
    String concentration = "APMA";
    Location loc = Location.SouthCampus;
    boolean athlete = true;
    StudySpace space = StudySpace.MoChamp;
    Sex sex = Sex.Male;
    HashMap<String, Integer> prefer = new HashMap<>();
    prefer.put("snc", 0);
    prefer.put("class", 0);
    prefer.put("concentration", 0);
    prefer.put("personality", 0);
    prefer.put("location", 4);
    prefer.put("athlete", 0);
    prefer.put("studySpace", 0);
    prefer.put("gender", 0);
    int minTime = 3;
    s1.setMinHours(minTime);
    s1.setTimeSlots(timeslots);
    s1.setCourseList(studentCourseList);
    s1.setSncGrade(gradetype);
    s1.setClassYear(year);
    s1.setConcentration(concentration);
    s1.setPersonalityType(PersonalityType.INFJ);
    s1.setLocation(loc);
    s1.setAthlete(athlete);
    s1.setStudySpace(space);
    s1.setSex(sex);
    s1.setPreferences(prefer);
    s1.setPrefSncGrade(gradetype);
    s1.setPrefClassYear(year);
    s1.setPrefConcentration(concentration);
    s1.setPrefPersonality(PersonalityType.ENTJ);
    s1.setPrefLoc(loc);
    s1.setPrefAthlete(athlete);
    s1.setPrefStudySpace(space);
    s1.setPrefSex(sex);
    return s1;
  }
}
