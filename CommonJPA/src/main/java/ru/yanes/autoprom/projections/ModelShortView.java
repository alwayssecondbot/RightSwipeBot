package ru.yanes.autoprom.projections;

import org.springframework.beans.factory.annotation.Value;
import ru.yanes.autoprom.entity.GenerationPhoto;

import java.util.List;

public interface ModelShortView {
	int getId();
	@Value("#{target.brand.shortName + ' ' + target.fullName}")
	String getFullName();
	@Value("#{target.generations.stream().flatMap(g -> g.getPhotos().stream()).filter(p -> p.isMain()).toList()}")
	List<GenerationPhoto> getPhotos();
}
