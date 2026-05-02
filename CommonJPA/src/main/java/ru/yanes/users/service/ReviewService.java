package ru.yanes.users.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yanes.EntityNotFoundException;
import ru.yanes.users.dao.ReviewDAO;
import ru.yanes.users.entity.Review;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewService {

	private final ReviewDAO repository;

	public Review findById(long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	public Review save(Review object) {
		return repository.save(object);
	}

	public List<Review> findAll() {
		return repository.findAll();
	}
}
