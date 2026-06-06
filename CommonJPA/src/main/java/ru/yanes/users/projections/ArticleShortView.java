package ru.yanes.users.projections;

import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

public interface ArticleShortView {
	Long getId();
	@Value("#{target.title}")
	String getTitle();
	@Value("#{target.creationDate}")
	Date getCreationDate();
	@Value("#{target.photos.?[isMain == true]}")
	String getMainPhotoUrl();
}
