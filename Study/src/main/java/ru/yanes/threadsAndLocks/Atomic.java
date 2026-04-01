package ru.yanes.threadsAndLocks;

import java.util.concurrent.atomic.AtomicInteger;

public class Atomic {
	public static void main(String[] args) {
		Counter.increment();
		Counter.increment();
		System.out.println(Counter.getCount());
	}

	static class Counter {
		static private final AtomicInteger count = new AtomicInteger(0);

		static public void increment() {
			count.incrementAndGet();
		}

		static public int getCount() {
			// if just 'return count' it can be changed outside throw set(n)
			return count.get();
		}
	}

}
