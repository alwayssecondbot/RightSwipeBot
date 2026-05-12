package ru.yanes.users.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yanes.EntityNotFoundException;
import ru.yanes.users.dao.VrcDAO;
import ru.yanes.users.entity.Vrc;
import ru.yanes.users.service.VrcService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VrcServiceImpl implements VrcService {

	private final VrcDAO repository;

	@Override
	@Transactional(readOnly = true)
	public Vrc findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	@Override
	@Transactional
	public Vrc save(Vrc object) {
		return repository.save(object);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Vrc> findAll() {
		return repository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
