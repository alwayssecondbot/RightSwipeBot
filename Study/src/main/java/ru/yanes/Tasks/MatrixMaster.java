package ru.yanes.Tasks;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MatrixMaster {
	public  static void main(String[] args) {
		List<List<Integer>> matrix = List.of(
				List.of(1, 2, 3),
				List.of(4, 5, 6)
		);

		List<List<Integer>> matrix2 = IntStream.range(0, matrix.getFirst().size())
						.mapToObj(index -> matrix.stream()
								.map(row -> row.get(index))
								.toList())
								.toList();



		System.out.println(matrix2);
	}
}
