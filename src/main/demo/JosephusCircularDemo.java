package demo;

import practice.JosephusCircular;

/** A demo of JosephusCircular on the example the notes trace: n = 6, k = 3. */
public final class JosephusCircularDemo {

  private JosephusCircularDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    int n = 6;
    int k = 3;
    System.out.println("n = " + n + ", k = " + k);

    // People are eliminated in the order 2, 5, 3, 1, 4. Expect survivor 0.
    System.out.println("survivor: " + JosephusCircular.survivor(n, k));
  }
}
