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
    boolean[] eliminated = new boolean[n];
    int alive = n;
    int current = 0;  // the person the count starts at
    while (alive > 1) {
      int counted = 1;  // 'current' is the first person counted
      while (counted < k) {
        current = nextAlive(current, eliminated);
        counted++;
      }
      eliminated[current] = true;  // 'current' is the k-th person counted
      alive--;
      current = nextAlive(current, eliminated);  // the count resumes after the eliminated
    }
    return current;
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

  // Returns the number of the survivor. Assumes n and k are at least 1.
  public static int survivorCircular(int n, int k) {
    // build the circle of n people
    Node first = new Node(0);
    Node last = first;
    for (int i = 1; i < n; i++) {
      last.next = new Node(i);
      last = last.next;
    }
    last.next = first;  // close the circle

    // the count starts at person 0, so we stand just before them
    Node current = last;
    int alive = n;
    while (alive > 1) {
      for (int counted = 1; counted < k; counted++) {
        current = current.next;
      }
      current.next = current.next.next;  // unlink the k-th person counted
      alive--;
    }
    return current.value;
  }

  private static class Node {
    int value;
    Node next;

    Node(int value) {
      this.value = value;
    }
  }
}
