package ru.yanes.users.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yanes.users.entity.ReportPhoto;

@Repository
public interface ReportPhotoDAO extends JpaRepository<ReportPhoto,Long> {
}
