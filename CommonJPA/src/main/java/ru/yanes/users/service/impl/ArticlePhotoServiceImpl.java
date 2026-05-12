package ru.yanes.users.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yanes.EntityNotFoundException;
import ru.yanes.users.dao.ArticlePhotoDAO;
import ru.yanes.users.entity.ArticlePhoto;
import ru.yanes.users.service.ArticlePhotoService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ArticlePhotoServiceImpl implements ArticlePhotoService {

	private final ArticlePhotoDAO repository;

	@Override
	@Transactional(readOnly = true)
	public ArticlePhoto findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	@Override
	@Transactional
	public ArticlePhoto save(ArticlePhoto object) {
		return repository.save(object);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ArticlePhoto> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}


}
