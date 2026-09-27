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
    if (k < 1) {
      throw new IllegalArgumentException();
    }
    this.k = k;
    window = new LinkedQueue<>();
    count = 0;
    sum = 0;
  }

  // Records reading and returns the average of the last k readings, or of
  // all the readings so far if fewer than k have arrived.
  public double add(int reading) {
    window.enqueue(reading);
    sum += reading;
    count++;
    if (count > k) {
      int oldest = window.front();  // look at the reading that must leave
      window.dequeue();             // then remove it
      sum -= oldest;
      count--;
    }
    return (double) sum / count;
  }
}
