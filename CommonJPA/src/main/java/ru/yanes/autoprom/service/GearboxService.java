package ru.yanes.autoprom.service;

import ru.yanes.YanesService;
import ru.yanes.autoprom.entity.Gearbox;

import java.util.List;

public interface GearboxService extends YanesService<Gearbox, Integer> {
	@Override
	Gearbox findById(Integer id);

	@Override
	Gearbox save(Gearbox object);

	@Override
	List<Gearbox> findAll();

	@Override
	void deleteById(Integer id);
}
