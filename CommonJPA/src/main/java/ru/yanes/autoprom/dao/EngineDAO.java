package ru.yanes.autoprom.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yanes.autoprom.entity.Engine;

@Repository
public interface EngineDAO extends JpaRepository<Engine, Short> {}
