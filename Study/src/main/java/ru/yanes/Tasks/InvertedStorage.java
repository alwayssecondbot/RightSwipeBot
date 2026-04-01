package ru.yanes.Tasks;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class InvertedStorage {
	public static void main(String[] args) {
		Map<String, List<String>> warehouseStock = Map.of(
				"Storage_A", List.of("Netbook", "Phone", "Mouse"),
				"Storage_B", List.of("Phone", "Keyboard"),
				"Storage_C", List.of("Netbook", "Mouse")
		);

		Map<String, Set<String>> warehouseStockSet = warehouseStock.entrySet()
				.parallelStream()
				.flatMap(entry -> entry.getValue().stream()
						.map(value -> Map.entry(value, entry.getKey()))
				)
				.collect(Collectors.groupingBy(Map.Entry::getKey,
						Collectors.mapping(
								Map.Entry::getValue,
								Collectors.toSet())
						)
				);
		System.out.println(warehouseStockSet);
	}
}
