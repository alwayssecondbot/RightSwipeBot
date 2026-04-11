package ru.yanes.entities.global.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yanes.entities.global.Country;

public interface CountryReposytory extends JpaRepository<Country, String> {
}
