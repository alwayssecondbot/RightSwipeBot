package ru.yanes.autoprom.service;

import ru.yanes.YanesService;
import ru.yanes.autoprom.entity.Generation;

import java.util.List;

public interface GenerationService extends YanesService<Generation, Integer> {
	@Override
	Generation findById(Integer id);

	@Override
	Generation save(Generation object);

	@Override
	List<Generation> findAll();

	@Override
	void deleteById(Integer id);
}
