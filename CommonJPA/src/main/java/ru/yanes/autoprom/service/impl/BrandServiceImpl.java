package ru.yanes.autoprom.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yanes.EntityNotFoundException;
import ru.yanes.autoprom.dao.BrandDAO;
import ru.yanes.autoprom.entity.Brand;
import ru.yanes.autoprom.service.BrandService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BrandServiceImpl implements BrandService {

	private final BrandDAO repository;

	@Override
	@Transactional(readOnly=true)
	public Brand findById(Short id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	@Override
	@Transactional
	public Brand save(Brand object) {
		return repository.save(object);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Brand> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public void deleteById(Short id) {}
}
