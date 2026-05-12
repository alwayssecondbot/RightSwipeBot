package ru.yanes.users.service;

import ru.yanes.YanesService;
import ru.yanes.users.entity.Review;

import java.util.List;

public interface ReviewService extends YanesService<Review, Long> {
	@Override
	Review findById(Long id);

	@Override
	Review save(Review object);

	@Override
	List<Review> findAll();

	@Override
	void deleteById(Long id);
}
