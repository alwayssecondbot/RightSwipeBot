package ru.yanes.autoprom.dao;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yanes.autoprom.entity.Concern;
import ru.yanes.autoprom.projections.ConcernShortView;

import java.util.List;

@Repository
public interface ConcernDAO extends JpaRepository<Concern, Short>{
	@EntityGraph(attributePaths = {"country", "mainBrand"})
	List<ConcernShortView> findShortViewsBy();

	@EntityGraph(attributePaths = {"country", "mainBrand"})
	ConcernShortView findShortViewById(String id);
}
