package ru.yanes.global.projections;

import org.springframework.beans.factory.annotation.Value;

public interface CountryShortView {
	@Value("#{target.code}")
	String getId();
	@Value("#{target.fullName}")
	String getFullName();
	@Value("#{target.flagUrl}")
	String getFlagUrl();
}
