package ru.yanes.autoprom.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yanes.autoprom.entity.Variation;

@Repository
public interface VaritationDAO extends JpaRepository<Variation, Long> {
}
