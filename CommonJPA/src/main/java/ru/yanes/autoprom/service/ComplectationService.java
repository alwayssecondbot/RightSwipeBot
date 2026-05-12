package ru.yanes.autoprom.service;

import ru.yanes.YanesService;
import ru.yanes.autoprom.entity.Complectation;

import java.util.List;

public interface ComplectationService extends YanesService<Complectation,Integer> {

	@Override
	Complectation findById(Integer id);

	@Override
	Complectation save(Complectation object);

	@Override
	List<Complectation> findAll();

	@Override
	void deleteById(Integer id);
}
