package ru.yanes.autoprom.projections;

import org.springframework.beans.factory.annotation.Value;
import ru.yanes.autoprom.entity.GenerationPhoto;

import java.util.Set;

public interface GenerationShortView {
	int getId();
	@Value("#{target.model.brand.shortName + ' ' + target.model.fullName + ' ' + target.fullName}")
	String getFullName();
	@Value("#{target.photos}")
	Set<GenerationPhoto> getPhotos();
}
