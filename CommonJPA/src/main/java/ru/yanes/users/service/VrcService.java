package ru.yanes.users.service;

import ru.yanes.YanesService;
import ru.yanes.users.entity.Vrc;

import java.util.List;

public interface VrcService extends YanesService<Vrc, Long> {
	@Override
	Vrc findById(Long id);

	@Override
	Vrc save(Vrc object);

	@Override
	List<Vrc> findAll();

	@Override
	void deleteById(Long id);
}
