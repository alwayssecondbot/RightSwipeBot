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
@Table(name = "filters", indexes = @Index(name = "idx_filters_account_id", columnList = "account_id"))
public class Filter extends YanesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name = "account_id", updatable = false, foreignKey = @ForeignKey(name = "fk_accounts", foreignKeyDefinition = "FOREIGN KEY (account_id) REFERENCES accounts ON DELETE RESTRICT ON UPDATE CASCADE"))
	private Account account;

	@Size(max = 50, min = 3, message = "Length of attribute 'full_name' must be more than 3 and less than 100")
	@Column(nullable = false, length = 50)
	private String fullName;

	@JdbcTypeCode(SqlTypes.JSON)
	@Column(columnDefinition = "JSONB")
	private PrimaryProps<?> primaryProps;

	@JdbcTypeCode(SqlTypes.JSON)
	@Column(columnDefinition = "JSONB")
	private ComplectationProps complectationProps;

	@JdbcTypeCode(SqlTypes.JSON)
	@Column(columnDefinition = "JSONB")
	private OfferProps offerProps;

	@JdbcTypeCode(SqlTypes.JSON)
	@Column(columnDefinition = "JSONB")
	private BodyProps bodyProps;

	@JdbcTypeCode(SqlTypes.JSON)
	@Column(columnDefinition = "JSONB")
	private EngineProps engineProps;

	@JdbcTypeCode(SqlTypes.JSON)
	@Column(columnDefinition = "JSONB")
	private GearboxProps gearboxProps;

	@JdbcTypeCode(SqlTypes.JSON)
	@Column(columnDefinition = "JSONB")
	private BrakeNSuspProps brakeNSuspProps;

	@JdbcTypeCode(SqlTypes.JSON)
	@Column(columnDefinition = "JSONB")
	private OtherProps otherProps;


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
	long[] priceRange,
	short[] productYearsRange,
	DriveType[] driveTypes,
	BodyType[] bodyTypes,
	String[] productCountryCodes,
	byte aclTo_100,
	byte fuelPer_100
){}

@Builder(toBuilder = true)
record CarModel<T>(
		String type,
		T id
) {}

@Builder(toBuilder = true)
record ComplectationProps(
	LightProps lightProps,
	AntitheftProps antitheftProps,
	InteriorProps interiorProps,
	SafetyProps safetyProps,
	MultimediaProps multimediaProps,
	ExteriorProps exteriorProps
) {}

@Builder(toBuilder = true)
record OfferProps(
		byte owners,
		boolean isVrcOriginal,
		OfferType[] offerTypes,
		boolean wasInAccident,
		boolean mayBeChanged,
		boolean hasGuarantee
) {}

@Builder(toBuilder = true)
record BodyProps(
		short[] bodyLengthRange,
		short[] bodyWidthRange,
		short[] bodyHeightRange,
		short[] tankCapacityRange,
		short[] trunkCapacityRange,
		byte[] seatsQuantityRange,
		byte[] doorsQuantityRange,
		short[] emptyWeightRange,
		short[] fullWeightRange,
		short[] wheelBaseRange,
		short[] frontTrackRange,
		short[] backTrackRange,
		byte[] bodyColors,
		BodyColorType[] colorTypes
){}

@Builder(toBuilder = true)
record EngineProps(
		short[] powerRange,
		EngineType[] engineTypes,
		BoostType[] boostTypes,
		short[] torqueRange,
		short[] engineCapacityRange,
		EnginePosition[] enginePositions,
		FuelType[] fuelTypes,
		EnginePowerSystem[] enginePowerSystems,
		byte[] compressionRange,
		short[] co2EmissionRange,
		CylindersPosition[] cylindersPositions,
		byte[] cylindersQuantityRange,
		byte[] valvesPerCylinderRange,
		short[] cylindersDiameterRange,
		short[] pistonStrokeRange
) {}

@Builder(toBuilder = true)
record GearboxProps(
		GearboxType[] gearboxTypes,
		byte[] gearQuantityRange
) {}

@Builder(toBuilder = true)
record BrakeNSuspProps(
		SuspensionType[] suspTypes,
		BrakeType[] brakeTypes
) {}

@Builder(toBuilder = true)
record OtherProps(
		short[] fullTankRange,
		WheelOrientationType[] wheelOrientations,
		byte[] ecoClasses
) {}