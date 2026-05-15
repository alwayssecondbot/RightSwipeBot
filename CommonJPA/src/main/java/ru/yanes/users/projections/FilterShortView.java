package ru.yanes.users.projections;

import org.springframework.beans.factory.annotation.Value;

public interface FilterShortView {
	long getId();
	@Value("#{target.fullName}")
	String getFullName();
}
