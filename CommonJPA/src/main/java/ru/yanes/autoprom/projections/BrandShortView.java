package ru.yanes.autoprom.projections;

import org.springframework.beans.factory.annotation.Value;
import ru.yanes.autoprom.entity.Concern;
import ru.yanes.global.entity.Country;

public interface BrandShortView {
	Short getId();
	@Value("#{target.shortName}")
	String getShortName();
	@Value("#{target.concern.shortName}")
	String getConcernShortName();
	@Value("#{target.country.fullName}")
	String getCountryFullName();
	@Value("#{target.logoUrl}")
	String getLogoUrl();
}
