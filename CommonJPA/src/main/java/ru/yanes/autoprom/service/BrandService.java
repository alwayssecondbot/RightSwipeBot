package ru.yanes.autoprom.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yanes.EntityNotFoundException;
import ru.yanes.autoprom.dao.BrandDAO;
import ru.yanes.autoprom.entity.Brand;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BrandService {

	private final BrandDAO repository;

	public Brand findById(short id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	public Brand save(Brand object) {
		return repository.save(object);
	}

	public List<Brand> findAll() {
		return repository.findAll();
	}
}
