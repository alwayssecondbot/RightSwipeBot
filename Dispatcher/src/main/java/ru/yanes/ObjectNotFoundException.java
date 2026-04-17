package ru.yanes;

public class ObjectNotFoundException extends RuntimeException{
	public ObjectNotFoundException(String id) {
		super("Object not found with id:" + id);
	}
}
