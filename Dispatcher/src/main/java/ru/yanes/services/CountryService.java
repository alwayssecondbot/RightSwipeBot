package ru.yanes.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yanes.AbstractJpaService;
import ru.yanes.global.dao.CountryDAO;
import ru.yanes.global.entity.Country;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CountryService extends AbstractJpaService<Country,String> {

	private final CountryDAO reposytory;

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
