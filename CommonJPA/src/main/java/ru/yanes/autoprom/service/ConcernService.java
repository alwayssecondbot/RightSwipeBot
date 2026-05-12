package ru.yanes.autoprom.service;

import ru.yanes.YanesService;
import ru.yanes.autoprom.entity.Concern;

import java.util.List;

public interface ConcernService extends YanesService<Concern, Short> {
	@Override
	Concern findById(Short id);

	@Override
	Concern save(Concern object);

	@Override
	List<Concern> findAll();

	@Override
	void deleteById(Short id);
}
