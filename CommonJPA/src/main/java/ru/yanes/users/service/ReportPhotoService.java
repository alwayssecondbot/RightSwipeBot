package ru.yanes.users.service;

import ru.yanes.YanesService;
import ru.yanes.users.entity.ReportPhoto;

import java.util.List;

public interface ReportPhotoService extends YanesService<ReportPhoto, Long> {
	@Override
	ReportPhoto findById(Long id);

	@Override
	ReportPhoto save(ReportPhoto object);

	@Override
	List<ReportPhoto> findAll();

	@Override
	void deleteById(Long id);
}
