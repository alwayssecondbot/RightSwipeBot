package ru.yanes.users.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yanes.EntityNotFoundException;
import ru.yanes.users.dao.ReportDAO;
import ru.yanes.users.entity.Report;
import ru.yanes.users.service.ReportService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReportServiceImpl implements ReportService {

	private final ReportDAO repository;

	@Override
	@Transactional(readOnly = true)
	public Report findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	@Override
	@Transactional
	public Report save(Report object) {
		return repository.save(object);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Report> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}


}
