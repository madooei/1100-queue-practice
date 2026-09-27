package practice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/** Tests for the round-robin scheduling problem. */
public class RoundRobinTest {

  @Test
  public void emptyBurstTimesGiveEmptyResult() {
    assertTimes(new int[] {},
        RoundRobin.completionTimes(new int[] {}, 3));
  }

  @Test
  public void singleTaskRunsToCompletion() {
    assertTimes(new int[] {10},
        RoundRobin.completionTimes(new int[] {10}, 3));
  }

  @Test
  public void everyBurstFitsInOneQuantum() {
    assertTimes(new int[] {2, 5, 6},
        RoundRobin.completionTimes(new int[] {2, 3, 1}, 4));
  }

  @Test
  public void taskFinishingExactlyAtTheQuantumIsNotRequeued() {
    assertTimes(new int[] {4, 8},
        RoundRobin.completionTimes(new int[] {4, 4}, 4));
  }

  @Test
  public void quantumOfOneAlternatesBetweenTasks() {
    assertTimes(new int[] {5, 4},
        RoundRobin.completionTimes(new int[] {3, 2}, 1));
  }

  @Test
  public void shortTaskFinishesBeforeLongerTasksAheadOfIt() {
    assertTimes(new int[] {18, 6, 17},
        RoundRobin.completionTimes(new int[] {9, 2, 7}, 4));
  }

  @Test
  public void inputArrayIsNotMutated() {
    int[] burstTimes = {9, 2, 7};
    RoundRobin.completionTimes(burstTimes, 4);
    assertTimes(new int[] {9, 2, 7}, burstTimes);
  }

  // Asserts that actual holds exactly the expected times, in order.
  private static void assertTimes(int[] expected, int[] actual) {
    assertEquals(expected.length, actual.length);
    for (int i = 0; i < expected.length; i++) {
      assertEquals(expected[i], actual[i]);
    }
  }
}
