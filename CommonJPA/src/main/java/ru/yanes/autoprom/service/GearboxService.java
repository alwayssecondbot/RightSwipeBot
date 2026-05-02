package ru.yanes.autoprom.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yanes.EntityNotFoundException;
import ru.yanes.autoprom.dao.GearboxDAO;
import ru.yanes.autoprom.entity.Gearbox;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GearboxService {

	private final GearboxDAO repository;

	public Gearbox findById(int id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	public Gearbox save(Gearbox object) {
		return repository.save(object);
	}

	public List<Gearbox> findAll() {
		return repository.findAll();
	}
}
