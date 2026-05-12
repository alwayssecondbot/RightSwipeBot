package ru.yanes.users.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yanes.EntityNotFoundException;
import ru.yanes.users.dao.ReportPhotoDAO;
import ru.yanes.users.entity.ReportPhoto;
import ru.yanes.users.service.ReportPhotoService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReportPhotoServiceImpl implements ReportPhotoService {

	private final ReportPhotoDAO repository;

	@Override
	@Transactional(readOnly = true)
	public ReportPhoto findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
	}

	@Override
	@Transactional
	public ReportPhoto save(ReportPhoto object) {
		return repository.save(object);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReportPhoto> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
