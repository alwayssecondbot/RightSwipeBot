package ru.yanes.users.dao;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yanes.users.entity.Review;
import ru.yanes.users.projections.ReviewShortView;

import java.util.List;

@Repository
public interface ReviewDAO extends JpaRepository<Review,Long> {
	@EntityGraph(attributePaths = {"generation.model.brand", "generation.model", "generation", "variation", "complectation", "account"})
	List<ReviewShortView> findShortViewsBy();
}