package ru.yanes.autoprom.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yanes.EntityNotFoundException;
import ru.yanes.autoprom.dao.ModelDAO;
import ru.yanes.autoprom.entity.Model;
import ru.yanes.autoprom.service.ModelService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ModelServiceImpl implements ModelService {

	private final ModelDAO repository;

	@Override
	@Transactional(readOnly = true)
	public Model findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	@Override
	@Transactional
	public Model save(Model object) {
		return repository.save(object);
	}

	@Override
	@Transactional
	public List<Model> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}


}
