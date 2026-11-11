package practice;

import queue.ArrayQueue;
import queue.Queue;

/** Practice problem: find the Josephus survivor by rotating a queue. */
public final class JosephusQueue {

  private JosephusQueue() {
    // This class should not be instantiated!
  }

  // Returns the number of the survivor. Assumes n and k are at least 1.
  public static int survivor(int n, int k) {
    Queue<Integer> circle = new ArrayQueue<>();
    // Enqueue all the people in the circle
    for (int i = 0; i < n; i++) {
      circle.enqueue(i);
    }

    int alive = n;
    while (alive > 1) {
      for (int counted = 1; counted < k; counted++) {
        int person = circle.front();
        circle.dequeue();
        circle.enqueue(person);  // counted, and survives this round
      }
      circle.dequeue();  // the k-th person counted is eliminated
      alive--;
    }
    return circle.front();  // the last person standing
  }
}
