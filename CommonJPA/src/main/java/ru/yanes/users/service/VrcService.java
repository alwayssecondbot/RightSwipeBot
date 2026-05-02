package ru.yanes.users.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yanes.EntityNotFoundException;
import ru.yanes.users.dao.VrcDAO;
import ru.yanes.users.entity.Vrc;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VrcService {

	private final VrcDAO repository;

	public Vrc findById(long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	public Vrc save(Vrc object) {
		return repository.save(object);
	}

	public List<Vrc> findAll() {
		return repository.findAll();
	}
}
