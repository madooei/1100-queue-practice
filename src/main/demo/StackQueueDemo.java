package demo;

import practice.StackQueue;

/** A demo of StackQueue on the sequence of operations the notes trace. */
public final class StackQueueDemo {

  private StackQueueDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    StackQueue<Integer> queue = new StackQueue<>();

    // Enqueue 4 and 9. Expect 4 at the front.
    queue.enqueue(4);
    queue.enqueue(9);
    System.out.println("enqueue 4, 9, front: " + queue.front());

    // Dequeue 4. Expect 9 at the front.
    queue.dequeue();
    System.out.println("dequeue, front: " + queue.front());

    // Enqueue 2 while 9 is still waiting. Expect 9 still at the front.
    queue.enqueue(2);
    System.out.println("enqueue 2, front: " + queue.front());

    // Dequeue 9. Expect 2 at the front.
    queue.dequeue();
    System.out.println("dequeue, front: " + queue.front());

    // Dequeue 2. Expect an empty queue.
    queue.dequeue();
    System.out.println("dequeue, empty: " + queue.isEmpty());
  }
}
