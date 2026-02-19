package ru.yanes.car.parts.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yanes.car.parts.entity.Model;

@Repository
public interface ModelDAO extends JpaRepository<Model, Integer>{
}
