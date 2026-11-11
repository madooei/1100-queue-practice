package practice;

/** Runs the Josephus scenarios against the queue-rotation solution. */
public class JosephusQueueTest extends JosephusTest {

  @Override
  protected int survivor(int n, int k) {
    return JosephusQueue.survivor(n, k);
  }
}
