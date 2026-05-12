package ru.yanes.users.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yanes.EntityNotFoundException;
import ru.yanes.users.dao.OfferPhotoDAO;
import ru.yanes.users.entity.OfferPhoto;
import ru.yanes.users.service.OfferPhotoService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OfferPhotoServiceImpl implements OfferPhotoService {

	private final OfferPhotoDAO repository;

	@Override
	@Transactional(readOnly = true)
	public OfferPhoto findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	@Override
	@Transactional
	public OfferPhoto save(OfferPhoto object) {
		return repository.save(object);
	}

	@Override
	@Transactional(readOnly = true)
	public List<OfferPhoto> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
