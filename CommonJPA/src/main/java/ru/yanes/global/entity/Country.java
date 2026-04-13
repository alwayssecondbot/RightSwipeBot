package ru.yanes.global.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import ru.yanes.YanesEntity;

@Setter
@Getter
@Builder
@EqualsAndHashCode(exclude = "code", callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "countries")
public class Country extends YanesEntity {
	@Id
	@Pattern(regexp ="[0-9]{3}", message = "There must be only 3 digits in attribute 'code'.")
	@Column(name = "code", nullable = false, unique = true, length = 3)
	private String code;

	@Size(max = 200, min = 3, message = "Length of attribute 'name' must be more than 3 and less than 200")
	@Column(name = "name", nullable = false, length = 200)
	private String name;

	@Pattern(regexp = "[a-zA-Z]{2}", message = "There must be only 2 symbols in attribute 'alpha2'.")
	@Column(name = "alpha2", nullable = false, unique = true, length = 2)
	private String alpha2;

	@Pattern(regexp = "[a-zA-Z]{3}", message = "There must be only 3 symbols in attribute 'alpha3'.")
	@Column(name = "alpha3", nullable = false, unique = true, length = 3)
	private String alpha3;

	@Override
	public boolean hasFullView() {
		return true;
	}

	@Override
	public boolean hasShortView() {
		return true;
	}
}
