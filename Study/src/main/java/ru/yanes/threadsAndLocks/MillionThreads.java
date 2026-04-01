package ru.yanes.threadsAndLocks;

import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

public class MillionThreads {
	public static void main(String[] args) {
		LongAdder counter = new LongAdder();
		long start = System.currentTimeMillis();

		// 1. Use the new Virtual Thread Executor
		try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
			IntStream.range(0, 1_000_000).forEach(i -> {
				executor.submit(() -> {
					// 2. Simulate some "blocking" work (like a DB call)
					// In the old days, this would kill performance.
					// Here, the virtual thread just "unmounts."
					counter.increment();
					return i;
				});
			});
		} // Executor auto-closes and waits for all tasks (Structured Concurrency)

		long end = System.currentTimeMillis();
		System.out.println("Finished " + counter.sum() + " tasks in " + (end - start) + "ms");
	}
}