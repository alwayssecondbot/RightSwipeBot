package ru.yanes.threadsAndLocks;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatches {
	public  static void main(String[] args) throws InterruptedException {
		int teams = 3;
		CountDownLatch latch = new CountDownLatch(teams);
		ExecutorService executor = Executors.newFixedThreadPool(teams);

		String[] teamsList = {"Fuel System", "Navigation", "Life Support"};

		for (String team : teamsList) {
			executor.submit(() -> {
				try {
					System.out.println("[WORKER] " + team + " is initializing...");
					Thread.sleep((long) (Math.random() * 2000)); // Simulating work
					System.out.println("[WORKER] " + team + " is READY.");
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				} finally {
					// 2. Each team signals they are done
					latch.countDown();
				}
			});
		}

		System.out.println("[MAIN] Waiting for all systems to be GO...");

		// 3. The main thread blocks here until the latch count is 0
		latch.await();

		System.out.println("[MAIN] All systems GO! 🚀 LIFT OFF!");
		executor.shutdown();
	}
}
