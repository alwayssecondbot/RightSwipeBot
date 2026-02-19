package ru.yanes.car.parts.dao;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import ru.yanes.car.parts.entity.Corporation;

@Repository
public interface CorporationDAO extends JpaRepository<Corporation, Short>{
}
