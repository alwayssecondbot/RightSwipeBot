package ru.yanes.Tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;


public class WeightCollector {
	public static void  main(String[] args) {
		record Grade(double score, double weight) {}

		Collector<Grade,?,Double> newGrade = Collector.of(
					() -> new double[2],
					(main, grade) -> {
						main[0] += grade.score() * grade.weight();
						main[1] += grade.weight();
					},
					(left, right) -> {
						left[0] += right[0];
						left[1] += right[1];
						return left;
					},
					list -> list[1] == 0?0:(list[0] / list[1]),
					Collector.Characteristics.UNORDERED
			);

		Grade grade1 = new Grade(1, 0);
		Grade grade2 = new Grade(2, 0);
		Grade grade3 = new Grade(3, 0);

		List<Grade> grades = Arrays.asList(grade1, grade2, grade3);

		double finalGrade = grades.parallelStream()
						.collect(newGrade);

		System.out.println(finalGrade);
	}




}

