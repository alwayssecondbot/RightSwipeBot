package ru.yanes.users.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yanes.EntityNotFoundException;
import ru.yanes.users.dao.ArticleDAO;
import ru.yanes.users.entity.Article;
import ru.yanes.users.service.ArticleService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ArticleServiceImpl implements ArticleService {

	private final ArticleDAO repository;

	@Override
	@Transactional(readOnly = true)
	public Article findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	@Override
	@Transactional
	public Article save(Article object) {
		return repository.save(object);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Article> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
