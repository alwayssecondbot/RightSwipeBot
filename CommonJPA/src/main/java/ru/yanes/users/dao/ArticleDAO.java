package ru.yanes.users.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yanes.users.entity.Article;
import ru.yanes.users.projections.ArticleShortView;

import java.util.List;

@Repository
public interface ArticleDAO extends JpaRepository<Article,Long> {
	List<ArticleShortView> findShortViewsBy();
}
