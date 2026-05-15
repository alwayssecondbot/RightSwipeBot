package ru.yanes.users.dao;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yanes.users.entity.Report;
import ru.yanes.users.projections.ReportShortView;

import java.util.List;

@Repository
public interface ReportDAO extends JpaRepository<Report,Long> {
	@EntityGraph(attributePaths = {"generation.model.brand", "generation.model", "generation", "variation", "complectation", "account"})
	List<ReportShortView> findShortViewsBy();
}