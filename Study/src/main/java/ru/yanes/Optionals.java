package ru.yanes;

import java.util.Optional;

public class Optionals {
	public static void main(String[] args) {
		TargetPlanet planet = new TargetPlanet();
		planet.setName("Planet 1");

		NavigationSystem navigationSystem = new NavigationSystem();
		navigationSystem.setTargetPlanet(planet);

		Spaceship spaceship = new Spaceship();
		spaceship.setNavigationSystem(navigationSystem);

		spaceships(spaceship);


	}

	static void spaceships(Spaceship spaceship) {

		
		String planetName = Optional.ofNullable(spaceship)
				.flatMap(Spaceship::getNavigationSystem)
				.map(NavigationSystem::getTargetPlanet)
				.map(TargetPlanet::getName)
				.orElseGet(() -> "Deep Space");

		System.out.println(planetName);
	}

	static class Spaceship {
		private NavigationSystem navigationSystem;

		public Optional<NavigationSystem> getNavigationSystem() {
			return Optional.ofNullable(navigationSystem);
		}

		public void setNavigationSystem(NavigationSystem navigationSystem) {
			this.navigationSystem = navigationSystem;
		}
	}

	static class TargetPlanet {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	static class NavigationSystem {
		private TargetPlanet targetPlanet;

		public TargetPlanet getTargetPlanet() {
			return targetPlanet;
		}
		public void setTargetPlanet(TargetPlanet targetPlanet) {
			this.targetPlanet = targetPlanet;
		}
	}
}

