package ru.yanes.users.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yanes.EntityNotFoundException;
import ru.yanes.users.dao.ArticleDAO;
import ru.yanes.users.entity.Article;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ArticleService {

	private final ArticleDAO repository;

	public Article findById(long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	public Article save(Article object) {
		return repository.save(object);
	}

	public List<Article> findAll() {
		return repository.findAll();
	}
}
