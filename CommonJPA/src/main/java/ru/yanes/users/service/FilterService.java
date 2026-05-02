package ru.yanes.users.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yanes.EntityNotFoundException;
import ru.yanes.users.dao.FilterDAO;
import ru.yanes.users.entity.Filter;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FilterService {

	private final FilterDAO repository;

	public Filter findById(long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	public Filter save(Filter object) {
		return repository.save(object);
	}

	public List<Filter> findAll() {
		return repository.findAll();
	}
}
