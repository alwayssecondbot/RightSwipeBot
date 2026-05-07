package ru.yanes;

public abstract class YanesEntity<T> {

	T id;

	public abstract boolean hasFullView();
	public abstract boolean hasShortView();
}
