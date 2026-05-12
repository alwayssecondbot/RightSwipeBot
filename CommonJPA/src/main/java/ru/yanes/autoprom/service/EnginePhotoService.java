package ru.yanes.autoprom.service;

import ru.yanes.YanesService;
import ru.yanes.autoprom.entity.EnginePhoto;

import java.util.List;

public interface EnginePhotoService extends YanesService<EnginePhoto, Long> {
	@Override
	EnginePhoto findById(Long id);

	@Override
	EnginePhoto save(EnginePhoto object);

	@Override
	List<EnginePhoto> findAll();

	@Override
	void deleteById(Long id);
}
