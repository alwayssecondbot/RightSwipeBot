package ru.yanes.Car.Parts;

import lombok.RequiredArgsConstructor;

public class Body {
    private int wheels = 4;
    private BodyType type = BodyType.Sedan;

}

@RequiredArgsConstructor
enum BodyType {
    Sedan("sedan"),
    Cope("cope"),
    Liftback("liftback"),
    Hatchback("hatchback");

    private final String name;
}
