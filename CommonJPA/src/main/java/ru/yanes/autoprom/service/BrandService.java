package ru.yanes.autoprom.service;

import ru.yanes.YanesService;
import ru.yanes.autoprom.entity.Brand;
import ru.yanes.autoprom.projections.BrandShortView;

import java.util.List;

public interface BrandService extends YanesService<Brand,Short> {

	@Override
	Brand findById(Short id);

	@Override
	Brand save(Brand object);

	@Override
	List<Brand> findAll();

	@Override
	void deleteById(Short id);

	List<BrandShortView> findShortViewsBy();

	BrandShortView findShortViewById(Short id);
}
