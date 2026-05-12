package ru.yanes.autoprom.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yanes.EntityNotFoundException;
import ru.yanes.autoprom.dao.GenerationDAO;
import ru.yanes.autoprom.entity.Generation;
import ru.yanes.autoprom.service.GenerationService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GenerationServiceImpl implements GenerationService {

	private final GenerationDAO repository;

	@Override
	@Transactional(readOnly = true)
	public Generation findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	@Override
	@Transactional
	public Generation save(Generation object) {
		return repository.save(object);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Generation> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}


}
