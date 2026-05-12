package ru.yanes.users.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yanes.users.entity.OfferPhoto;

@Repository
public interface OfferPhotoDAO extends JpaRepository<OfferPhoto,Long> {
}
