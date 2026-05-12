package ru.yanes.users.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yanes.EntityNotFoundException;
import ru.yanes.users.dao.FilterDAO;
import ru.yanes.users.entity.Filter;
import ru.yanes.users.service.FilterService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FilterServiceImpl implements FilterService {

	private final FilterDAO repository;

	@Override
	@Transactional(readOnly = true)
	public Filter findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	@Override
	@Transactional
	public Filter save(Filter object) {
		return repository.save(object);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Filter> findAll() {
		return repository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}


}
