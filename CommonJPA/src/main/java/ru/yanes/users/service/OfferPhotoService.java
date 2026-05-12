package ru.yanes.users.service;

import ru.yanes.YanesService;
import ru.yanes.users.entity.OfferPhoto;

import java.util.List;

public interface OfferPhotoService extends YanesService<OfferPhoto, Long> {
	@Override
	OfferPhoto findById(Long id);

	@Override
	OfferPhoto save(OfferPhoto object);

	@Override
	List<OfferPhoto> findAll();

	@Override
	void deleteById(Long id);
}
