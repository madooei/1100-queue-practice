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
    if (item == null) {
      throw new IllegalArgumentException();
    }
    in.push(item);
  }

  @Override
  public void dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    pour();
    out.pop();
  }

  @Override
  public T front() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    pour();
    return out.top();
  }

  @Override
  public boolean isEmpty() {
    return in.isEmpty() && out.isEmpty();
  }

  // if out is empty, move everything from in to out, reversing the order
  private void pour() {
    if (out.isEmpty()) {
      while (!in.isEmpty()) {
        T item = in.top();
        in.pop();
        out.push(item);
      }
    }
  }
}
