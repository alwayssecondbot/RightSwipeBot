package ru.yanes.autoprom.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yanes.EntityNotFoundException;
import ru.yanes.autoprom.dao.GearboxDAO;
import ru.yanes.autoprom.entity.Gearbox;
import ru.yanes.autoprom.service.GearboxService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GearboxServiceImpl implements GearboxService {

	private final GearboxDAO repository;

	@Override
	@Transactional(readOnly = true)
	public Gearbox findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	@Override
	@Transactional
	public Gearbox save(Gearbox object) {
		return repository.save(object);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Gearbox> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}


}
