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
@Table(name = "brands")
public class Brand extends YanesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;

	@Size(max = 50, min = 3, message = "Length of attribute 'name' must be more than 3 and less than 50")
	@Column(nullable = false, length = 50)
	private String short_name;

	@Size(max = 100, min = 3, message = "Length of attribute 'name' must be more than 3 and less than 100")
	@Column(nullable = false, length = 100)
	private String full_name;

	@Size(max = 250, min = 250, message = "Length of attribute 'name' must be more than 3 and less than 250")
	@Column(nullable = false, unique = true, length = 250)
	private String logo;

	@ManyToOne
	@JoinColumn(name = "country_code",nullable = false)
	private Country country;

	@ManyToOne
	@JoinColumn(name = "concern_id",nullable = false)
	private Concern concern;

	@Column
	private Integer capitalization;

	@Column
	private Byte grows;

	@Column
	private String description_n_history;

	@Column
	private Integer produced_auto;

	@Column
	private Integer sold_auto;

	@OneToMany
	private Set<Model> models;

	@Override
	public boolean hasFullView() {
		return true;
	}

	@Override
	public boolean hasShortView() {
		return true;
	}
}
