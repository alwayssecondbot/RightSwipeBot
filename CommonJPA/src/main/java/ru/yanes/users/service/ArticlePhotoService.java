package ru.yanes.users.service;

import ru.yanes.YanesService;
import ru.yanes.users.entity.ArticlePhoto;

import java.util.List;

public interface ArticlePhotoService extends YanesService<ArticlePhoto, Long> {
	@Override
	ArticlePhoto findById(Long id);

	@Override
	ArticlePhoto save(ArticlePhoto object);

	@Override
	List<ArticlePhoto> findAll();

	@Override
	void deleteById(Long id);
}
