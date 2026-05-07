package ru.yanes.users.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yanes.EntityNotFoundException;
import ru.yanes.users.dao.AccountDAO;
import ru.yanes.users.entity.Account;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AccountService {

	private final AccountDAO repository;

	@Transactional
	public Account findById(long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	public Account save(Account object) {
		return repository.save(object);
	}

	public List<Account> findAll() {
		return repository.findAll();
	}
}
