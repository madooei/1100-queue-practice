package practice;

import queue.LinkedQueue;
import queue.Queue;

/** The solution to the round-robin scheduling problem. */
public final class RoundRobin {

  private RoundRobin() {
    // This class should not be instantiated!
  }

  // Returns an array where entry i is the time at which task i finishes.
  // Time starts at 0 and switching between tasks is free. Assumes quantum is
  // at least 1.
  public static int[] completionTimes(int[] burstTimes, int quantum) {
    int n = burstTimes.length;
    int[] remaining = new int[n];   // how much time is left for each task
    int[] completion = new int[n];  // the finish time of each task
    Queue<Integer> line = new LinkedQueue<>();  // the queue of task indices

    // initialize the remaining times and enqueue the task indices
    for (int i = 0; i < n; i++) {
      remaining[i] = burstTimes[i];  // initially, all of the burst time remains
      line.enqueue(i);
    }

    int time = 0;  // the current time
    while (!line.isEmpty()) {
      int taskIndex = line.front();
      line.dequeue();
      int run = Math.min(quantum, remaining[taskIndex]);  // a full slice, or whatever is left
      time += run;
      remaining[taskIndex] -= run;
      if (remaining[taskIndex] == 0) {
        completion[taskIndex] = time;  // the task is done; record when
      } else {
        line.enqueue(taskIndex);       // not done; back of the line
      }
    }
    return completion;
  }
}
