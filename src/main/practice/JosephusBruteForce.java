package practice;

/** Practice problem: find the Josephus survivor with a boolean array of eliminated people. */
public final class JosephusBruteForce {

  private JosephusBruteForce() {
    // This class should not be instantiated!
  }

  // Returns the number of the survivor. Assumes n and k are at least 1.
  public static int survivor(int n, int k) {
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
}
