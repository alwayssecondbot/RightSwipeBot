package ru.yanes.users.service;

import ru.yanes.YanesService;
import ru.yanes.users.entity.ReviewPhoto;


import java.util.List;

public interface ReviewPhotoService extends YanesService<ReviewPhoto, Long> {
	@Override
	ReviewPhoto findById(Long id);

	@Override
	ReviewPhoto save(ReviewPhoto object);

	@Override
	List<ReviewPhoto> findAll();

	@Override
	void deleteById(Long id);
}
