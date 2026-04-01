package ru.yanes.threadsAndLocks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Volatiles {
	public static void main(String[] args) throws InterruptedException {
		TaskRunner taskRunner = new TaskRunner();

		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.submit(taskRunner);
		executor.submit(TaskRunner::stop);
		System.out.println(TaskRunner.count);
	}

	static class TaskRunner implements Runnable {
		static private volatile boolean active = true; // without 'volatile' it will execute forever
		static private int count = 0;

		static public void stop() {
			active = false;
		}

		public void run() {
			while (active) {
				count++;
			}
			System.out.println("Stopped!");
		}
	}
}
