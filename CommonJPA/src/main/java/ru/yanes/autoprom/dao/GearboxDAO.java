package ru.yanes.autoprom.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yanes.autoprom.entity.Gearbox;

@Repository
public interface GearboxDAO extends JpaRepository<Gearbox, Integer> {
}
