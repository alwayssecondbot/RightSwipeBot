package ru.yanes.Car.Parts;

import ru.yanes.Postgres;

public interface SqlEntity {
    abstract void addToBase(Postgres postgres);
    abstract void editInBase(Postgres postgres);
    abstract void deleteFromBase(Postgres postgres);
    abstract void getFromBase(Postgres postgres);
}
