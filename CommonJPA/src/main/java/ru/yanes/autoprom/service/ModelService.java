package ru.yanes.autoprom.service;

import ru.yanes.YanesService;
import ru.yanes.autoprom.entity.Generation;
import ru.yanes.autoprom.entity.Model;

import java.util.List;

public interface ModelService extends YanesService<Model,Integer> {
	@Override
	Model findById(Integer id);

	@Override
	Model save(Model object);

	@Override
	List<Model> findAll();

	@Override
	void deleteById(Integer id);
}
