package practice;

import java.util.NoSuchElementException;
import queue.Queue;
import stack.LinkedStack;
import stack.Stack;

/**
 * An implementation of the Queue ADT that uses two stacks as its only storage.
 *
 * @param <T> the type of elements in this queue.
 */
public class StackQueue<T> implements Queue<T> {

  private Stack<T> in;   // receives enqueued items
  private Stack<T> out;  // serves items, oldest on top

  public StackQueue() {
    in = new LinkedStack<>();
    out = new LinkedStack<>();
  }

  @Override
  public void enqueue(T item) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Override
  public void dequeue() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Override
  public T front() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Override
  public boolean isEmpty() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // if out is empty, move everything from in to out, reversing the order
  private void pour() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }
}
