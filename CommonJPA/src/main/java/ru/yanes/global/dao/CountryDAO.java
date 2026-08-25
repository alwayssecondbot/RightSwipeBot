package ru.yanes.global.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yanes.global.entity.Country;
import ru.yanes.global.projections.CountryShortView;

import java.util.List;

@Repository
public interface CountryDAO extends JpaRepository<Country,String> {

	List<CountryShortView> findAllShortViewsBy();

	CountryShortView findShortViewByCode(String id);
}
