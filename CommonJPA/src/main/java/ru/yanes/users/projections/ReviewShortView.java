package ru.yanes.users.projections;

import org.springframework.beans.factory.annotation.Value;
import ru.yanes.autoprom.entity.Complectation;
import ru.yanes.autoprom.entity.Variation;
import ru.yanes.users.entity.ReviewPhoto;

import java.util.Date;
import java.util.Set;

public interface ReviewShortView {
	Long getId();
	@Value("#{target.account.fullName}")
	String getAuthorName();
	@Value("#{target.generation.model.brand.shortName + ' ' + target.generation.model.fullName + ' ' + target.generation.fullName + ' ' + target.variation.fullName + ' ' + target.complectation.fullName}")
	String getCarFullName();
	@Value("#{target.creationDate}")
	Date getCreationDate();
}
