package ru.yanes.autoprom.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yanes.EntityNotFoundException;
import ru.yanes.autoprom.dao.ConcernDAO;
import ru.yanes.autoprom.entity.Concern;
import ru.yanes.autoprom.service.ConcernService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ConcernServiceImpl implements ConcernService {

	private final ConcernDAO repository;

	@Override
	@Transactional(readOnly=true)
	public Concern findById(Short id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	@Override
	@Transactional
	public Concern save(Concern object) {
		return repository.save(object);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Concern> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public void deleteById(Short id) {
		repository.deleteById(id);
	}
}
