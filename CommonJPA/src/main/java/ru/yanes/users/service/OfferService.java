package ru.yanes.users.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yanes.EntityNotFoundException;
import ru.yanes.users.dao.OfferDAO;
import ru.yanes.users.entity.Offer;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OfferService {

	private final OfferDAO repository;

	public Offer findById(long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	public Offer save(Offer object) {
		return repository.save(object);
	}

	public List<Offer> findAll() {
		return repository.findAll();
	}
}
