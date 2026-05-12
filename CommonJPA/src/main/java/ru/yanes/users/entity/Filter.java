package ru.yanes.users.entity;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import ru.yanes.YanesEntity;
import ru.yanes.autoprom.enums.*;
import ru.yanes.autoprom.records.*;

@EqualsAndHashCode(exclude = "id",callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "filters")
public class Filter extends YanesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name = "account_id", updatable = false)
	private Account account;

	@Size(max = 50, min = 3, message = "Length of attribute 'full_name' must be more than 3 and less than 100")
	@Column(nullable = false, length = 50)
	private String full_name;

	@JdbcTypeCode(SqlTypes.JSON)
	@Column(columnDefinition = "JSONB")
	private PrimaryProps<?> primary_props;

	@JdbcTypeCode(SqlTypes.JSON)
	@Column(columnDefinition = "JSONB")
	private ComplectationProps complectation_props;

	@JdbcTypeCode(SqlTypes.JSON)
	@Column(columnDefinition = "JSONB")
	private OfferProps offer_props;

	@JdbcTypeCode(SqlTypes.JSON)
	@Column(columnDefinition = "JSONB")
	private BodyProps body_props;

	@JdbcTypeCode(SqlTypes.JSON)
	@Column(columnDefinition = "JSONB")
	private EngineProps engine_props;

	@JdbcTypeCode(SqlTypes.JSON)
	@Column(columnDefinition = "JSONB")
	private GearboxProps gearbox_props;

	@JdbcTypeCode(SqlTypes.JSON)
	@Column(columnDefinition = "JSONB")
	private BrakeNSuspProps brake_n_susp_props;

	@JdbcTypeCode(SqlTypes.JSON)
	@Column(columnDefinition = "JSONB")
	private OtherProps other_props;


	@Override
	public boolean hasFullView() {
		return true;
	}

	@Override
	public boolean hasShortView() {
		return true;
	}
}

@Builder(toBuilder = true)
record PrimaryProps<T>(
	CarModel<T>[] cars,
	long[] price_range,
	short[] product_years_range,
	DriveType[] drive_types,
	BodyType[] body_types,
	String[] product_country_codes,
	byte acl_to_100,
	byte fuel_per_100
){}

@Builder(toBuilder = true)
record CarModel<T>(
		String type,
		T id
) {}

@Builder(toBuilder = true)
record ComplectationProps(
	LightProps light_props,
	AntitheftProps antitheft_props,
	InteriorProps interior_props,
	SafetyProps safety_props,
	MultimediaProps multimedia_props,
	ExteriorProps exterior_props
) {}

@Builder(toBuilder = true)
record OfferProps(
		byte owners,
		boolean is_vrc_original,
		OfferType[] offer_types,
		boolean was_in_accident,
		boolean may_be_changed,
		boolean has_guarantee
) {}

@Builder(toBuilder = true)
record BodyProps(
		short[] body_length_range,
		short[] body_width_range,
		short[] body_heigth_range,
		short[] tank_capacity_range,
		short[] trunk_capacity_range,
		byte[] seats_quantity_range,
		byte[] doors_quantity_range,
		short[] empty_weight_range,
		short[] full_weight_range,
		short[] wheel_base_range,
		short[] front_track_range,
		short[] back_track_range,
		byte[] body_colors,
		BodyColorType[] color_types
){}

@Builder(toBuilder = true)
record EngineProps(
		short[] power_range,
		EngineType[] engine_types,
		BoostType[] boost_types,
		short[] torque_range,
		short[] engine_capacity_range,
		EnginePosition[] engine_positions,
		FuelType[] fuel_types,
		EnginePowerSystem[] engine_power_systems,
		byte[] compression_range,
		short[] co2_emission_range,
		CylindersPosition[] cylinders_positions,
		byte[] cylinders_quantity_range,
		byte[] valves_per_cylinder_range,
		short[] cylinders_diameter_range,
		short[] piston_stroke_range
) {}

@Builder(toBuilder = true)
record GearboxProps(
		GearboxType[] gearbox_types,
		byte[] gear_quantity_range
) {}

@Builder(toBuilder = true)
record BrakeNSuspProps(
		SuspensionType[] susp_types,
		BrakeType[] brake_types
) {}

@Builder(toBuilder = true)
record OtherProps(
		short[] full_tank_range,
		WheelOrientationType[] wheel_orientations,
		byte[] eco_classes
) {}