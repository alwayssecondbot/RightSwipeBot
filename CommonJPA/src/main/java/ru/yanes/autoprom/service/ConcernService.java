package ru.yanes.autoprom.service;

import org.springframework.data.jpa.repository.EntityGraph;
import ru.yanes.YanesService;
import ru.yanes.autoprom.entity.Concern;
import ru.yanes.autoprom.projections.ConcernShortView;

import java.util.List;

public interface ConcernService extends YanesService<Concern, Short> {
	@Override
	Concern findById(Short id);

	@Override
	Concern save(Concern object);

	@Override
	List<Concern> findAll();

	@Override
	void deleteById(Short id);

	List<ConcernShortView> findShortViewsBy();

	ConcernShortView findShortViewById(String id);
}
