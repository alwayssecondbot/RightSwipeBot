package ru.yanes.users.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yanes.users.entity.Filter;
import ru.yanes.users.projections.FilterShortView;

import java.util.List;

@Repository
public interface FilterDAO extends JpaRepository<Filter, Long> {
	List<FilterShortView> findShortViewsBy();
}
