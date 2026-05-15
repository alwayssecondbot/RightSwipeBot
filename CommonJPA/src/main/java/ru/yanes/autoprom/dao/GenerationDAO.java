package ru.yanes.autoprom.dao;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yanes.autoprom.entity.Generation;
import ru.yanes.autoprom.projections.GenerationShortView;

import java.util.List;

@Repository
public interface GenerationDAO extends JpaRepository<Generation, Integer> {
	@EntityGraph(attributePaths = {"model", "model.brand", "photos"})
	List<GenerationShortView> findShortViewsBy();
}
