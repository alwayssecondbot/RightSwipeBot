package ru.yanes.users.projections;

import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

public interface ReviewShortView {
	Long getId();
	@Value("#{target.account.fullName}")
	String getAuthorName();
	@Value("#{target.generation.model.brand.shortName + ' ' + target.generation.model.fullName + ' ' + target.generation.fullName + ' ' + target.variation.fullName + ' ' + target.complectation.fullName}")
	String getCarFullName();
	@Value("#{target.creationDate}")
	Date getCreationDate();
}
