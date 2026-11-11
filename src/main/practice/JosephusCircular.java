package practice;

/** Practice problem: find the Josephus survivor with a circularly linked list. */
public final class JosephusCircular {

  private JosephusCircular() {
    // This class should not be instantiated!
  }

  // Returns the number of the survivor. Assumes n and k are at least 1.
  public static int survivor(int n, int k) {
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
