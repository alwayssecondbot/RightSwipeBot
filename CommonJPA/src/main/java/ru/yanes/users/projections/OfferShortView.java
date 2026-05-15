package ru.yanes.users.projections;

import org.springframework.beans.factory.annotation.Value;
import ru.yanes.autoprom.entity.Variation;
import ru.yanes.users.entity.OfferPhoto;
import ru.yanes.users.entity.Vrc;

import java.util.Date;
import java.util.Set;

public interface OfferShortView {
	long getId();
	@Value("#{target.variation.generation.model.brand.shortName + ' ' + target.variation.generation.model.fullName + ' ' + target.variation.generation.fullName + ' ' + target.variation.fullName + ' ' + target.complectation.fullName}")
	String getFullName();
	@Value("#{target.photos}")
	Set<OfferPhoto> getPhotos();
	@Value("#{target.price}")
	long getPrice();
	@Value("#{target.vrc.producedDate}")
	Date getVrcProduceDate();
	@Value("#{target.mileage}")
	int getMileage();
	@Value("#{target.creationDate}")
	Date getCreationDate();
}
