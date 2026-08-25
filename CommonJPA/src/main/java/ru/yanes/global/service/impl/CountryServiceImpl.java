package ru.yanes.global.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yanes.EntityNotFoundException;
import ru.yanes.global.dao.CountryDAO;
import ru.yanes.global.entity.Country;
import ru.yanes.global.projections.CountryShortView;
import ru.yanes.global.service.CountryService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CountryServiceImpl implements CountryService {

	private final CountryDAO repository;

	@Override
	@Transactional(readOnly = true)
	public Country findById(String id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	@Override
	@Transactional
	public Country save(Country object) {
		return repository.save(object);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Country> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public void deleteById(String id) {
		repository.deleteById(id);
	}


	@Override
	public List<CountryShortView> findAllShortViewsBy() {
		return repository.findAllShortViewsBy();
	}

	@Override
	public CountryShortView findShortViewById(String id) {
		return repository.findShortViewByCode(id);
	}
}
