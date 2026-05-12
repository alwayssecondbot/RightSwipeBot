package ru.yanes.users.service;

import ru.yanes.YanesService;
import ru.yanes.users.entity.Offer;

import java.util.List;

public interface OfferService extends YanesService<Offer, Long> {
	@Override
	Offer findById(Long id);

	@Override
	Offer save(Offer object);

	@Override
	List<Offer> findAll();

	@Override
	void deleteById(Long id);
}
