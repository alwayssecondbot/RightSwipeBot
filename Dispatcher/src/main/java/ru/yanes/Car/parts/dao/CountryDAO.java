package ru.yanes.car.parts.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yanes.car.parts.entity.Country;

@Repository
public interface CountryDAO extends JpaRepository<Country, String>{
}
