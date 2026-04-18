package ru.yanes.autoprom.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yanes.autoprom.entity.Model;

@Repository
public interface ModelDAO extends JpaRepository<Model, Short> {}
