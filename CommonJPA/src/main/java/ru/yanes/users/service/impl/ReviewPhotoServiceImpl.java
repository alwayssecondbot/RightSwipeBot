package ru.yanes.users.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yanes.EntityNotFoundException;
import ru.yanes.users.dao.ReviewPhotoDAO;
import ru.yanes.users.entity.ReviewPhoto;
import ru.yanes.users.service.ReviewPhotoService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewPhotoServiceImpl implements ReviewPhotoService {

	private final ReviewPhotoDAO repository;

	@Override
	@Transactional(readOnly = true)
	public ReviewPhoto findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	@Override
	@Transactional
	public ReviewPhoto save(ReviewPhoto object) {
		return repository.save(object);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReviewPhoto> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
