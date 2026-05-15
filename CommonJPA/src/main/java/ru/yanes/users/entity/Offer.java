package ru.yanes.users.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import ru.yanes.YanesEntity;
import ru.yanes.autoprom.entity.Variation;
import ru.yanes.autoprom.records.*;
import ru.yanes.global.entity.City;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(exclude = "id",callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "offers")
public class Offer extends YanesEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name = "seller_account_id", updatable = false)
	private Account account;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name = "city_id")
	private City city;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name = "variation_id")
	private Variation variation;

	@JdbcTypeCode(SqlTypes.JSON)
	@Column(columnDefinition = "JSONB", nullable = false)
	private Complectation complectation;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 25)
	private OfferType offerType;

	@PositiveOrZero(message = "Field 'price' must be positive or zero.")
	@Column(check = @CheckConstraint(name = "positive_price", constraint = "price >= 0"), nullable = false)
	private long price;

	@Lob
	@Column(nullable = false, columnDefinition = "TEXT")
	private String description;

	@Column(nullable = false, columnDefinition = "DATE", updatable = false, insertable = false)
	@ColumnDefault("NOW()")
	private Date creationDate;

	@Column(nullable = false)
	private Date lastUpdate;

	@Column(nullable = false)
	@ColumnDefault("TRUE")
	private boolean isActual;

	@Column(nullable = false)
	@ColumnDefault("FALSE")
	private boolean wasInAccident;

	@PositiveOrZero(message = "Field 'mileage' must be positive or zero.")
	@Column(check = @CheckConstraint(name = "positive_mileage", constraint = "mileage >= 0"), nullable = false)
	private int mileage;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
	@JoinColumn(name = "vrc_id", updatable = false, check = @CheckConstraint(name = "may_empty_vrc", constraint = "offer_type = 'IMPORT'"))
	private Vrc vrc;

	@PositiveOrZero(message = "Field 'body_color' must be positive or zero.")
	@Column(check = @CheckConstraint(name = "positive_body_color", constraint = "body_color >= 0"), nullable = false)
	private byte bodyColor;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 25)
	private BodyColorType bodyColorType;

	@PositiveOrZero(message = "Field 'interior_color' must be positive or zero.")
	@Column(check = @CheckConstraint(name = "positive_interior_color", constraint = "interior_color >= 0"), nullable = false)
	private byte interiorColor;

	@Column(nullable = false)
	@ColumnDefault("FALSE")
	private boolean hasGuarantee;

	@Column(nullable = false)
	@ColumnDefault("FALSE")
	private boolean mayChange;

	@OneToMany(mappedBy = "offer", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<OfferPhoto> photos;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "liked_offers",
			joinColumns = @JoinColumn(name = "offer_id"),
			inverseJoinColumns = @JoinColumn(name = "account_id")
	)
	private Set<Account> likedAccounts = new HashSet<>();

	@Override
	public boolean hasFullView() {
		return true;
	}

	@Override
	public boolean hasShortView() {
		return true;
	}
}

enum OfferType {IN_STOCK, IMPORT}
enum BodyColorType {GLOSS, METALLIC, CHROME, CARBON, MATTE, IRIDESCENT, CHAMELEON_FLAKE, COLOR_SHIFT}

@Builder(toBuilder = true)
record Complectation(
		int complectationId,
		LightProps lightProps,
		AntitheftProps antitheftProps,
		InteriorProps interiorProps,
		SafetyProps safetyProps,
		MultimediaProps multimediaProps,
		ExteriorProps exteriorProps
) {}