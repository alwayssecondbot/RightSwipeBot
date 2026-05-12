package ru.yanes.autoprom.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yanes.EntityNotFoundException;
import ru.yanes.autoprom.dao.EngineDAO;
import ru.yanes.autoprom.entity.Engine;
import ru.yanes.autoprom.service.EngineService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EngineServiceImpl implements EngineService {

	private final EngineDAO repository;

	@Override
	@Transactional(readOnly = true)
	public Engine findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	@Override
	@Transactional
	public Engine save(Engine object) {
		return repository.save(object);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Engine> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
}
