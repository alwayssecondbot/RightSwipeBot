package ru.yanes.Tasks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class TextMining {
	public static void main(String[] args) {
		String text = "Java is great. Java is fast. Java, Java, Java! Kotlin is also Java-like, Kotlin ,Kotlin Kotlin Kotlin Kotlin...";

		System.out.println(
				Stream.of(text.toLowerCase().split("\\W+"))
						.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
						.entrySet().stream()
						.filter(entry -> entry.getValue() > 5)
						.map(Map.Entry::getKey)
						.sorted()
						.collect(Collectors.joining(", "))

		);
	}
}
