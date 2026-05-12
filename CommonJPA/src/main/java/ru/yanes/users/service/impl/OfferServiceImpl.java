package ru.yanes.users.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yanes.EntityNotFoundException;
import ru.yanes.users.dao.OfferDAO;
import ru.yanes.users.entity.Offer;
import ru.yanes.users.service.OfferService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OfferServiceImpl implements OfferService {

	private final OfferDAO repository;

	@Override
	@Transactional(readOnly = true)
	public Offer findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	@Override
	@Transactional
	public Offer save(Offer object) {
		return repository.save(object);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Offer> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}


}
