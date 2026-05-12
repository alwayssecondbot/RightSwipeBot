package ru.yanes;

public class EntityNotFoundException extends RuntimeException{
	public EntityNotFoundException(String id) {
		super("Object not found with id:" + id);
	}
	public EntityNotFoundException(int id) {
		super("Object not found with id:" + id);
	}
	public EntityNotFoundException(long id) {
		super("Object not found with id:" + id);
	}
	public EntityNotFoundException(short id) {
		super("Object not found with id:" + id);
	}
}
