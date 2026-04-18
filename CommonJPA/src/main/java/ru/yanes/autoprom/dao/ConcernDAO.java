package ru.yanes.autoprom.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yanes.autoprom.entity.Concern;

@Repository
public interface ConcernDAO extends JpaRepository<Concern, Short>{}
