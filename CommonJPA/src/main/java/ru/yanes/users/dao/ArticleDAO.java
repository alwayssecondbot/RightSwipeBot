package ru.yanes.users.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yanes.users.entity.Article;

@Repository
public interface ArticleDAO extends JpaRepository<Article,Long> {
}
