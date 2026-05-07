package ru.yanes.autoprom.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import lombok.*;

import ru.yanes.YanesEntity;
import ru.yanes.autoprom.enums.CylindersPosition;
import ru.yanes.autoprom.enums.EnginePowerSystem;
import ru.yanes.autoprom.enums.EngineType;
import ru.yanes.autoprom.enums.FuelType;

import java.util.Set;

@EqualsAndHashCode(exclude = "id",callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "engines")
public class Engine extends YanesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Size(max = 255, min = 3, message = "Length of attribute 'full_name' must be more than 3 and less than 255")
	@Column(nullable = false, unique = true)
	private String full_name;

	@Column(unique = true)
	private String photos;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "engine_parent_id")
	private Engine engine;

	@PositiveOrZero(message = "Field 'engine_capacity' must be positive.")
	@Column(check = @CheckConstraint(name = "positive_engine_capacity", constraint = "engine_capacity > 0"))
	private short engine_capacity;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 25)
	private EngineType engine_type;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 25)
	private EnginePowerSystem engine_power_systyem;

	@PositiveOrZero(message = "Field 'engine_power' must be positive.")
	@Column(check = @CheckConstraint(name = "positive_engine_power", constraint = "engine_power > 0"))
	private short engine_power;

	@PositiveOrZero(message = "Field 'engine_torque' must be positive.")
	@Column(check = @CheckConstraint(name = "positive_engine_torque", constraint = "engine_torque > 0"))
	private short engine_torque;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 25)
	private CylindersPosition cylinders_position;

	@PositiveOrZero(message = "Field 'cylinders_quantity' must be positive.")
	@Column(check = @CheckConstraint(name = "positive_cylinders_quantity", constraint = "cylinders_quantity > 0"))
	private byte cylinders_quantity;

	@PositiveOrZero(message = "Field 'valves_per_cylinder' must be positive.")
	@Column(check = @CheckConstraint(name = "positive_valves_per_cylinder", constraint = "valves_per_cylinder > 0"))
	private byte valves_per_cylinder;

	@PositiveOrZero(message = "Field 'cylinders_diameter' must be positive.")
	@Column(check = @CheckConstraint(name = "positive_cylinders_diameter", constraint = "cylinders_diameter > 0"))
	private short cylinders_diameter;

	@PositiveOrZero(message = "Field 'piston_stroke' must be positive.")
	@Column(check = @CheckConstraint(name = "positive_piston_stroke", constraint = "piston_stroke > 0"))
	private short piston_stroke;

	@PositiveOrZero(message = "Field 'compression_ratio' must be positive.")
	@Column(check = @CheckConstraint(name = "positive_compression_ratio", constraint = "compression_ratio > 0"))
	private byte compression_ratio;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 25)
	private FuelType fuel_type;

	@PositiveOrZero(message = "Field 'co2_emission' must be positive.")
	@Column(check = @CheckConstraint(name = "positive_co2_emission", constraint = "co2_emission > 0"))
	private short co2_emission;

	@Lob
	@Column(columnDefinition = "TEXT")
	private String review;

	@OneToMany(mappedBy = "engine", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Engine> engines;

	@OneToMany(mappedBy = "engine", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Variation> variations;

	@Override
	public boolean hasFullView() {
		return false;
	}

	@Override
	public boolean hasShortView() {
		return false;
	}
}

