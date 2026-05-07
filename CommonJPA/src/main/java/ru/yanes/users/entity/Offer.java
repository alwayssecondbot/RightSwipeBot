package ru.yanes.users.entity;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
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
public class Offer extends YanesEntity<Long>{
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

	@Column(unique = true)
	private String photos;

	@Lob
	@Column(nullable = false, columnDefinition = "TEXT")
	private String description;

	@Column(nullable = false, columnDefinition = "DATE DEFAULT NOW()", updatable = false, insertable = false)
	private Date creation_date;

	@Column(nullable = false)
	private Date last_update;

	@Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
	private boolean is_actual;

	@Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
	private boolean was_in_accident;

	@PositiveOrZero(message = "Field 'mileage' must be positive or zero.")
	@Column(check = @CheckConstraint(name = "positive_mileage", constraint = "mileage >= 0"), nullable = false)
	private short mileage;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = true, orphanRemoval = true)
	@JoinColumn(name = "vrc_id", updatable = false, check = @CheckConstraint(name = "may_empty_vrc", constraint = "offer_type = 'IMPORT'"))
	private Vrc vrc;

	@PositiveOrZero(message = "Field 'body_color' must be positive or zero.")
	@Column(check = @CheckConstraint(name = "positive_body_color", constraint = "body_color >= 0"), nullable = false)
	private byte body_color;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 25)
	private BodyColorType body_color_type;

	@PositiveOrZero(message = "Field 'interior_color' must be positive or zero.")
	@Column(check = @CheckConstraint(name = "positive_interior_color", constraint = "interior_color >= 0"), nullable = false)
	private byte interior_color;

	@Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
	private boolean has_guarantee;

	@Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
	private boolean may_change;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "liked_offers",
			joinColumns = @JoinColumn(name = "offer_id"),
			inverseJoinColumns = @JoinColumn(name = "account_id")
	)
	private Set<Account> liked_accounts = new HashSet<>();

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
		int complectation_id,
		LightProps light_props,
		AntitheftProps antitheft_props,
		InteriorProps interior_props,
		SafetyProps safety_props,
		MultimediaProps multimedia_props,
		ExteriorProps exterior_props
) {}