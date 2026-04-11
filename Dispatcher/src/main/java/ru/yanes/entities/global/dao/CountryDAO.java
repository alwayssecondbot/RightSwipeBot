package ru.yanes.entities.global.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yanes.entities.global.Country;

@Repository
public interface CountryDAO extends JpaRepository<Country, String>{
}
