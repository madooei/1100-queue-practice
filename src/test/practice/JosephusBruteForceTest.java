package practice;

/** Runs the Josephus scenarios against the boolean-array solution. */
public class JosephusBruteForceTest extends JosephusTest {

  @Override
  protected int survivor(int n, int k) {
    return Josephus.survivorBruteForce(n, k);
  }
}
