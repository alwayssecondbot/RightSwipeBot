package ru.yanes.autoprom.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.*;
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
@Table(name = "variations")
public class Variation extends YanesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Size(max = 100, min = 3, message = "Length of attribute 'full_name' must be more than 3 and less than 100")
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
	private Rating rating;

	@JdbcTypeCode(SqlTypes.JSON)
	@Column(columnDefinition = "JSONB")
	private BodyProps body_props;

	@JdbcTypeCode(SqlTypes.JSON)
	@Column(columnDefinition = "JSONB")
	private SuspBrakeProps susp_brake_props;

	@JdbcTypeCode(SqlTypes.JSON)
	@Column(columnDefinition = "JSONB")
	private OtherProps other_props;

	@Lob
	@Column(columnDefinition = "TEXT")
	private String description_n_review;

	@PositiveOrZero(message = "Field 'acl_to_100' must be positive.")
	@Column(check = @CheckConstraint(name = "positive_acl_to_100", constraint = "acl_to_100 > 0"))
	private byte acl_to_100;

	@PositiveOrZero(message = "Field 'fuel_per_100' must be positive.")
	@Column(check = @CheckConstraint(name = "positive_fuel_per_100", constraint = "fuel_per_100 > 0"))
	private byte fuel_per_100;

	@OneToMany(mappedBy = "variation", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Report> reports;

	@OneToMany(mappedBy = "variation", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Review> reviews;

	@OneToMany(mappedBy = "variation", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Offer> offers;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "liked_variations",
			joinColumns = @JoinColumn(name = "variation_id"),
			inverseJoinColumns = @JoinColumn(name = "account_id")
	)
	private Set<Account> liked_accounts = new HashSet<>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "favourite_variations",
			joinColumns = @JoinColumn(name = "variation_id"),
			inverseJoinColumns = @JoinColumn(name = "account_id")
	)
	private Set<Account> favourite_accounts = new HashSet<>();

	@Override
	public boolean hasFullView() {
		return false;
	}

	@Override
	public boolean hasShortView() {
		return false;
	}
}
@Builder(toBuilder = true)
record BodyProps (
		short body_length,
		short body_width,
		short body_heigth,
		short ground_clearanse,
		short wheel_base,
		short front_track,
		short back_track,
		byte doors_quantity,
		byte seats_quantity,
		short curb_weight,
		short gross_weight,
		short min_trunk_capacity,
		short max_trunk_capacity,
		short tank_capacity
) {}

@Builder(toBuilder = true)
record SuspBrakeProps(
		SuspensionType front_suspension_type,
		SuspensionType back_suspension_type,
		BrakeType front_brake_type,
		BrakeType back_brake_type
){}

@Builder(toBuilder = true)
record OtherProps (
		short max_range,
		WheelOrientationType wheel_orientation,
		byte eco_class,
		short fuel_consumption
) {}

