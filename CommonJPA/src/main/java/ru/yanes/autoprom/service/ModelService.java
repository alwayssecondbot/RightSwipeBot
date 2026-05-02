package ru.yanes.autoprom.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yanes.EntityNotFoundException;
import ru.yanes.autoprom.dao.ModelDAO;
import ru.yanes.autoprom.entity.Model;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ModelService {

	private final ModelDAO repository;

	public Model findById(short id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	public Model save(Model object) {
		return repository.save(object);
	}

	public List<Model> findAll() {
		return repository.findAll();
	}
}
