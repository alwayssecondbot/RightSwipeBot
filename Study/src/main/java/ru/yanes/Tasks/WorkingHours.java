package ru.yanes.Tasks;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;

public class WorkingHours {
	public static void main(String[] args) {
		Interval morning = new Interval(LocalTime.of(11, 0),LocalTime.of(13,0));
		Interval lunch = new Interval(LocalTime.of(12,30),LocalTime.of(14,40));
		Interval lunch1 = new Interval(LocalTime.of(12,30),LocalTime.of(15,40));
		Interval lunch2 = new Interval(LocalTime.of(12,30),LocalTime.of(15,40));
		Interval lunch3 = new Interval(LocalTime.of(12,30),LocalTime.of(15,40));
		Interval lunch4 = new Interval(LocalTime.of(12,30),LocalTime.of(16,40));
		Interval lunch5 = new Interval(LocalTime.of(12,30),LocalTime.of(13,40));
		Interval evening = new Interval(LocalTime.of(16,0),LocalTime.of(18,0));


		Collector<Interval, List<Interval>, List<Interval>> collector = Collector.of(
				ArrayList::new,
				WorkingHours::addAndMerge,
				(left, right) -> {
					right.forEach(interval -> addAndMerge(left, interval));
					return left;
				}
		);



		List<Interval> intervals = Arrays.asList(morning, evening, lunch, lunch1, lunch2, lunch3, lunch4, lunch5);

		List<Interval> hours = intervals.parallelStream()
				.sorted(Comparator.comparing(Interval::start))
				.collect(collector);
		System.out.println(hours.toString());
	}

	static void addAndMerge(List<Interval> list, Interval next) {
		if (list.isEmpty()) {
			list.add(next);
		} else {
			if (!next.start().isAfter(list.getLast().end())) {
				list.set(list.size() - 1, new Interval(list.getLast().start(),
						list.getLast().end().isAfter(next.end())? list.getLast().end() : next.end())
				);
			} else {
				list.add(next);
			}
		}
	}
}

record Interval(LocalTime start, LocalTime end) {}