package ru.yanes.autoprom.entity;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import ru.yanes.YanesEntity;

@EqualsAndHashCode(exclude = "id",callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "variations")
public class Variation extends YanesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Size(max = 100, min = 3, message = "Length of attribute 'name' must be more than 3 and less than 100")
	@Column(nullable = false, length = 100)
	private String full_name;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name = "generation_id")
	private Generation generation;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 25)
	private BodyType body_type;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 25)
	private DriveType drive_type;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, optional = true)
	@JoinColumn(name = "engine_id")
	private Engine engine;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 25)
	private EnginePosition engine_position;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 25)
	private BoostType boost_type;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, optional = true)
	@JoinColumn(name = "gearbox_id")
	private Gearbox gearbox;

	@JdbcTypeCode(SqlTypes.JSON)
	@Column(columnDefinition = "JSONB")
	private JsonNode rating;

	@JdbcTypeCode(SqlTypes.JSON)
	@Column(columnDefinition = "JSONB")
	private JsonNode body_props;

	@JdbcTypeCode(SqlTypes.JSON)
	@Column(columnDefinition = "JSONB")
	private JsonNode susp_brake_props;

	@JdbcTypeCode(SqlTypes.JSON)
	@Column(columnDefinition = "JSONB")
	private JsonNode other_props;

	@Lob
	@Column(columnDefinition = "TEXT")
	private String description_n_review;

	@Column
	private byte acl_to_100;

	@Column
	private byte fuel_per_100;

	@Override
	public boolean hasFullView() {
		return false;
	}

	@Override
	public boolean hasShortView() {
		return false;
	}
}

enum BodyType { CABRIOLET, COUPE, CONVERTIBLE,
	CROSSOVER, HATCHBACK, LIMOUSINE,
	LIFTBACK, MICRO, MINIVAN,
	MUSCLE,	OFFROAD, PICKUP,
	ROADSTER, SEDAN, SPORT,
	SUV, VAN, WAGON
}
enum DriveType { FWD, RWD, _4WD, AWD}
enum EnginePosition { FRONT, CENTER, REAR}
enum BoostType {TURBOCHARGED, ATMOSPHERIC}
enum BrakeType {DISC, DRUM, BY_WIRE}
enum SuspensionType {ACTIVE, SPORT, AIR_SUSPENSION}
enum WheelOrientationType {LEFT, RIGHT, CENTRAL}