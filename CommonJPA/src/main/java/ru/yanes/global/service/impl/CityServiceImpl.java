package ru.yanes.global.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yanes.EntityNotFoundException;
import ru.yanes.global.dao.CityDAO;
import ru.yanes.global.entity.City;
import ru.yanes.global.service.CityService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CityServiceImpl implements CityService {

	private final CityDAO repository;

	@Override
	@Transactional(readOnly = true)
	public City findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	@Override
	@Transactional
	public City save(City object) {
		return repository.save(object);
	}

	@Override
	@Transactional(readOnly = true)
	public List<City> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
}
