package ru.yanes.autoprom.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Data;

import ru.yanes.YanesEntity;
import ru.yanes.global.entity.Country;

import java.util.Set;

@EqualsAndHashCode(exclude = "id",callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "concerns")
public class Concern extends YanesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Size(max = 50, min = 3, message = "Length of attribute 'short_name' must be more than 3 and less than 50")
	@Column(nullable = false, length = 50)
	private String short_name;

	@Size(max = 100, min = 3, message = "Length of attribute 'full_name' must be more than 3 and less than 100")
	@Column(nullable = false, length = 100)
	private String full_name;

	@Column(unique = true)
	private String logo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country_code", nullable = false)
	private Country country;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "main_brand_id", nullable = false)
	private Brand main_brand;

	@Column
	private int capitalization;

	@Column
	private byte grows;

	@Lob
	@Column(columnDefinition = "TEXT")
	private String description_n_history;

	@OneToMany(mappedBy = "concern", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Brand> brands;

	@Override
	public boolean hasFullView() {
		return true;
	}

	@Override
	public boolean hasShortView() {
		return true;
	}
}
