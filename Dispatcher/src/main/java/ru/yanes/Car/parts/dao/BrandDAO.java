package ru.yanes.car.parts.dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import ru.yanes.car.parts.entity.Brand;

@Repository
public interface BrandDAO extends JpaRepository<Brand, Short> {}
