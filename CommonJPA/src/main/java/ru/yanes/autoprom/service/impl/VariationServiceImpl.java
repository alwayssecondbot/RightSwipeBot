package ru.yanes.autoprom.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yanes.EntityNotFoundException;
import ru.yanes.autoprom.dao.VaritationDAO;
import ru.yanes.autoprom.entity.Variation;
import ru.yanes.autoprom.service.VariationService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VariationServiceImpl implements VariationService {

	private final VaritationDAO repository;

	@Override
	@Transactional(readOnly = true)
	public Variation findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	@Override
	@Transactional
	public Variation save(Variation object) {
		return repository.save(object);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Variation> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
}
