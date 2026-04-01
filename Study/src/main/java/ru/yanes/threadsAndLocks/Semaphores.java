package ru.yanes.threadsAndLocks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Semaphores {
	public static void main(String[] args) {
		// Only 2 people can use the machine at once
		Semaphore machinePermits = new Semaphore(2);
		ExecutorService executor = Executors.newFixedThreadPool(5);

		String[] employees = {"Alice", "Bob", "Charlie", "Dave", "Eve"};

		for (String name : employees) {
			executor.submit(() -> {
				try {
					System.out.println(name + " is waiting for coffee...");

					// 1. Try to get a permit
					machinePermits.acquire();

					System.out.println("☕️ " + name + " is brewing coffee...");
					Thread.sleep((long) (Math.random() * 2000));

					System.out.println("✅ " + name + " finished and left the machine.");
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				} finally {
					// 2. ALWAYS release in a finally block!
					machinePermits.release();
				}
			});
		}
		executor.shutdown();
	}
}
