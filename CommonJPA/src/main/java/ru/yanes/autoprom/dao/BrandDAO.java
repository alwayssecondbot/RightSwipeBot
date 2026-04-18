package ru.yanes.autoprom.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yanes.autoprom.entity.Brand;

@Repository
public interface BrandDAO extends JpaRepository<Brand, Short> {}
