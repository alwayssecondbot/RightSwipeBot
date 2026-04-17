package ru.yanes.autoprom.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import ru.yanes.YanesEntity;
import ru.yanes.global.entity.Country;

@Entity
public class Concern extends YanesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;

	@Size(max = 50, min = 3, message = "Length of attribute 'name' must be more than 3 and less than 50")
	@Column(name = "short_name", nullable = false, length = 50)
	private String short_name;

	@Size(max = 100, min = 3, message = "Length of attribute 'name' must be more than 3 and less than 100")
	@Column(name = "full_name", nullable = false, length = 100)
	private String full_name;

	@Size(max = 250, min = 250, message = "Length of attribute 'name' must be more than 3 and less than 250")
	@Column(name = "logo", nullable = false, unique = true, length = 250)
	private String logo;

	@ManyToOne
	@JoinColumn(name = "country_code", nullable = false)
	private Country country;

	@Column(name = "capitalization", nullable = true, unique = false)
	private Short capitalization;

	@Column(name = "grows",  nullable = true, unique = false)
	private Short grows;



	@Override
	public boolean hasFullView() {
		return true;
	}

	@Override
	public boolean hasShortView() {
		return true;
	}
}
