package ru.yanes.autoprom.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import lombok.*;

import ru.yanes.YanesEntity;
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

	@Column
	private short engine_capacity;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 25)
	private EngineType engine_type;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 25)
	private EnginePowerSystem engine_power_systyem;

	@Column
	private short engine_power;

	@Column
	private short engine_torque;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 25)
	private CylindersPosition cylinders_position;

	@Column
	private byte cylinders_quantity;

	@Column
	private byte valves_per_cylinder;

	@Column
	private short cylinders_diameter;

	@Column
	private short piston_stroke;

	@Column
	private byte compression_ratio;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 25)
	private FuelType fuel_type;

	@Column
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

enum CylindersPosition {FLAT, INLINE, V, W}
enum EnginePowerSystem {DIRECT, INDIRECT}
enum FuelType {DIESEL, HYBRID, PETROL, ELECTRO, AUTOGAS}
enum EngineType {WANKEL, ELECTRIC, MULTICYLINDER}
