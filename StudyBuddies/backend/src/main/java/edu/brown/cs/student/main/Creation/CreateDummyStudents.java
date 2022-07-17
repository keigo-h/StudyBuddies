package edu.brown.cs.student.main.Creation;

import com.mongodb.client.MongoCollection;
import edu.brown.cs.student.main.Connection.DatabaseConnect;
import edu.brown.cs.student.main.Enums.Location;
import edu.brown.cs.student.main.Enums.PersonalityType;
import edu.brown.cs.student.main.Enums.Sex;
import edu.brown.cs.student.main.Enums.StudySpace;
import edu.brown.cs.student.main.Objects.Course;
import edu.brown.cs.student.main.Objects.Student;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static edu.brown.cs.student.main.Enums.Location.MidCampus;
import static edu.brown.cs.student.main.Enums.Location.NorthCampus;
import static edu.brown.cs.student.main.Enums.Location.OffCampus;
import static edu.brown.cs.student.main.Enums.Location.SouthCampus;
import static edu.brown.cs.student.main.Enums.PersonalityType.ENFJ;
import static edu.brown.cs.student.main.Enums.PersonalityType.ENFP;
import static edu.brown.cs.student.main.Enums.PersonalityType.ENTJ;
import static edu.brown.cs.student.main.Enums.PersonalityType.ENTP;
import static edu.brown.cs.student.main.Enums.PersonalityType.ESFJ;
import static edu.brown.cs.student.main.Enums.PersonalityType.ESFP;
import static edu.brown.cs.student.main.Enums.PersonalityType.ESTJ;
import static edu.brown.cs.student.main.Enums.PersonalityType.ESTP;
import static edu.brown.cs.student.main.Enums.PersonalityType.INFJ;
import static edu.brown.cs.student.main.Enums.PersonalityType.INFP;
import static edu.brown.cs.student.main.Enums.PersonalityType.INTJ;
import static edu.brown.cs.student.main.Enums.PersonalityType.INTP;
import static edu.brown.cs.student.main.Enums.PersonalityType.ISFJ;
import static edu.brown.cs.student.main.Enums.PersonalityType.ISFP;
import static edu.brown.cs.student.main.Enums.PersonalityType.ISTJ;
import static edu.brown.cs.student.main.Enums.PersonalityType.ISTP;
import static edu.brown.cs.student.main.Enums.Sex.Female;
import static edu.brown.cs.student.main.Enums.Sex.Male;
import static edu.brown.cs.student.main.Enums.Sex.None;
import static edu.brown.cs.student.main.Enums.Sex.Other;
import static edu.brown.cs.student.main.Enums.StudySpace.Bedroom;
import static edu.brown.cs.student.main.Enums.StudySpace.CIT;
import static edu.brown.cs.student.main.Enums.StudySpace.GradCenter;
import static edu.brown.cs.student.main.Enums.StudySpace.MainGreen;
import static edu.brown.cs.student.main.Enums.StudySpace.MoChamp;
import static edu.brown.cs.student.main.Enums.StudySpace.Ratty;
import static edu.brown.cs.student.main.Enums.StudySpace.Rock;
import static edu.brown.cs.student.main.Enums.StudySpace.SciLi;

/**
 * class which creates dummy students.
 */
public class CreateDummyStudents {
  private static final int EIGHT = 8;
  private static final int TEN = 10;
  private static final int SIXTEEN = 16;
  private static final int TWENTY_FOUR = 24;
  private static final int NUM_ITER = 100;

  /**
   * method which will insert the Student objects into the database.
   */
  public void insertStudents() {
    List<Student> lst = makeStudents();
    DatabaseConnect dbc = new DatabaseConnect();
//    MongoCollection<Document> collection = dbc.databaseConnect("CourseDB", "bestMatchStudents");
    MongoCollection<Document> collection = dbc.databaseConnect("CourseDB", "frontEndStudents");
    HandleStudent handleStudent = new HandleStudent();
    for (Student s : lst) {
      collection.insertOne(handleStudent.studentToDocument(s));
    }
    dbc.close();
  }

