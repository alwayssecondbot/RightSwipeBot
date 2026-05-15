package ru.yanes.users.dao;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yanes.users.entity.Offer;
import ru.yanes.users.projections.OfferShortView;

import java.util.List;

@Repository
public interface OfferDAO extends JpaRepository<Offer,Long> {
	@EntityGraph(attributePaths = {"variation.generation.model.brand", "variation.generation.model", "variation.generation", "variation", "complectation", "vrc", "photos"})
	List<OfferShortView> findShortViewsBy();
}