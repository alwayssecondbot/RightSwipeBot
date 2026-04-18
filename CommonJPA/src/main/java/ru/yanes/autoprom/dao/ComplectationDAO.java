package ru.yanes.autoprom.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yanes.autoprom.entity.Complectation;

@Repository
public interface ComplectationDAO extends JpaRepository<Complectation, Integer> {
}
