package ru.yanes.users.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yanes.EntityNotFoundException;
import ru.yanes.users.dao.AccountDAO;
import ru.yanes.users.entity.Account;
import ru.yanes.users.service.AccountService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

	private final AccountDAO repository;

	@Override
	@Transactional(readOnly = true)
	public Account findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	@Override
	@Transactional
	public Account save(Account object) {
		return repository.save(object);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Account> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}


}
