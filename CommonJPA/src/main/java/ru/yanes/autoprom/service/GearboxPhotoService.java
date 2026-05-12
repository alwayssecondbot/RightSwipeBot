package ru.yanes.autoprom.service;

import ru.yanes.YanesService;
import ru.yanes.autoprom.entity.GearboxPhoto;

import java.util.List;

public interface GearboxPhotoService extends YanesService<GearboxPhoto, Long> {
	@Override
	GearboxPhoto findById(Long id);

	@Override
	GearboxPhoto save(GearboxPhoto object);

	@Override
	List<GearboxPhoto> findAll();

	@Override
	void deleteById(Long id);
}
