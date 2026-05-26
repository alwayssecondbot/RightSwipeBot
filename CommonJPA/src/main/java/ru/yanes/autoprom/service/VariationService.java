package ru.yanes.autoprom.service;

import ru.yanes.YanesService;
import ru.yanes.autoprom.entity.Variation;

import java.util.List;

public interface VariationService extends YanesService<Variation,Long> {
	@Override
	Variation findById(Long id);

	@Override
	Variation save(Variation object);

	@Override
	List<Variation> findAll();

	@Override
	void deleteById(Long id);
}
