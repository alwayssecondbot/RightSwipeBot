package ru.yanes.autoprom.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yanes.autoprom.entity.EnginePhoto;

@Repository
public interface EnginePhotoDAO extends JpaRepository<EnginePhoto,Long> {
}
