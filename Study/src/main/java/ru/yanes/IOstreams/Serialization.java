package ru.yanes.IOstreams;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serialization {
	public static void main(String[] args) throws IOException {
		Car myCar = new Car("Ford GT 40", Color.BLUE, 400, 400_000);
		
		myCar.startEngine();
		System.out.println(myCar);

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("myCar.dat"))) {
			oos.writeObject(myCar);
		}

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("myCar.dat"))) {
			Car newCar = (Car) ois.readObject();
			System.out.println(newCar);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		Team team = new Team();
		Hero hero = new Hero("Spiderman");

		team.addHero(hero);
		System.out.println(team.getHeroes().get(0).getName());

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("myTeam.dat"))) {
			oos.writeObject(team);
		}

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("myTeam.dat"))) {
			Team newTeam = (Team) ois.readObject();
			System.out.println(team.getHeroes().size());
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	static class Team implements Serializable {
		List<Hero> heroes = new ArrayList<>();

		public void addHero(Hero hero) {
			heroes.add(hero);
		}

		public List<Hero> getHeroes() {
			return heroes;
		}

		public String toString() {
			return String.join(", ", heroes.toString());
		}
	}

	static class Hero implements Serializable {
		private final String name;

		Hero(String name) {
			this.name = name;
		}
		public String getName() {
			return name;
		}
	}
}

class Car implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
	private String name;
	private Color color;
	private int power;
	private int cost = 0;

	private transient boolean isStarted = false;

	Car(String name, Color color, int power, int cost) {
		setName(name);
		setColor(color);
		setPower(power);
		this.cost = cost;
	}

	public int getCost() {
		return cost;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}

	public int getPower(int power) {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}

	public boolean isStarted() {
		return isStarted;
	}

	public void startEngine() {
		if (! isStarted) {
			this.isStarted = true;
		}
	}

	public void stopEngine() {
		if (isStarted) {
			this.isStarted = false;
		}
	}

	public String toString() {
		return "Car [name=" + name + ", color=" + color + ", power=" + power + ", isStarted=" + isStarted + ", cost=" + cost + "]";
	}
}

enum Color {
	RED, GREEN, BLUE;
}