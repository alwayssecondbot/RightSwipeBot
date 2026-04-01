package ru.yanes.threadsAndLocks;


import java.util.concurrent.CompletableFuture;

public class CompletableFutures {
	public static void main(String[] args) {
		CompletableFuture<Double> number = CompletableFuture.supplyAsync(() -> 123.4)
				.thenApply(Math::sqrt);

		CompletableFuture<Double> number2 = CompletableFuture.supplyAsync(() -> 2034)
				.thenApply(Math::log);


		CompletableFuture<String> string = number2.thenCombine(number, (left, right) -> "Hello " + left + ", " + right + ";"  );

		string.thenAccept(System.out::println);
	}
}
