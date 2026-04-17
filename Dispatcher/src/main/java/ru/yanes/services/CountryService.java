package ru.yanes.services;

import org.springframework.stereotype.Service;
import ru.yanes.ObjectNotFoundException;
import ru.yanes.global.dao.CountryDAO;
import ru.yanes.global.entity.Country;

import java.util.List;

@Service
public class CountryService {

	private final CountryDAO repository;

	public CountryService(CountryDAO repository) {
		this.repository = repository;
	}

	public Country findById(String id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
	}

	public Country save(Country country) {
		return repository.save(country);
	}

	public List<Country> findAll() {
		return repository.findAll();
	}
}
