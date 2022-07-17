package edu.brown.cs.student.main.CommandHelpers;

import java.util.Comparator;
import java.util.Objects;
import java.util.Random;

/**
 * Class that compares student match scores which randomizes ties.
 */
public class ScoreCompare implements Comparator<Integer> {
  @Override
  public int compare(Integer o1, Integer o2) {
    if (Objects.equals(o1, o2)) {
      Random tieBreak = new Random();
      int tBreak = tieBreak.nextInt(2);
      if (tBreak == 1) {
        o1 += 1;
      } else {
        o1 -= 1;
      }
    }
    int diff = o1 - o2;
    return Integer.compare(0, diff);
  }
}

