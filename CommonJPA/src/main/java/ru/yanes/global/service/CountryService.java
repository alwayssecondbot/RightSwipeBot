package ru.yanes.global.service;

import ru.yanes.YanesService;
import ru.yanes.global.entity.Country;

import java.util.List;

public interface CountryService extends YanesService<Country,String> {
	@Override
	Country findById(String id);

	@Override
	Country save(Country object);

	@Override
	List<Country> findAll();

	@Override
	void deleteById(String id);
}
