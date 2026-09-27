package practice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Unit tests for MovingAverage. Each test builds its own instance because
 * the window size k is part of the scenario under test.
 */
public class MovingAverageTest {

  private static final double DELTA = 1e-9;

  @Test
  public void firstReadingIsTheAverage() {
    MovingAverage movingAverage = new MovingAverage(3);
    assertEquals(6.0, movingAverage.add(6), DELTA);
  }

  @Test
  public void partialWindowDividesByReadingsSoFar() {
    MovingAverage movingAverage = new MovingAverage(4);
    movingAverage.add(5);
    movingAverage.add(7);
    assertEquals(4.0, movingAverage.add(0), DELTA);
  }

  @Test
  public void averageIsNotTruncatedByIntegerDivision() {
    MovingAverage movingAverage = new MovingAverage(2);
    movingAverage.add(1);
    assertEquals(1.5, movingAverage.add(2), DELTA);
  }

  @Test
  public void fullWindowAveragesTheLastKReadings() {
    MovingAverage movingAverage = new MovingAverage(3);
    movingAverage.add(6);
    movingAverage.add(2);
    assertEquals(5.0, movingAverage.add(7), DELTA);
  }

  @Test
  public void readingPastAFullWindowDropsTheOldest() {
    MovingAverage movingAverage = new MovingAverage(3);
    movingAverage.add(6);
    movingAverage.add(2);
    movingAverage.add(7);
    assertEquals(4.0, movingAverage.add(3), DELTA);
  }

  @Test
  public void readingsLeaveTheWindowInArrivalOrder() {
    MovingAverage movingAverage = new MovingAverage(3);
    movingAverage.add(6);
    movingAverage.add(2);
    movingAverage.add(7);
    movingAverage.add(3);
    assertEquals(6.0, movingAverage.add(8), DELTA);
  }

  @Test
  public void windowOfOneReturnsTheLatestReading() {
    MovingAverage movingAverage = new MovingAverage(1);
    movingAverage.add(4);
    assertEquals(9.0, movingAverage.add(9), DELTA);
  }

  @Test
  public void constructorWithZeroWindowThrows() {
    try {
      new MovingAverage(0);
      fail("expected IllegalArgumentException when k is 0");
    } catch (IllegalArgumentException e) {
      return;
    }
  }

  @Test
  public void constructorWithNegativeWindowThrows() {
    try {
      new MovingAverage(-3);
      fail("expected IllegalArgumentException when k is negative");
    } catch (IllegalArgumentException e) {
      return;
    }
  }
}
