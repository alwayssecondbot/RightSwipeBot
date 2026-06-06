package ru.yanes.autoprom.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;

import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import ru.yanes.YanesEntity;
import ru.yanes.autoprom.enums.*;
import ru.yanes.autoprom.records.Rating;
import ru.yanes.users.entity.Account;
import ru.yanes.users.entity.Offer;
import ru.yanes.users.entity.Report;
import ru.yanes.users.entity.Review;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(exclude = "id",callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@BatchSize(size = 50)
@Table(name = "variations", indexes = {
		@Index(name = "idx_variations_generation_id", columnList = "generation_id"),
		@Index(name = "idx_variations_gearbox_id", columnList = "gearbox_id"),
		@Index(name = "idx_variations_engine_id", columnList = "engine_id"),
		@Index(name = "idx_variations_body_type", columnList = "body_type"),
		@Index(name = "idx_variations_acl_to_100", columnList = "acl_to_100"),
		@Index(name = "idx_variations_fuel_per_100", columnList = "fuel_per_100")
})
public class Variation extends YanesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 100)
	private String fullName;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name = "generation_id", foreignKey = @ForeignKey(name = "fk_generations", foreignKeyDefinition = "FOREIGN KEY (generation_id) REFERENCES generations(id) ON DELETE RESTRICT ON UPDATE CASCADE"))
	private Generation generation;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 25)
	private BodyType bodyType;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 25)
	private DriveType driveType;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, optional = true)
	@JoinColumn(name = "engine_id", foreignKey = @ForeignKey(name = "fk_engines", foreignKeyDefinition = "FOREIGN KEY (engine_id) REFERENCES engines(id) ON DELETE RESTRICT ON UPDATE CASCADE"))
	private Engine engine;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 25)
	private EnginePosition enginePosition;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 25)
	private BoostType boostType;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, optional = true)
	@JoinColumn(name = "gearbox_id", foreignKey = @ForeignKey(name = "fk_gearboxes", foreignKeyDefinition = "FOREIGN KEY (gearbox_id) REFERENCES gearboxes(id) ON DELETE RESTRICT ON UPDATE CASCADE"))
	private Gearbox gearbox;

	@JdbcTypeCode(SqlTypes.JSON)
	@Column(columnDefinition = "JSONB")
	private Rating rating;

	@JdbcTypeCode(SqlTypes.JSON)
	@Column(columnDefinition = "JSONB")
	private BodyProps bodyProps;

	@JdbcTypeCode(SqlTypes.JSON)
	@Column(columnDefinition = "JSONB")
	private SuspBrakeProps suspBrakeProps;

	@JdbcTypeCode(SqlTypes.JSON)
	@Column(columnDefinition = "JSONB")
	private OtherProps otherProps;

	@Lob
	@Column(columnDefinition = "TEXT")
	private String descriptionReview;

	@PositiveOrZero(message = "Field 'acl_to_100' must be positive.")
	@Column(check = @CheckConstraint(name = "positive_acl_to_100", constraint = "acl_to_100 > 0"))
	private Byte aclTo_100;

	@PositiveOrZero(message = "Field 'fuel_per_100' must be positive.")
	@Column(check = @CheckConstraint(name = "positive_fuel_per_100", constraint = "fuel_per_100 > 0"))
	private Byte fuelPer_100;

	@OneToMany(mappedBy = "variation", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@BatchSize(size = 20)
	private Set<Report> reports;

	@OneToMany(mappedBy = "variation", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@BatchSize(size = 20)
	private Set<Review> reviews;

	@OneToMany(mappedBy = "variation", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@BatchSize(size = 20)
	private Set<Offer> offers;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "liked_variations",
			joinColumns = @JoinColumn(name = "variation_id"),
			inverseJoinColumns = @JoinColumn(name = "account_id")
	)
	@BatchSize(size = 50)
	private Set<Account> likedAccounts = new HashSet<>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "favourite_variations",
			joinColumns = @JoinColumn(name = "variation_id"),
			inverseJoinColumns = @JoinColumn(name = "account_id")
	)
	@BatchSize(size = 50)
	private Set<Account> favouriteAccounts = new HashSet<>();

	@Override
	public Boolean hasFullView() {
		return false;
	}

	@Override
	public Boolean hasShortView() {
		return false;
	}
}

@Builder(toBuilder = true)
record BodyProps (
		short bodyLength,
		short bodyWidth,
		short bodyHeight,
		short groundClearance,
		short wheelBase,
		short frontTrack,
		short backTrack,
		byte doorsQuantity,
		byte seatsQuantity,
		short curbWeight,
		short grossWeight,
		short minTrunkCapacity,
		short maxTrunkCapacity,
		short tankCapacity
) {}

@Builder(toBuilder = true)
record SuspBrakeProps(
		SuspensionType frontSuspensionType,
		SuspensionType backSuspensionType,
		BrakeType frontBrakeType,
		BrakeType backBrakeType
){}

@Builder(toBuilder = true)
record OtherProps (
		short maxRange,
		WheelOrientationType wheelOrientation,
		byte ecoClass
) {}

