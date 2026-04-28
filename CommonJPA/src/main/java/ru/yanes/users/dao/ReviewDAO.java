package ru.yanes.users.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yanes.users.entity.Review;

@Repository
public interface ReviewDAO extends JpaRepository<Review,Long> {
}