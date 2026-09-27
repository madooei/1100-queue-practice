package practice;

import queue.LinkedQueue;
import queue.Queue;

/** The moving average of the last k readings in a stream. */
public class MovingAverage {

  private Queue<Integer> window;
  private int k;
  private int count;  // how many readings are in the window
  private int sum;    // the sum of the readings in the window

  // Throws IllegalArgumentException if k is less than 1.
  public MovingAverage(int k) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Records reading and returns the average of the last k readings, or of
  // all the readings so far if fewer than k have arrived.
  public double add(int reading) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }
}
