package ru.yanes.users.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yanes.EntityNotFoundException;
import ru.yanes.users.dao.ReviewDAO;
import ru.yanes.users.entity.Review;
import ru.yanes.users.service.ReviewService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {

	private final ReviewDAO repository;

	@Override
	@Transactional(readOnly = true)
	public Review findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	@Override
	@Transactional
	public Review save(Review object) {
		return repository.save(object);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Review> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}


}
