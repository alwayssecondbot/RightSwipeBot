package ru.yanes.users.service;

import ru.yanes.YanesService;
import ru.yanes.users.entity.Report;

import java.util.List;

public interface ReportService extends YanesService<Report, Long> {
	@Override
	Report findById(Long id);

	@Override
	Report save(Report object);

	@Override
	List<Report> findAll();

	@Override
	void deleteById(Long id);
}
