package practice;

/** Runs the Josephus scenarios against the circularly linked list solution. */
public class JosephusCircularTest extends JosephusTest {

  @Override
  protected int survivor(int n, int k) {
    return JosephusCircular.survivor(n, k);
  }
}
