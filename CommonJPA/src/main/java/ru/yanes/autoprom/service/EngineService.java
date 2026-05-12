package ru.yanes.autoprom.service;

import ru.yanes.YanesService;
import ru.yanes.autoprom.entity.Engine;

import java.util.List;

public interface EngineService extends YanesService<Engine, Integer> {
	@Override
	Engine findById(Integer id);

	@Override
	Engine save(Engine object);

	@Override
	List<Engine> findAll();

	@Override
	void deleteById(Integer id);
}
