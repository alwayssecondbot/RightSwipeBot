package ru.yanes;

import java.util.List;
import java.util.Optional;

public abstract class AbstractJpaService<T,ID> {
	protected abstract T doSave(T entity);
	protected abstract Optional<T> doFindById(ID id);
	protected abstract List<T> doFindAll();
	protected abstract void doDeleteById(ID id);

	public T save(T entity) {
		return doSave(entity);
	}

	public Optional<T> findById(ID id) {
		return doFindById(id);
	}

	public List<T> findAll() {
		return doFindAll();
	}

	public void deleteById(ID id) {
		doDeleteById(id);
	}
}
