package ru.yanes.autoprom.service;

import ru.yanes.YanesService;
import ru.yanes.autoprom.entity.GenerationPhoto;

import java.util.List;

public interface GenerationPhotoService extends YanesService<GenerationPhoto, Long> {
	@Override
	GenerationPhoto findById(Long id);

	@Override
	GenerationPhoto save(GenerationPhoto object);

	@Override
	List<GenerationPhoto> findAll();

	@Override
	void deleteById(Long id);
}
