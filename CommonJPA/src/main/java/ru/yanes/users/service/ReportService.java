package ru.yanes.users.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yanes.EntityNotFoundException;
import ru.yanes.users.dao.ReportDAO;
import ru.yanes.users.entity.Report;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReportService {

	private final ReportDAO repository;

	public Report findById(long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	public Report save(Report object) {
		return repository.save(object);
	}

	public List<Report> findAll() {
		return repository.findAll();
	}
}
