package ru.yanes.global.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yanes.global.entity.City;

@Repository
public interface CityDAO extends JpaRepository<City,String> {}
