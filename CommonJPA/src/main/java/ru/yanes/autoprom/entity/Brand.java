package ru.yanes.autoprom.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.PositiveOrZero;
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
public class Brand extends YanesEntity<Short> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Size(max = 50, min = 3, message = "Length of attribute 'short_name' must be more than 3 and less than 50")
	@Column(nullable = false, length = 50)
	private String short_name;

	@Size(max = 100, min = 3, message = "Length of attribute 'full_name' must be more than 3 and less than 100")
	@Column(nullable = false, length = 100)
	private String full_name;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name = "country_code")
	private Country country;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name = "concern_id")
	private Concern concern;

	@Column(unique = true)
	private String logo;

	@PositiveOrZero(message = "Field 'capitalization' must be positive.")
	@Column(check = @CheckConstraint(name = "positive_capitalization", constraint = "capitalization > 0"))
	private int capitalization;

	@Column
	private byte grows;

	@Lob
	@Column(columnDefinition = "TEXT")
	private String description_n_history;

	@PositiveOrZero(message = "Field 'produced_auto' must be positive.")
	@Column(check = @CheckConstraint(name = "positive_produced_auto", constraint = "produced_auto > 0"))
	private int produced_auto;

	@PositiveOrZero(message = "Field 'sold_auto' must be positive.")
	@Column(check = @CheckConstraint(name = "positive_sold_auto", constraint = "sold_auto > 0"))
	private int sold_auto;

	@OneToMany(mappedBy = "brand", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
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
