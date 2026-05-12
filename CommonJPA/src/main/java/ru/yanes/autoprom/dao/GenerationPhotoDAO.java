package ru.yanes.autoprom.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yanes.autoprom.entity.GenerationPhoto;

@Repository
public interface GenerationPhotoDAO extends JpaRepository<GenerationPhoto,Long> {
}