  /**
   * method which creates Student objects.
   *
   * @return a list of Student objects
   */
  public List<Student> makeStudents() {
    int iter = 0;
    List<Student> stdntLst = new ArrayList<>();
    CreateDummyCourses cc = new CreateDummyCourses();
    List<Course> lst = cc.createCourseList();
    //number of students
    while (iter < NUM_ITER) {
      String first = randomStringGenerator(3);
      String last = randomStringGenerator(5);
      String name = first + " " + last;
      String email = first + "_" + last + "@brown.edu";
      HashMap<String, List<Integer[]>> timeslotsv2 = timeslotGeneratorv2(iter);
      List<Course> studentCourseList = makeStudentCourses(lst);
      boolean gradetype = randomBoolean();
      String year = randomClassYear();
      String concentration = randomConcentration();
      Location loc = randomLocation();
      boolean athlete = randomBoolean();
      StudySpace space = randomStudySpace();
      Sex sex = randomSex(true);
      HashMap<String, Integer> preferences = preferences();
      int minTime = randomInt(0, TEN);
      Student s = new Student(name, email);
      s.setMinHours(minTime);
      s.setTimeSlots(timeslotsv2);
      s.setCourseList(studentCourseList);
      s.setSncGrade(gradetype);
      s.setClassYear(year);
      s.setConcentration(concentration);
      s.setPersonalityType(getRandomPersonality());
      s.setLocation(loc);
      s.setAthlete(athlete);
      s.setStudySpace(space);
      s.setSex(sex);
      s.setPreferences(preferences);

      s.setPrefSncGrade(randomBoolean());
      s.setPrefClassYear(randomClassYear());
      s.setPrefConcentration(randomConcentration());
      s.setPrefPersonality(getRandomPersonality());
      s.setPrefLoc(randomLocation());
      s.setPrefAthlete(randomBoolean());
      s.setPrefStudySpace(randomStudySpace());
      s.setPrefSex(randomSex(false));
      stdntLst.add(s);
      iter++;
    }
    return stdntLst;
  }

  /**
   * creates random strings for creating random names.
   * https://www.programiz.com/java-programming/examples/generate-random-string
   *
   * @param length the length of the name will be 3 for first 5 for last
   * @return a random string of length length
   */
  public String randomStringGenerator(int length) {
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    StringBuilder stringBuilder = new StringBuilder();
    Random r = new Random();
    for (int i = 0; i < length; i++) {
      // generate random index number
      int index = r.nextInt(alphabet.length());
      // get character specified by index
      // from the string
      char randomChar = alphabet.charAt(index);
      // append the character to string builder
      stringBuilder.append(randomChar);
    }
    return stringBuilder.toString();
  }

