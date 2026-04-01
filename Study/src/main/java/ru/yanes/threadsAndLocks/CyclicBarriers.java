package ru.yanes.threadsAndLocks;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarriers {
	public static void main(String[] args) {
		int playersNeeded = 3;

		// The second argument is the "Barrier Action" - runs when the barrier trips
		CyclicBarrier barrier = new CyclicBarrier(playersNeeded, () -> {
			System.out.println("\n[SYSTEM] Party full! Opening the Dungeon doors...\n");
		});

		ExecutorService executor = Executors.newFixedThreadPool(playersNeeded);

		for (int i = 1; i <= playersNeeded; i++) {
			int playerId = i;
			executor.submit(() -> {
				try {
					System.out.println("Player " + playerId + " is searching for a match...");
					Thread.sleep((long) (Math.random() * 3000));

					System.out.println("Player " + playerId + " joined the lobby. Waiting for others...");

					// Everyone calls await(). The thread stops here.
					barrier.await();

					System.out.println("Player " + playerId + " is now entering the Dungeon!");

				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}

		executor.shutdown();
	}
}
