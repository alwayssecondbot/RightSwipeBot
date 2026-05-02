package ru.yanes.autoprom.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yanes.EntityNotFoundException;
import ru.yanes.autoprom.dao.EngineDAO;
import ru.yanes.autoprom.entity.Engine;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EngineService {

	private final EngineDAO repository;

	public Engine findById(short id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	public Engine save(Engine object) {
		return repository.save(object);
	}

	public List<Engine> findAll() {
		return repository.findAll();
	}
}
