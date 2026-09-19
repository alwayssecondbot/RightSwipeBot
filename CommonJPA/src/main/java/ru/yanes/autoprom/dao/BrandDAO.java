package ru.yanes.autoprom.dao;


import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yanes.autoprom.entity.Brand;
import ru.yanes.autoprom.projections.BrandShortView;

import java.util.List;

@Repository
public interface BrandDAO extends JpaRepository<Brand, Short> {
	@EntityGraph(attributePaths = {"country", "concern"})
	List<BrandShortView> findShortViewsBy();

	@EntityGraph(attributePaths = {"country", "concern"})
	BrandShortView findShortViewById(Short id);
}
