package ru.yanes.users.service;

import ru.yanes.YanesService;
import ru.yanes.users.entity.Filter;

import java.util.List;

public interface FilterService extends YanesService<Filter, Long> {
	@Override
	Filter findById(Long id);

	@Override
	Filter save(Filter object);

	@Override
	List<Filter> findAll();

	@Override
	void deleteById(Long id);
}
