package ru.yanes.autoprom.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yanes.EntityNotFoundException;
import ru.yanes.autoprom.dao.VaritationDAO;
import ru.yanes.autoprom.entity.Variation;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VariationService {

	private final VaritationDAO repository;

	public Variation findById(int id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	public Variation save(Variation object) {
		return repository.save(object);
	}

	public List<Variation> findAll() {
		return repository.findAll();
	}
}
