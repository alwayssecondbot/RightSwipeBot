package ru.yanes.autoprom.projections;

import org.springframework.beans.factory.annotation.Value;
import ru.yanes.autoprom.entity.Brand;
import ru.yanes.autoprom.entity.GenerationPhoto;

import java.util.Set;

public interface ModelShortView {
	int getId();
	@Value("#{target.brand.shortName + ' ' + target.fullName}")
	String getFullName();
	@Value("#{target.photos}")
	Set<GenerationPhoto> getPhotos();
}
