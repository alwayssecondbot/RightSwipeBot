package ru.yanes.users.projections;

import org.springframework.beans.factory.annotation.Value;

public interface FilterShortView {
	Long getId();
	@Value("#{target.fullName}")
	String getFullName();
}
