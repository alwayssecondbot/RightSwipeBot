package ru.yanes.users.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yanes.users.entity.Account;

@Repository
public interface AccountDAO extends JpaRepository<Account,Long> {
}
