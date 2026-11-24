package demo;

import practice.MovingAverage;

/** A demo of MovingAverage on the sequence of readings from the notes. */
public final class MovingAverageDemo {

  private MovingAverageDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    MovingAverage average = new MovingAverage(3);
    System.out.println("k = 3");

    // Expect 6.0, 4.0, 5.0, 4.0, 6.0. From the fourth reading on,
    // the window is full and the oldest reading leaves.
    int[] readings = {6, 2, 7, 3, 8};
    for (int reading : readings) {
      System.out.println("add(" + reading + ") = " + average.add(reading));
    }
  }
}
