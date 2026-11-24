package demo;

import java.util.Arrays;
import practice.RoundRobin;

/** A demo of RoundRobin on the example the notes trace. */
public final class RoundRobinDemo {

  private RoundRobinDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    int[] burstTimes = {9, 2, 7};
    int quantum = 4;
    System.out.println("burst times: " + Arrays.toString(burstTimes) + ", quantum = " + quantum);

    // Task 1 finishes first at time 6, task 2 at 17, task 0 at 18.
    // Expect [18, 6, 17].
    int[] finished = RoundRobin.completionTimes(burstTimes, quantum);
    System.out.println("completion times: " + Arrays.toString(finished));
  }
}
