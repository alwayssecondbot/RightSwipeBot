package ru.yanes.Tasks;

import java.util.List;
import java.util.stream.IntStream;

public class SlippingAverage {
	public static void main(String[] args) {
		List<Integer> prices = List.of(10, 20, 30, 40, 50);
		int windowSize = 2;
		List<Double> movingAverages = IntStream.range(0, prices.size())
				.skip(windowSize - 1)
				.mapToObj(index -> prices.subList(index - windowSize + 1, index + 1)
						.stream()
						.mapToInt(Integer::intValue)
						.average()
						.orElse(0.00)
				)
				.toList();

		System.out.println(movingAverages);
//		[10.0, 15.0, 20.0, 30.0, 40.0]
	}
}
