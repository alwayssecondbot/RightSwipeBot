package ru.yanes.users.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yanes.users.entity.ArticlePhoto;

@Repository
public interface ArticlePhotoDAO extends JpaRepository<ArticlePhoto,Long> {
}
