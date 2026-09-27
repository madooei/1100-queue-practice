package practice;

import queue.ArrayQueue;
import queue.Queue;

/** Solutions to the Josephus problem. */
public final class Josephus {

  private Josephus() {
    // This class should not be instantiated!
  }

  // Returns the number of the survivor. Assumes n and k are at least 1.
  public static int survivorBruteForce(int n, int k) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Returns the index of the next person who is still in the game.
  private static int nextAlive(int current, boolean[] eliminated) {
    int i = (current + 1) % eliminated.length;
    while (eliminated[i]) {
      i = (i + 1) % eliminated.length;  // skip over eliminated people
    }
    return i;
  }

  // Returns the number of the survivor. Assumes n and k are at least 1.
  public static int survivor(int n, int k) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Returns the number of the survivor. Assumes n and k are at least 1.
  public static int survivorCircular(int n, int k) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  private static class Node {
    int value;
    Node next;

    Node(int value) {
      this.value = value;
    }
  }
}
