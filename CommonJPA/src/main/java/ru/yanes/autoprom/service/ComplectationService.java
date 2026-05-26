package ru.yanes.autoprom.service;

import ru.yanes.YanesService;
import ru.yanes.autoprom.entity.Complectation;

import java.util.List;

public interface ComplectationService extends YanesService<Complectation,Long> {

	@Override
	Complectation findById(Long id);

	@Override
	Complectation save(Complectation object);

	@Override
	List<Complectation> findAll();

	@Override
	void deleteById(Long id);
}
