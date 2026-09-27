package practice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The scenarios for the Josephus problem. A concrete subclass supplies
 * survivor() to pick the solution under test.
 */
public abstract class JosephusTest {

  // Calls the solution under test.
  protected abstract int survivor(int n, int k);

  @Test
  public void onePersonSurvivesNoMatterTheCount() {
    assertEquals(0, survivor(1, 5));
  }

  @Test
  public void twoPeopleCountingByTwo() {
    assertEquals(0, survivor(2, 2));
  }

  @Test
  public void countingByOneEliminatesInOrder() {
    assertEquals(4, survivor(5, 1));
  }

  @Test
  public void sixPeopleCountingByThree() {
    assertEquals(0, survivor(6, 3));
  }

  @Test
  public void countLargerThanCircleWrapsAround() {
    assertEquals(1, survivor(3, 10));
  }
}
