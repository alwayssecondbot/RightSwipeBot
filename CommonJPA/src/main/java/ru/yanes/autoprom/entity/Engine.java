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
	private String fullName;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "parent_id", foreignKey = @ForeignKey(name = "fk_engines", foreignKeyDefinition = "FOREIGN KEY (parent_id) REFERENCES engines(id) ON DELETE RESTRICT ON UPDATE CASCADE"))
	private Engine engine;

	@PositiveOrZero(message = "Field 'capacity' must be positive.")
	@Column(check = @CheckConstraint(name = "positive_capacity", constraint = "capacity > 0"))
	private short capacity;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 25)
	private EngineType type;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 25)
	private EnginePowerSystem powerSystem;

	@PositiveOrZero(message = "Field 'power' must be positive.")
	@Column(check = @CheckConstraint(name = "positive_power", constraint = "power > 0"))
	private short power;

	@PositiveOrZero(message = "Field 'torque' must be positive.")
	@Column(check = @CheckConstraint(name = "positive_torque", constraint = "torque > 0"))
	private short torque;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 25)
	private CylindersPosition cylindersPosition;

	@PositiveOrZero(message = "Field 'cylinders_quantity' must be positive.")
	@Column(check = @CheckConstraint(name = "positive_cylinders_quantity", constraint = "cylinders_quantity > 0"))
	private byte cylindersQuantity;

	@PositiveOrZero(message = "Field 'valves_per_cylinder' must be positive.")
	@Column(check = @CheckConstraint(name = "positive_valves_per_cylinder", constraint = "valves_per_cylinder > 0"))
	private byte valvesPerCylinder;

	@PositiveOrZero(message = "Field 'cylinders_diameter' must be positive.")
	@Column(check = @CheckConstraint(name = "positive_cylinders_diameter", constraint = "cylinders_diameter > 0"))
	private short cylindersDiameter;

	@PositiveOrZero(message = "Field 'piston_stroke' must be positive.")
	@Column(check = @CheckConstraint(name = "positive_piston_stroke", constraint = "piston_stroke > 0"))
	private short pistonStroke;

	@PositiveOrZero(message = "Field 'compression_ratio' must be positive.")
	@Column(check = @CheckConstraint(name = "positive_compression_ratio", constraint = "compression_ratio > 0"))
	private byte compressionRatio;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 25)
	private FuelType fuelType;

	@PositiveOrZero(message = "Field 'co2_emission' must be positive.")
	@Column(check = @CheckConstraint(name = "positive_co2_emission", constraint = "co2_emission > 0"))
	private short co2Emission;

	@Lob
	@Column(columnDefinition = "TEXT")
	private String review;

	@OneToMany(mappedBy = "engine", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<EnginePhoto> photos;

	@OneToMany(mappedBy = "engine", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Engine> engines;

	@OneToMany(mappedBy = "engine", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Variation> variations;

	@Override
	public boolean hasFullView() {
		return true;
	}

	@Override
	public boolean hasShortView() {
		return false;
	}
}