  /**
   * creates random timeslots for each day.
   *
   * @param iter the iteration, this is for manually making certain students have no timeslots
   * @return a hashmap of day of week to a list of integer arrays of size 2
   */
  public HashMap<String, List<Integer[]>> timeslotGeneratorv2(int iter) {
    String[] days =
        new String[] {"sunday", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday"};
    HashMap<String, List<Integer[]>> timeSlot = new HashMap<>();
    Random r = new Random();
    for (String day : days) {
      List<Integer[]> lst = new ArrayList<>();
      if (iter == 2 || iter == 4) {
        timeSlot.put(day, lst);
      } else {
        int[] numIter = new int[] {EIGHT, SIXTEEN, TWENTY_FOUR};
        int chance = r.nextInt(3);
        for (int i = 0; i < numIter.length; i++) {
          if (chance > 0) {
            int time1 = r.nextInt(numIter[i]);
            int time2 = r.nextInt(numIter[i]);
            while (time1 == time2) {
              time2 = r.nextInt(numIter[i]);
            }
            Integer[] times = new Integer[] {time1, time2};
            Arrays.sort(times);
            lst.add(times);
          }
        }
        timeSlot.put(day, lst);
      }
    }
    return timeSlot;
  }

  /**
   * method which selects 3-5 random courses for a student.
   *
   * @param courseList the list of course possible
   * @return a random selection of 3-5 courses.
   */
  public List<Course> makeStudentCourses(List<Course> courseList) {
    List<Course> studentList = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    int numClasses = randomInt(3, 5);
    while (set.size() < numClasses) {
      int classIndex = randomInt(0, 5);
      while (set.contains(classIndex)) {
        classIndex = randomInt(0, 5);
      }
      set.add(classIndex);
      studentList.add(courseList.get(classIndex));
    }
    return studentList;
  }

  /**
   * creates a random personality.
   *
   * @return a random personality
   */
  public PersonalityType getRandomPersonality() {
    PersonalityType[] personality =
        new PersonalityType[] {ISTJ, ISTP, ISFJ, ISFP, INFJ, INFP, INTJ, INTP, ESTP, ESTJ, ESFP,
            ESFJ, ENFP, ENFJ, ENTP, ENTJ};
    int index = randomInt(0, personality.length - 1);
    return personality[index];
  }

  /**
   * a random boolean generator for boolean fields.
   *
   * @return true or false
   */
  public boolean randomBoolean() {
    int rando = randomInt(0, 1);
    return rando == 0;
  }

  /**
   * selects a random class year.
   *
   * @return a string representation of class year
   */
  public String randomClassYear() {
    String[] year = new String[] {"2023", "2024", "2025", "2026"};
    int index = randomInt(0, year.length - 1);
    return year[index];
  }

  /**
   * selects a random concentration.
   *
   * @return string representation of the concentration
   */
  public String randomConcentration() {
    String[] concentration = new String[] {"ECON", "MATH", "CSCI", "BIOL", "APMA"};
    int index = randomInt(0, concentration.length - 1);
    return concentration[index];
  }

  /**
   * selects a random Location enum.
   *
   * @return Location enum
   */
  public Location randomLocation() {
    Location[] locations = new Location[] {NorthCampus, MidCampus, SouthCampus, OffCampus};
    int index = randomInt(0, locations.length - 1);
    return locations[index];
  }

  /**
   * selects a random StudySpace enum.
   *
   * @return StudySpace enum
   */
  public StudySpace randomStudySpace() {
    StudySpace[] studySpaces =
        new StudySpace[] {Rock, SciLi, CIT, Bedroom, MoChamp, Ratty, MainGreen, GradCenter};
    int index = randomInt(0, studySpaces.length - 1);
    return studySpaces[index];
  }

  /**
   * selects a random Sex enum.
   *
   * @param user - if user more options
   * @return Sex enum
   */
  public Sex randomSex(boolean user) {
    Sex[] sexes = new Sex[] {Male, Female, Other, None};
    int index;
    if (user) {
      index = randomInt(0, sexes.length - 1);
    } else {
      index = randomInt(0, sexes.length - 2);
    }
    return sexes[index];
  }

  /**
   * a hashmap for random preference weights.
   *
   * @return a hashmap of preference to weight
   */
  public HashMap<String, Integer> preferences() {
    HashMap<String, Integer> prefer = new HashMap<>();
    prefer.put("snc", randomInt(0, 4));
    prefer.put("class", randomInt(0, 4));
    prefer.put("concentration", randomInt(0, 4));
    prefer.put("personality", randomInt(0, 4));
    prefer.put("location", randomInt(0, 4));
    prefer.put("athlete", randomInt(0, 4));
    prefer.put("studySpace", randomInt(0, 4));
    prefer.put("gender", randomInt(0, 4));
    return prefer;
  }

  /**
   * random int generator.
   *
   * @param start the min value
   * @param end   the max value
   * @return a random int between start and end
   */
  public int randomInt(int start, int end) {
    Random r = new Random();
    return r.nextInt((end - start) + 1) + start;
  }

}
