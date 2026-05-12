package ru.yanes.users.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yanes.users.entity.ReviewPhoto;

@Repository
public interface ReviewPhotoDAO extends JpaRepository<ReviewPhoto,Long> {
}
