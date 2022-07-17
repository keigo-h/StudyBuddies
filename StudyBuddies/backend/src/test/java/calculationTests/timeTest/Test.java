package calculationTests.timeTest;

import edu.brown.cs.student.main.CommandHelpers.CourseSharingCalculator;
import edu.brown.cs.student.main.CommandHelpers.PotentialMatchCalculator;
import edu.brown.cs.student.main.Objects.Course;
import edu.brown.cs.student.main.Objects.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.mongodb.internal.connection.tlschannel.util.Util.assertTrue;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;

public class Test {
  @org.junit.Test
  public void testOverlap1() {
    HashMap<String, List<Integer[]>> t1 = new HashMap<>();
    List<Integer[]> sun1 = new ArrayList<>();
    sun1.add(new Integer[]{1,8});
    t1.put("sunday", sun1);
    List<Integer[]> mon1 = new ArrayList<>();
    t1.put("monday", mon1);
    List<Integer[]> tue1 = new ArrayList<>();
    t1.put("tuesday", tue1);
    List<Integer[]> wed1 = new ArrayList<>();
    t1.put("wednesday", wed1);
    List<Integer[]> thur1 = new ArrayList<>();
    t1.put("thursday", thur1);
    List<Integer[]> fri1 = new ArrayList<>();
    t1.put("friday", fri1);
    List<Integer[]> sat1 = new ArrayList<>();
    t1.put("saturday", sat1);
    HashMap<String, List<Integer[]>> t2 = new HashMap<>();
    List<Integer[]> sun2 = new ArrayList<>();
    sun2.add(new Integer[]{5,9});
    t2.put("sunday", sun2);
    List<Integer[]> mon2 = new ArrayList<>();
    t2.put("monday", mon2);
    List<Integer[]> tue2 = new ArrayList<>();
    t2.put("tuesday", tue2);
    List<Integer[]> wed2 = new ArrayList<>();
    t2.put("wednesday", wed2);
    List<Integer[]> thur2 = new ArrayList<>();
    t2.put("thursday", thur2);
    List<Integer[]> fri2 = new ArrayList<>();
    t2.put("friday", fri2);
    List<Integer[]> sat2 = new ArrayList<>();
    t2.put("saturday", sat2);
    PotentialMatchCalculator pmc = new PotentialMatchCalculator(null,null);
    int lap = pmc.checkOverlap(t1, t2);
    assertEquals(3,lap);
  }

  @org.junit.Test
  public void testOverlap2() {
    HashMap<String, List<Integer[]>> t1 = new HashMap<>();
    List<Integer[]> sun1 = new ArrayList<>();
    sun1.add(new Integer[]{1,8});
    sun1.add(new Integer[]{10,12});
    sun1.add(new Integer[]{15,18});
    t1.put("sunday", sun1);
    List<Integer[]> mon1 = new ArrayList<>();
    t1.put("monday", mon1);
    List<Integer[]> tue1 = new ArrayList<>();
    t1.put("tuesday", tue1);
    List<Integer[]> wed1 = new ArrayList<>();
    t1.put("wednesday", wed1);
    List<Integer[]> thur1 = new ArrayList<>();
    t1.put("thursday", thur1);
    List<Integer[]> fri1 = new ArrayList<>();
    t1.put("friday", fri1);
    List<Integer[]> sat1 = new ArrayList<>();
    t1.put("saturday", sat1);
    HashMap<String, List<Integer[]>> t2 = new HashMap<>();
    List<Integer[]> sun2 = new ArrayList<>();
    sun2.add(new Integer[]{5,11});
    sun2.add(new Integer[]{16,17});
    t2.put("sunday", sun2);
    List<Integer[]> mon2 = new ArrayList<>();
    t2.put("monday", mon2);
    List<Integer[]> tue2 = new ArrayList<>();
    t2.put("tuesday", tue2);
    List<Integer[]> wed2 = new ArrayList<>();
    t2.put("wednesday", wed2);
    List<Integer[]> thur2 = new ArrayList<>();
    t2.put("thursday", thur2);
    List<Integer[]> fri2 = new ArrayList<>();
    t2.put("friday", fri2);
    List<Integer[]> sat2 = new ArrayList<>();
    t2.put("saturday", sat2);
    PotentialMatchCalculator pmc = new PotentialMatchCalculator(null,null);
    int lap = pmc.checkOverlap(t1, t2);
    assertEquals(5,lap);
  }

  @org.junit.Test
  public void testOverlap3() {
    HashMap<String, List<Integer[]>> t1 = new HashMap<>();
    List<Integer[]> sun1 = new ArrayList<>();
    sun1.add(new Integer[]{1,8});
    sun1.add(new Integer[]{10,12});
    sun1.add(new Integer[]{15,18});
    t1.put("sunday", sun1);
    List<Integer[]> mon1 = new ArrayList<>();
    t1.put("monday", mon1);
    List<Integer[]> tue1 = new ArrayList<>();
    t1.put("tuesday", tue1);
    List<Integer[]> wed1 = new ArrayList<>();
    t1.put("wednesday", wed1);
    List<Integer[]> thur1 = new ArrayList<>();
    t1.put("thursday", thur1);
    List<Integer[]> fri1 = new ArrayList<>();
    t1.put("friday", fri1);
    List<Integer[]> sat1 = new ArrayList<>();
    t1.put("saturday", sat1);
    HashMap<String, List<Integer[]>> t2 = new HashMap<>();
    List<Integer[]> sun2 = new ArrayList<>();
    sun2.add(new Integer[]{20,23});
    t2.put("sunday", sun2);
    List<Integer[]> mon2 = new ArrayList<>();
    t2.put("monday", mon2);
    List<Integer[]> tue2 = new ArrayList<>();
    t2.put("tuesday", tue2);
    List<Integer[]> wed2 = new ArrayList<>();
    t2.put("wednesday", wed2);
    List<Integer[]> thur2 = new ArrayList<>();
    t2.put("thursday", thur2);
    List<Integer[]> fri2 = new ArrayList<>();
    t2.put("friday", fri2);
    List<Integer[]> sat2 = new ArrayList<>();
    t2.put("saturday", sat2);
    PotentialMatchCalculator pmc = new PotentialMatchCalculator(null,null);
    int lap = pmc.checkOverlap(t1, t2);
    assertEquals(0,lap);
  }

