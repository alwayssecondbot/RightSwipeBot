package ru.yanes.Tasks;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BagAnalyser {
	public static void main(String[] args) {
		Order order1 = new Order(123, "Bob", Arrays.asList("Potato", "meat", "banana"));
		Order order2 = new Order(123, "Tom", Arrays.asList("Potato", "heat", "dudama"));
		Order order3 = new Order(123, "Seal", Arrays.asList("Potato", "meat", "galama"));
		Order order4 = new Order(123, "Tyme", Arrays.asList("Sweet paper", "beer", "lamala"));
		List<Order> orders = Arrays.asList(order1, order2, order3, order4);

		Map<String, Long> analyse = orders.parallelStream()
				.flatMap(order -> order.items().stream())
				.collect(Collectors.groupingBy(order -> order,
						Collectors.counting()));

		System.out.println(analyse);
	}
}

record Order(long id, String customer, List<String> items) {}