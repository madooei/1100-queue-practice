package queue;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * The contract test suite for the Queue ADT, written against the Queue interface
 * alone. A concrete subclass supplies createQueue() to pick the implementation.
 */
public abstract class QueueTest {

  private Queue<Integer> queue;

  protected abstract Queue<Integer> createQueue();

  @BeforeEach
  public void setup() {
    queue = createQueue();
  }

  @Test
  public void newQueueIsEmpty() {
    assertTrue(queue.isEmpty());
  }

  @Test
  public void frontOnEmptyQueueThrows() {
    try {
      queue.front();
      fail("expected NoSuchElementException when calling front on an empty queue");
    } catch (NoSuchElementException e) {
      return;
    }
  }

  @Test
  public void dequeueOnEmptyQueueThrows() {
    try {
      queue.dequeue();
      fail("expected NoSuchElementException when dequeuing an empty queue");
    } catch (NoSuchElementException e) {
      return;
    }
  }

  @Test
  public void enqueueMakesQueueNonEmpty() {
    queue.enqueue(10);
    assertFalse(queue.isEmpty());
  }

  @Test
  public void frontReturnsEnqueuedItem() {
    queue.enqueue(10);
    assertEquals(10, queue.front());
  }

  @Test
  public void frontDoesNotRemoveTheItem() {
    queue.enqueue(10);
    queue.front();
    assertFalse(queue.isEmpty());
  }

  @Test
  public void dequeueOnlyItemLeavesQueueEmpty() {
    queue.enqueue(10);
    queue.dequeue();
    assertTrue(queue.isEmpty());
  }

  @Test
  public void frontAfterDequeuingOnlyItemThrows() {
    queue.enqueue(10);
    queue.dequeue();
    try {
      queue.front();
      fail("expected NoSuchElementException after dequeuing the only item");
    } catch (NoSuchElementException e) {
      return;
    }
  }

  @Test
  public void enqueueAfterDequeuingOnlyItemBecomesTheFront() {
    queue.enqueue(10);
    queue.dequeue();
    queue.enqueue(20);
    assertEquals(20, queue.front());
  }

  @Test
  public void frontReturnsFirstEnqueuedItem() {
    queue.enqueue(10);
    queue.enqueue(20);
    queue.enqueue(30);
    assertEquals(10, queue.front());
  }

  @Test
  public void dequeueRevealsTheNextItem() {
    queue.enqueue(10);
    queue.enqueue(20);
    queue.dequeue();
    assertEquals(20, queue.front());
  }

  @Test
  public void twoDequeuesRevealTheThirdItem() {
    queue.enqueue(4);
    queue.enqueue(9);
    queue.enqueue(6);
    queue.dequeue();
    queue.dequeue();
    assertEquals(6, queue.front());
  }

  @Test
  public void enqueueDoesNotChangeTheFront() {
    queue.enqueue(4);
    queue.enqueue(9);
    queue.enqueue(6);
    queue.dequeue();
    queue.dequeue();
    queue.enqueue(2);
    assertEquals(6, queue.front());
  }

  @Test
  public void itemEnqueuedAfterDequeuesIsServedLast() {
    queue.enqueue(4);
    queue.enqueue(9);
    queue.enqueue(6);
    queue.dequeue();
    queue.dequeue();
    queue.enqueue(2);
    queue.dequeue();
    assertEquals(2, queue.front());
  }

  @Test
  public void dequeuingEveryItemLeavesQueueEmpty() {
    queue.enqueue(10);
    queue.enqueue(20);
    queue.enqueue(30);
    queue.dequeue();
    queue.dequeue();
    queue.dequeue();
    assertTrue(queue.isEmpty());
  }

  @Test
  public void enqueuingTheSameItemTwiceKeepsBothCopies() {
    queue.enqueue(7);
    queue.enqueue(7);
    queue.dequeue();
    assertEquals(7, queue.front());
  }

  @Test
  public void manyEnqueuesKeepTheFirstItemAtTheFront() {
    for (int i = 1; i <= 12; i++) {
      queue.enqueue(i);
    }
    assertEquals(1, queue.front());
  }

  @Test
  public void manyEnqueuesKeepTheLastItemAtTheBack() {
    for (int i = 1; i <= 12; i++) {
      queue.enqueue(i);
    }
    for (int i = 1; i <= 11; i++) {
      queue.dequeue();
    }
    assertEquals(12, queue.front());
  }

  @Test
  public void enqueuesAfterDequeuesKeepArrivalOrder() {
    for (int i = 1; i <= 8; i++) {
      queue.enqueue(i);
    }
    for (int i = 1; i <= 5; i++) {
      queue.dequeue();
    }
    for (int i = 9; i <= 14; i++) {
      queue.enqueue(i);
    }
    for (int i = 1; i <= 5; i++) {
      queue.dequeue();
    }
    assertEquals(11, queue.front());
  }

  @Test
  public void enqueuesPastInitialCapacityAfterDequeuesKeepArrivalOrder() {
    for (int i = 1; i <= 8; i++) {
      queue.enqueue(i);
    }
    for (int i = 1; i <= 5; i++) {
      queue.dequeue();
    }
    for (int i = 9; i <= 16; i++) {
      queue.enqueue(i);
    }
    for (int i = 1; i <= 5; i++) {
      queue.dequeue();
    }
    assertEquals(11, queue.front());
  }

  @Test
  public void enqueueNullThrows() {
    try {
      queue.enqueue(null);
      fail("expected IllegalArgumentException when enqueuing null");
    } catch (IllegalArgumentException e) {
      return;
    }
  }
}
