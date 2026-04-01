package ru.yanes.threadsAndLocks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Threads {
	public static void main(String[] args) {
		Thread thread = new Thread(() -> System.out.println("Hello World!"));
		thread.start();
		// java.lang.IllegalThreadStateException cause thread already dead
//		thread.start();
		ExecutorService executor = Executors.newFixedThreadPool(5);
		executor.submit(() -> System.out.println("Hello World!"));
		executor.submit(() -> System.out.println("Hello World!"));
		executor.submit(() -> System.out.println("Hello World!"));
		executor.submit(() -> System.out.println("Hello World!"));
		// never die
		executor.submit(() -> System.out.println("Hello World!"));
		// only here
		executor.close();
	}
}
