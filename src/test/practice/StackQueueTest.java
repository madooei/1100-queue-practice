package practice;

import queue.Queue;
import queue.QueueTest;

/** Runs the Queue contract suite against StackQueue. */
public class StackQueueTest extends QueueTest {

  @Override
  protected Queue<Integer> createQueue() {
    return new StackQueue<>();
  }
}
