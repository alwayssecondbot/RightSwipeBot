package ru.yanes.autoprom.dao;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yanes.autoprom.entity.Model;
import ru.yanes.autoprom.projections.ModelShortView;

import java.util.List;

@Repository
public interface ModelDAO extends JpaRepository<Model, Integer> {
	@EntityGraph(attributePaths = {"brand", "photos"})
	List<ModelShortView> findShortViewsBy();
}
