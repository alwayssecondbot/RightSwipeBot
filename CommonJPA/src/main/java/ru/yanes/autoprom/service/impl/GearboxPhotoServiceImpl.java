package ru.yanes.autoprom.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yanes.EntityNotFoundException;
import ru.yanes.autoprom.dao.GearboxPhotoDAO;
import ru.yanes.autoprom.entity.GearboxPhoto;
import ru.yanes.autoprom.service.GearboxPhotoService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GearboxPhotoServiceImpl implements GearboxPhotoService {


	private final GearboxPhotoDAO repository;

	@Override
	@Transactional(readOnly = true)
	public GearboxPhoto findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	@Override
	@Transactional
	public GearboxPhoto save(GearboxPhoto object) {
		return repository.save(object);
	}

	@Override
	@Transactional(readOnly = true)
	public List<GearboxPhoto> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
