package ru.yanes.users.service;

import ru.yanes.YanesService;
import ru.yanes.users.entity.Account;

import java.util.List;

public interface AccountService extends YanesService<Account, Long> {
	@Override
	Account findById(Long id);

	@Override
	Account save(Account object);

	@Override
	List<Account> findAll();

	@Override
	void deleteById(Long id);
}