  @org.junit.Test
  public void testOverlap4() {
    HashMap<String, List<Integer[]>> t1 = new HashMap<>();
    List<Integer[]> sun1 = new ArrayList<>();
    sun1.add(new Integer[]{1,8});
    sun1.add(new Integer[]{10,12});
    sun1.add(new Integer[]{15,18});
    t1.put("sunday", sun1);
    List<Integer[]> mon1 = new ArrayList<>();
    t1.put("monday", mon1);
    List<Integer[]> tue1 = new ArrayList<>();
    t1.put("tuesday", tue1);
    List<Integer[]> wed1 = new ArrayList<>();
    t1.put("wednesday", wed1);
    List<Integer[]> thur1 = new ArrayList<>();
    t1.put("thursday", thur1);
    List<Integer[]> fri1 = new ArrayList<>();
    t1.put("friday", fri1);
    List<Integer[]> sat1 = new ArrayList<>();
    t1.put("saturday", sat1);
    HashMap<String, List<Integer[]>> t2 = new HashMap<>();
    List<Integer[]> sun2 = new ArrayList<>();
    sun2.add(new Integer[]{1,8});
    sun2.add(new Integer[]{10,12});
    sun2.add(new Integer[]{15,18});
    t2.put("sunday", sun2);
    List<Integer[]> mon2 = new ArrayList<>();
    t2.put("monday", mon2);
    List<Integer[]> tue2 = new ArrayList<>();
    t2.put("tuesday", tue2);
    List<Integer[]> wed2 = new ArrayList<>();
    t2.put("wednesday", wed2);
    List<Integer[]> thur2 = new ArrayList<>();
    t2.put("thursday", thur2);
    List<Integer[]> fri2 = new ArrayList<>();
    t2.put("friday", fri2);
    List<Integer[]> sat2 = new ArrayList<>();
    t2.put("saturday", sat2);
    PotentialMatchCalculator pmc = new PotentialMatchCalculator(null,null);
    int lap = pmc.checkOverlap(t1, t2);
    assertEquals(12,lap);
  }

  @org.junit.Test
  public void testSharing1() {
    List<Course> courseList1 = new ArrayList<>();
    courseList1.add(new Course("econ", "100"));
    courseList1.add(new Course("econ", "300"));
    courseList1.add(new Course("econ", "200"));
    courseList1.add(new Course("cs", "1000"));
    Student dylan = new Student("dylan", "dylan@email.com");
    dylan.setCourseList(courseList1);
    Student keigo = new Student("keigo", "keigo@email.com");
    keigo.setCourseList(courseList1);
    for (Course course: courseList1) {
      CourseSharingCalculator csc = new CourseSharingCalculator(dylan, keigo, course);
      assertTrue(csc.checkSharedCourse());
    }
  }

  @org.junit.Test
  public void testSharing2() {
    List<Course> courseList1 = new ArrayList<>();
    List<Course> courseList2 = new ArrayList<>();
    courseList1.add(new Course("econ", "100"));
    courseList1.add(new Course("econ", "300"));
    courseList1.add(new Course("econ", "200"));
    courseList1.add(new Course("cs", "1000"));
    Student dylan = new Student("dylan", "dylan@email.com");
    dylan.setCourseList(courseList1);
    Student keigo = new Student("keigo", "keigo@email.com");
    keigo.setCourseList(courseList2);
    for (Course course: courseList1) {
      CourseSharingCalculator csc = new CourseSharingCalculator(dylan, keigo, course);
      assertFalse(csc.checkSharedCourse());
    }
  }

  @org.junit.Test
  public void testSharing3() {
    List<Course> courseList1 = new ArrayList<>();
    List<Course> courseList2 = new ArrayList<>();
    courseList1.add(new Course("econ", "100"));
    courseList1.add(new Course("econ", "300"));
    courseList1.add(new Course("econ", "200"));
    courseList1.add(new Course("cs", "1000"));
    courseList2.add(new Course("cs", "100"));
    courseList2.add(new Course("cs", "300"));
    courseList2.add(new Course("cs", "200"));
    courseList2.add(new Course("econ", "1000"));
    Student dylan = new Student("dylan", "dylan@email.com");
    dylan.setCourseList(courseList1);
    Student keigo = new Student("keigo", "keigo@email.com");
    keigo.setCourseList(courseList2);
    for (Course course: courseList2) {
      CourseSharingCalculator csc = new CourseSharingCalculator(dylan, keigo, course);
      assertFalse(csc.checkSharedCourse());
    }
  }
}
