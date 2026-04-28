package ru.yanes.users.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yanes.users.entity.Offer;

@Repository
public interface OfferDAO extends JpaRepository<Offer,Long> {
}