package ru.yanes.autoprom.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yanes.EntityNotFoundException;
import ru.yanes.autoprom.dao.ConcernDAO;
import ru.yanes.autoprom.entity.Concern;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ConcernService {

	private final ConcernDAO repository;

	public Concern findById(short id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	public Concern save(Concern object) {
		return repository.save(object);
	}

	public List<Concern> findAll() {
		return repository.findAll();
	}
}
