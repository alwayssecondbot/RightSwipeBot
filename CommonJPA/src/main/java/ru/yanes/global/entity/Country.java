package ru.yanes.global.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Data;

import ru.yanes.YanesEntity;
import ru.yanes.autoprom.entity.Concern;
import ru.yanes.users.entity.Account;

import java.util.Set;

@Data
@Builder
@EqualsAndHashCode(exclude = "code", callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "countries")
public class Country extends YanesEntity {
	@Id
	@Pattern(regexp ="[0-9]{3}", message = "There must be only 3 digits in attribute 'code'.")
	@Column(nullable = false, unique = true, length = 3, check = @CheckConstraint(name = "valid_code", constraint = "LENGTH(code) = 3 AND code ~* '^[0-9]{3}'"))
	private String code;

	@Column(nullable = false, length = 200)
	private String fullName;

	@Pattern(regexp = "[a-zA-Z]{2}", message = "There must be only 2 symbols in attribute 'alpha2'.")
	@Column(nullable = false, unique = true, length = 2, check = @CheckConstraint(name = "valid_alpha2", constraint = "LENGTH(alpha2) = 2"))
	private String alpha2;

	@Pattern(regexp = "[a-zA-Z]{3}", message = "There must be only 3 symbols in attribute 'alpha3'.")
	@Column(nullable = false, unique = true, length = 3, check = @CheckConstraint(name = "valid_alpha3", constraint = "LENGTH(alpha3) = 3"))
	private String alpha3;

	@Column(unique = true)
	private String flagUrl;

	@OneToMany(mappedBy = "country", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<City> cities;

	@OneToMany(mappedBy = "country", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Concern> concerns;

	@OneToMany(mappedBy = "country", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Account> accounts;

	@Override
	public boolean hasFullView() {
		return true;
	}

	@Override
	public boolean hasShortView() {
		return true;
	}
}
