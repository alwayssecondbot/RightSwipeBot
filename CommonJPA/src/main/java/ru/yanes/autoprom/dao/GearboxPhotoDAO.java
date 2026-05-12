package ru.yanes.autoprom.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yanes.autoprom.entity.GearboxPhoto;

@Repository
public interface GearboxPhotoDAO extends JpaRepository<GearboxPhoto,Long> {
}
