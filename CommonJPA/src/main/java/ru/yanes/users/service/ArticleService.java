package ru.yanes.users.service;

import ru.yanes.YanesService;
import ru.yanes.users.entity.Article;

import java.util.List;

public interface ArticleService extends YanesService<Article, Long> {
	@Override
	Article findById(Long id);

	@Override
	Article save(Article object);

	@Override
	List<Article> findAll();

	@Override
	void deleteById(Long id);
}
