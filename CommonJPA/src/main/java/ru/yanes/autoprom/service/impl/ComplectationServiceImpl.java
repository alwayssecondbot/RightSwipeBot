package ru.yanes.autoprom.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yanes.EntityNotFoundException;
import ru.yanes.autoprom.dao.ComplectationDAO;
import ru.yanes.autoprom.entity.Complectation;
import ru.yanes.autoprom.service.ComplectationService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ComplectationServiceImpl implements ComplectationService {

	private final ComplectationDAO repository;

	@Override
	@Transactional(readOnly = true)
	public Complectation findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	@Override
	@Transactional
	public Complectation save(Complectation object) {
		return repository.save(object);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Complectation> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}

}
