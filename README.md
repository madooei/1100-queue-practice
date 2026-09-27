# Queue — Practice

Four practice problems. Three use a queue as a client: round-robin scheduling, the Josephus problem, and `MovingAverage`, which reports the average of the last `k` readings in a stream. `StackQueue` implements the `Queue` contract with two stacks as its only storage.

## Prerequisites

- JDK 17+
- The JUnit jar is already vendored in `lib/`; there is nothing to download.

## Repository layout

```plaintext
code/
  README.md
  .gitignore
  lib/
    junit-platform-console-standalone-6.1.0.jar
  src/
    main/
      queue/
        Queue.java                    # the Queue ADT contract (copied from the chapter)
        LinkedQueue.java              # linked Queue (copied from the chapter)
        ArrayQueue.java               # array-backed Queue (copied from the chapter)
      stack/
        Stack.java                    # the Stack ADT contract (copied from the Stack chapter)
        LinkedStack.java              # linked Stack (copied from the Stack chapter)
      practice/
        RoundRobin.java               # task completion times
        Josephus.java                 # the survivor (3 solutions)
        MovingAverage.java            # average of the last k readings
        StackQueue.java               # a Queue built from two Stacks
    test/
      queue/
        QueueTest.java                # abstract: the Queue contract suite (copied from the chapter)
      practice/
        RoundRobinTest.java           # scenarios for round-robin scheduling
        JosephusTest.java             # abstract: the Josephus scenarios
        JosephusBruteForceTest.java   # runs them against the boolean-array solution
        JosephusQueueTest.java        # runs them against the queue solution
        JosephusCircularTest.java     # runs them against the circularly linked list solution
        MovingAverageTest.java        # tests for MovingAverage
        StackQueueTest.java           # runs the Queue contract suite against StackQueue
  scripts/
    test.sh                           # compile and run every JUnit test
```

## How to compile and run

- `scripts/test.sh` — compiles everything and runs the full JUnit suite.
- `scripts/test.sh practice.JosephusBruteForceTest` — compiles everything and runs only that test class. Use this while you are working on one problem or one solution and the others are still empty.

There is no demo program for these problems; the tests are how you check your work.

## What's here

- `queue.Queue<T>`, `queue.LinkedQueue<T>`, `queue.ArrayQueue<T>`, and `queue.QueueTest` — unchanged copies from the chapter. `RoundRobin` and `MovingAverage` use `LinkedQueue`, `Josephus` uses `ArrayQueue`, `StackQueue` implements `Queue`, and `StackQueueTest` extends `QueueTest`, so they are included here to keep this code self-contained.
- `stack.Stack<T>` and `stack.LinkedStack<T>` — unchanged copies from the Stack chapter. `StackQueue` uses them as its two stacks.
- `practice.RoundRobin` — computes when each task finishes under round-robin scheduling.
- `practice.RoundRobinTest` — the round-robin scenarios.
- `practice.Josephus` — three solutions side by side: the boolean-array first attempt, the queue solution, and the circularly linked list.
- `practice.JosephusTest` — the abstract scenario suite for the Josephus problem. It has one subclass per solution, so you can test one solution alone.
- `practice.MovingAverage` — reports the average of the last `k` readings each time a reading is added.
- `practice.MovingAverageTest` — tests for `MovingAverage`.
- `practice.StackQueue` — a `Queue` that uses two stacks as its only storage.
- `practice.StackQueueTest` — runs the full `Queue` contract suite against `StackQueue`.
