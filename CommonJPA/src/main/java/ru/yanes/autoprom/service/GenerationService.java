package ru.yanes.autoprom.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yanes.EntityNotFoundException;
import ru.yanes.autoprom.dao.GenerationDAO;
import ru.yanes.autoprom.entity.Generation;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GenerationService {

	private final GenerationDAO repository;

	public Generation findById(int id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	public Generation save(Generation object) {
		return repository.save(object);
	}

	public List<Generation> findAll() {
		return repository.findAll();
	}
}
