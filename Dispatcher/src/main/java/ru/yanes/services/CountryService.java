package ru.yanes.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yanes.EntityNotFoundException;
import ru.yanes.global.dao.CountryDAO;
import ru.yanes.global.entity.Country;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CountryService {

	private final CountryDAO repository;

	public Country findById(String id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	public Country save(Country country) {
		return repository.save(country);
	}

	public List<Country> findAll() {
		return repository.findAll();
	}
}
