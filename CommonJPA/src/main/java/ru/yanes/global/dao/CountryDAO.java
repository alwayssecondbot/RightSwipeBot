package ru.yanes.global.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yanes.global.entity.Country;

public interface CountryDAO extends JpaRepository<Country,String> {}
