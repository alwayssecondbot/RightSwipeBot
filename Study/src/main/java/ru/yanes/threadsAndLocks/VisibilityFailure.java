package ru.yanes.threadsAndLocks;

public class VisibilityFailure {
	public static void main(String[] args) throws InterruptedException {
		Task task = new Task();
		Thread thread = new Thread(task);
		thread.start();

		// Give the loop a second to "warm up" so the JIT compiler
		// optimizes the code (Hoisting)
		Thread.sleep(1000);

		System.out.println("Main thread is setting active to FALSE...");
		task.stop();

		// We wait for the thread to finish
		thread.join(2000);

		if (thread.isAlive()) {
			System.err.println("❌ THE THREAD IS STUCK! It didn't see the change.");
//			System.exit(1);
		} else {
			System.out.println("✅ Thread stopped successfully.");
		}
	}

	static class Task implements Runnable {
		private volatile boolean active = true; // ⚠️ NO VOLATILE HERE
		private long count = 0;

		public void stop() {
			active = false;
		}

		@Override
		public void run() {
			System.out.println("Loop started...");
			while (active) {
				// TIGHT LOOP: No sleep, no println, no logic.
				count++;
			}
			System.out.println("Loop stopped! Final count: " + count);
		}
	}
}