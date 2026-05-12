package ru.yanes;

import java.util.List;

public interface YanesService<T,D> {

	T findById(D id);
	T save(T object);
	List<T> findAll();
	void deleteById(D id);
}
