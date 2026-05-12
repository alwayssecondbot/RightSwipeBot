package ru.yanes.autoprom.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yanes.EntityNotFoundException;
import ru.yanes.autoprom.dao.EnginePhotoDAO;
import ru.yanes.autoprom.entity.EnginePhoto;
import ru.yanes.autoprom.service.EnginePhotoService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EnginePhotoServiceImpl implements EnginePhotoService {


	private final EnginePhotoDAO repository;

	@Override
	@Transactional(readOnly = true)
	public EnginePhoto findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	@Override
	@Transactional
	public EnginePhoto save(EnginePhoto object) {
		return repository.save(object);
	}

	@Override
	@Transactional(readOnly = true)
	public List<EnginePhoto> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
