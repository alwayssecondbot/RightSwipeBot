package ru.yanes;

public class EntityNotFoundException extends RuntimeException{
	public EntityNotFoundException(String id) {
		super("Object not found with id:" + id);
	}
}
