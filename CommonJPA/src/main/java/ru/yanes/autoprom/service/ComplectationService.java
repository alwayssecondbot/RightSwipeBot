package ru.yanes.autoprom.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yanes.EntityNotFoundException;
import ru.yanes.autoprom.dao.ComplectationDAO;
import ru.yanes.autoprom.entity.Complectation;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ComplectationService {

	private final ComplectationDAO repository;

	public Complectation findById(int id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	public Complectation save(Complectation object) {
		return repository.save(object);
	}

	public List<Complectation> findAll() {
		return repository.findAll();
	}
}
