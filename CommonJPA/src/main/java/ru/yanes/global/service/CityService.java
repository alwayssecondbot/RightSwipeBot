package ru.yanes.global.service;

import ru.yanes.YanesService;
import ru.yanes.global.entity.City;

import java.util.List;

public interface CityService extends YanesService<City,Integer> {

	@Override
	City findById(Integer id);

	@Override
	City save(City object);

	@Override
	List<City> findAll();

	@Override
	void deleteById(Integer id);
}
