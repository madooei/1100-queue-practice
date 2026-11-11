package practice;

/** Practice problem: find the Josephus survivor with a circularly linked list. */
public final class JosephusCircular {

  private JosephusCircular() {
    // This class should not be instantiated!
  }

  // Returns the number of the survivor. Assumes n and k are at least 1.
  public static int survivor(int n, int k) {
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
