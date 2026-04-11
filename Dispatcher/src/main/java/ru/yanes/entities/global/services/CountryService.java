package ru.yanes.entities.global.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.yanes.entities.AbstractJpaService;
import ru.yanes.entities.global.Country;
import ru.yanes.entities.global.repos.CountryReposytory;

import java.util.List;
import java.util.Optional;

public class CountryService extends AbstractJpaService<Country,String> {

	@Autowired
	private final CountryReposytory reposytory;

	protected CountryService(CountryReposytory countryReposytory) {
		this.reposytory = countryReposytory;
	}

	@Override
	protected Country doSave(Country entity) {
		return reposytory.save(entity);
	}

	@Override
	protected Optional<Country> doFindById(String s) {
		return Optional.empty();
	}

	@Override
	protected List<Country> doFindAll() {
		return List.of();
	}

	@Override
	protected void doDeleteById(String s) {

	}
}
