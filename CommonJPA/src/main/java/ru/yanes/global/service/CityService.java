package ru.yanes.global.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yanes.EntityNotFoundException;
import ru.yanes.global.dao.CityDAO;
import ru.yanes.global.entity.City;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CityService {

	private final CityDAO repository;

	public City findById(int id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	public City save(City object) {
		return repository.save(object);
	}

	public List<City> findAll() {
		return repository.findAll();
	}
}
