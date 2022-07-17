package edu.brown.cs.student.main.CommandHelpers;

import edu.brown.cs.student.main.Objects.Student;

import java.util.HashMap;
import java.util.List;

/**
 * Record that calculates the potential matches of the current student and shared course.
 *
 * @param student1 - the first student
 * @param student2 - the second student
 */
public record PotentialMatchCalculator(Student student1, Student student2) {

  /**
   * Method that checks that the overlap of the two student's time slots is greater than both
   * student's minimum hours.
   *
   * @return - boolean indicating whether the overlap of the two student's time slots are is greater
   * than both student's minimum hours.
   */
  public boolean checkMatch() {
    int overlap = checkOverlap(this.student1.getTimeSlots(), this.student2.getTimeSlots());
    return overlap > this.student1.getMinHours() && overlap > this.student2.getMinHours();
  }

  /**
   * Method that calculates the time overlap of two students timeslots.
   *
   * @param timeSlots1 - the timeslots of the first student.
   * @param timeSlots2 - the time slots of the second student.
   * @return - the int representing how many hours of overlap there are between the two student's
   * time slots
   */
  public int checkOverlap(HashMap<String, List<Integer[]>> timeSlots1,
                          HashMap<String, List<Integer[]>> timeSlots2) {
    String[] days =
        new String[] {"sunday", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday"};
    int overlap = 0;
    for (String day : days) {
      List<Integer[]> slot1 = timeSlots1.get(day);
      List<Integer[]> slot2 = timeSlots2.get(day);
      if (!slot1.isEmpty() && !slot2.isEmpty()) {
        for (Integer[] slotOne : slot1) {
          for (Integer[] slotTwo : slot2) {
            if (slotOne[0] < slotTwo[1] && slotOne[1] > slotTwo[0]) {
              overlap += Math.min(slotOne[1], slotTwo[1]) - Math.max(slotOne[0], slotTwo[0]);
            }
          }
        }
      }
    }
    return overlap;
  }
}
