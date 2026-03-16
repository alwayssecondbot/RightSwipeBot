package ru.yanes.Tasks;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TopManagement {
	public static void main(String[] args) {
		Employee employee1 = new Employee("Bob", "HR", 100000);
		Employee employee2 = new Employee("Tom", "HR", 200000);
		Employee employee3 = new Employee("John", "HR", 300000);
		Employee employee4 = new Employee("Jane", "Financial", 90000);

		List<Employee> employeeList = Arrays.asList(employee1, employee2, employee3, employee4);

//		Collector<Employee, Map.Entry<Double, List<Employee>>, Map<Double,List<Employee>>> collector = Collector.of(
//				,
//				(entry, employe) -> {
//				}
//		)

		Map<String, List<Employee>> rich = employeeList.parallelStream()
				.collect(Collectors.groupingBy(Employee::department,
						Collectors.toList()
				))
				.entrySet().stream()
				.filter(entry -> entry.getValue().stream()
									.collect(Collectors.averagingDouble(Employee::salary)) > 100000)
				.collect(Collectors.toMap(Map.Entry::getKey,
						entry -> entry.getValue().stream()
									.sorted(Comparator.comparing(Employee::salary).reversed())
									.limit(3)
									.toList()
						)
				);

		System.out.println(rich);
	}
}

record Employee(String name, String department, double salary) {}
