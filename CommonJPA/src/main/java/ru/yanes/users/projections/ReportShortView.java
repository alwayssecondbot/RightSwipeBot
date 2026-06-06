package ru.yanes.users.projections;

import org.springframework.beans.factory.annotation.Value;
import ru.yanes.users.entity.ReportPhoto;

import java.util.Date;
import java.util.Set;

public interface ReportShortView {
	Long getId();
	@Value("#{target.account.fullName}")
	String getAuthorName();
	@Value("#{target.generation.model.brand.shortName + ' ' + target.generation.model.fullName + ' ' + target.generation.fullName + ' ' + target.variation?.fullName + ' ' + target.complectation?.fullName}")
	String getCarFullName();
	@Value("#{target.creationDate}")
	Date getCreationDate();
}