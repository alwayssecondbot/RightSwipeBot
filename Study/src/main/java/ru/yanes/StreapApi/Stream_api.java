package ru.yanes.StreapApi;

import ru.yanes.SpaceShip;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Stream_api{

    public static void main(String[] args){
	    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		numberStream(numbers);

		List<String> planets = Arrays.asList("Mars", "Venus", "Jupiter", "Saturn", "Mercury");
		planetStream(planets);


	    Double[] fuelLevels = {15.0, 70.0, 45.0, 90.0, 10.0};
		fuelStreams(fuelLevels);

		SpaceShip ship = new SpaceShip("Lucky", 500);
    }

	static void numberStream(List<Integer> numbers){
		int result = numbers.stream()
				.filter(s -> s%2==0)
				.map(s-> s*s)
				.reduce(1, (accumulator, element) -> accumulator * element);
		System.out.println(result);
	}

	static void planetStream(List<String> planets){
		Map<Character,List<String>> sortedPlanet = planets.stream()
				.collect(Collectors.groupingBy(s -> s.charAt(0)));
		System.out.println(sortedPlanet);

		List<String> planets1 = Arrays.asList("Mars", "Venus", "Jupiter", "Saturn", "Mercury");
		List<List<String>> allFleets = Arrays.asList(planets, planets1);

		List<String> finalPlanets = allFleets.stream()
				.flatMap(List::stream)
				.toList();
		System.out.println(finalPlanets);
	}

	static void fuelStreams(Double[] fuelLevels){
		Map<String,List<Double>> fuelLvl = Arrays.stream(fuelLevels)
				.collect(Collectors.groupingBy(s-> s<=50?"Low":"High"));
		System.out.println(fuelLvl);
		Map<Boolean,List<Double>> lvls = Arrays.stream(fuelLevels)
				.collect(Collectors.partitioningBy(s-> s>50));
		System.out.println(lvls);
	}
}
