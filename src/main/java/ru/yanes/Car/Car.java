package ru.yanes.Car;

import ru.yanes.Car.Parts.Body;
import ru.yanes.Car.Parts.PowertrainSystem;

//TODO.csv переделать на билдер сначала вручную, потом через конструктор
public abstract class Car {
    String name = null;
    Brand brand = null;
    PowertrainSystem powertrainSystem = new PowertrainSystem();
    Body body = new Body();
}

