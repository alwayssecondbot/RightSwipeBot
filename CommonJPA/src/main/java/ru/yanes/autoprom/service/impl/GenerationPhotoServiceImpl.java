package ru.yanes.autoprom.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yanes.EntityNotFoundException;
import ru.yanes.autoprom.dao.GenerationPhotoDAO;
import ru.yanes.autoprom.entity.GenerationPhoto;
import ru.yanes.autoprom.service.GenerationPhotoService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GenerationPhotoServiceImpl implements GenerationPhotoService {


	private final GenerationPhotoDAO repository;

	@Override
	@Transactional(readOnly = true)
	public GenerationPhoto findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	@Override
	@Transactional
	public GenerationPhoto save(GenerationPhoto object) {
		return repository.save(object);
	}

	@Override
	@Transactional(readOnly = true)
	public List<GenerationPhoto> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}


}
