package ru.yanes.autoprom.projections;

import org.springframework.beans.factory.annotation.Value;
import ru.yanes.autoprom.entity.Brand;
import ru.yanes.global.entity.Country;

public interface ConcernShortView {
	short getId();
	@Value("#{target.shortName}")
	String getShortName();
	@Value("#{target.logoUrl}")
	String getLogoUrl();
	@Value("#{target.country.fullName}")
	String getCountryFullName();
	@Value("#{target.brand.shortName}")
	String getMainBrandShortName();
}
