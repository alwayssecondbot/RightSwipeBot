package ru.yanes.Tasks;

import java.time.LocalDateTime;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RushHour {
	public static void main(String[] args) {
		Visit visit1 = new Visit("1234", LocalDateTime.of(2026, 12, 12, 11, 12 ));
		Visit visit2 = new Visit("1235", LocalDateTime.of(2026, 12, 11, 11, 12 ));
		Visit visit3 = new Visit("1234", LocalDateTime.of(2026, 12, 12, 13, 12 ));
		Visit visit4 = new Visit("1234", LocalDateTime.of(2026, 12, 12, 13, 12 ));
		Visit visit5 = new Visit("1234", LocalDateTime.of(2026, 12, 12, 15, 12 ));
		Visit visit6 = new Visit("1235", LocalDateTime.of(2026, 12, 12, 15, 12 ));

		List<Visit> visits = Arrays.asList(visit1, visit2, visit4, visit3, visit5, visit6);

		LocalDateTime rushOur = visit1.timestamp();
		System.out.println(rushOur.getHour());

//		testMap();

		Collector<Visit, Map<Integer, Set<String>>, Set<String>> collector = Collector.of(
				HashMap::new,
				(map, visit) -> {
					int date = visit.timestamp().getDayOfMonth();
					if (map.containsKey(date)) {
						map.get(date).add(visit.userId());
					} else {
						map.put(date, new HashSet<>(Collections.singletonList(visit.userId())));
					}
				},
				(left, right) -> Stream.concat(
						left.entrySet().stream(),
						right.entrySet().stream())
						.collect(Collectors.toMap(Map.Entry::getKey,
								entry -> new HashSet<>(entry.getValue()),
								(up, down) -> {
									Set<String> merged = new HashSet<>(up);
									merged.addAll(down);
									return merged;
								}
						)),
				map -> {
					Map.Entry<Integer,Integer> max = Map.entry(0,0);

					for (Map.Entry<Integer,Set<String>> entry : map.entrySet()) {
						if (max.getValue() < entry.getValue().size()) {
							max = Map.entry(entry.getKey(), entry.getValue().size());
						}
					}

					return map.get(max.getKey());
				}
		);

		Map<Integer, Set<String>> rushHour = visits.parallelStream()
				.collect(Collectors.groupingBy(visit -> visit.timestamp().getHour(),
						collector));

		System.out.println(rushHour);
	}

	static void testMap() {
		Map<Integer, Set<String>> rushHour1 = new HashMap<>();
		Map<Integer, Set<String>> rushHour2 = new HashMap<>();
		Set<String> set1 = new HashSet<>();
		Set<String> set2 = new HashSet<>();
		Set<String> set3 = new HashSet<>();

		set1.add("Potato");
		set2.add("Tomato");
		set3.add("Strawberry");

		rushHour1.put(1, set1);
		rushHour1.put(2, set2);
		rushHour1.put(3, set3);

		rushHour2.put(1, set1);
		rushHour2.put(2, set2);
		rushHour2.put(3, set1);


		System.out.println(Stream.concat(rushHour1.entrySet().stream(), rushHour2.entrySet().stream())
						.collect(Collectors.toMap(
								Map.Entry::getKey,
								e -> new HashSet<>(e.getValue()),
								(Set<String>left,Set<String> right) -> {
									Set<String> merged = new HashSet<>(left);
									merged.addAll(right);
									return merged;
								}
						))
		);

	}
	record Visit(String userId, LocalDateTime timestamp) {}
}


