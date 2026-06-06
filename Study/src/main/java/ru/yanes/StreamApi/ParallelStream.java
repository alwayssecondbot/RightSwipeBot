package ru.yanes.StreamApi;

import java.util.*;
import java.util.stream.Collectors;

public class ParallelStream {
	public static void main(String[] args) {
		List<String> planets = Arrays.asList("Mars", "Venus", "Jupiter", "Saturn", "Mercury");
		planetStream(planets);

		String[] planets2 = {"Mars", "Venus", "Jupiter", "Saturn", "Mercury"};
		arrayStream(planets2);

		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		numberStream(numbers);
		collisionStream(numbers);

		finalStream();
	}

	static  void planetStream(List<String> planets) {
		planets = planets.parallelStream()
				.filter(s -> s.charAt(0) == 'V' || s.charAt(0) == 'J')
				.toList();

		System.out.println(planets);
	}

	static void arrayStream(String[] planets) {
		List<String> planetList = Arrays.stream(planets).parallel()
				.filter(s -> s.charAt(0) == 'S' || s.charAt(0) == 'M')
				.toList();

		System.out.println(planetList);
	}

	static void numberStream(int[] numbers) {
		Arrays.stream(numbers).parallel()
				.forEach(System.out::println);
		Arrays.stream(numbers).parallel()
				.forEachOrdered(System.out::println);
	}

	static void collisionStream(int[] numbers) {
		int[] totalSum = {0};
		Arrays.stream(numbers).parallel()
				.forEach(weight -> totalSum[0] += weight);
		System.out.println(totalSum[0]);

		totalSum[0] = 0;
		totalSum[0] = Arrays.stream(numbers).parallel()
				.reduce(0, Integer::sum);
		System.out.println(totalSum[0]);

		totalSum[0] = 0;
		totalSum[0] = Arrays.stream(numbers).parallel()
				.sum();
		System.out.println(totalSum[0]);
	}

	static void finalStream() {
		Ship abeda = new Ship("Abeda", ShipType.CARGO, 123);
		abeda.setReady(true);
		Ship lucky = new Ship("Lucky", ShipType.TRANSPORT, 123);
		Ship mars = new Ship("Mars", ShipType.FIGHTER, 23);
		mars.setReady(true);

		List<Ship> ships1 = Arrays.asList(abeda, lucky, mars);
		Sector boston = new Sector("Boston", ships1);

		Ship dune = new Ship("Dune", ShipType.CARGO, 123);
		dune.setReady(true);
		Ship geely = new Ship("Geely", ShipType.TRANSPORT, 23);
		geely.setReady(true);
		Ship pluto = new Ship("Pluto", ShipType.FIGHTER, 123);
		pluto.setReady(true);

		List<Ship> ships2 = Arrays.asList(dune, geely, pluto);
		Sector aurelia = new Sector("Aurelia", ships2);

		List<Sector> galaxy = Arrays.asList(aurelia, boston);

//		Map<ShipType, List<String>> map =
		Map<ShipType, List<String>> map = galaxy.parallelStream()
				.flatMap(sector -> sector.getShips().stream())
				.filter(ship -> ship.isReady() && ship.getFuel() > 50)
				.collect(Collectors.groupingBy(Ship::getType, Collectors.mapping(
						ship -> "%s (%s)".formatted(ship.getName().toUpperCase(), ship.getType()), Collectors.toList()
				)));

		System.out.println(map);
	}
}

enum ShipType { CARGO, FIGHTER, TRANSPORT }


class Ship {
	String name;
	ShipType type;
	double fuel;
	boolean isReady = false;

	Ship(String name, ShipType type, double fuel) {
		setName(name);
		setType(type);
		setFuel(fuel);
	}

	public String getName() {
		return name;
	}
	public ShipType getType() {
		return type;
	}
	public double getFuel() {
		return fuel;
	}

	public boolean isReady() {
		return isReady;
	}

	public void setReady(boolean isReady) {
		this.isReady = isReady;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(ShipType type) {
		this.type = type;
	}
	public void setFuel(double fuel) {
		this.fuel = fuel;
	}
}

class Sector {
	String name;
	List<Ship> ships;

	Sector(String name, List<Ship> ships) {
		setName(name);
		setShips(ships);
	}

	public String getName() {
		return name;
	}
	public List<Ship> getShips() {
		return ships;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setShips(List<Ship> ships) {
		this.ships = ships;
	}
}
