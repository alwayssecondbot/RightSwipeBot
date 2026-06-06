package ru.yanes.users.entity;

import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import org.hibernate.annotations.*;
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
@SQLDelete(sql = "UPDATE offers SET is_deleted = true WHERE id = ?")
@SQLRestriction("is_deleted = false")
@Table(name = "offers", indexes = {
		@Index(name = "idx_offers_city_id", columnList = "city_id"),
		@Index(name = "idx_offers_variation_id", columnList = "variation_id"),
		@Index(name = "idx_offers_seller_account_id", columnList = "seller_account_id"),
		@Index(name = "idx_offers_creation_date", columnList = "creation_date"),
		@Index(name = "idx_offers_mileage", columnList = "mileage"),
		@Index(name = "idx_offers_price", columnList = "price")
})
public class Offer extends YanesEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name = "seller_account_id", updatable = false, foreignKey = @ForeignKey(name = "fk_accounts", foreignKeyDefinition = "FOREIGN KEY (seller_account_id) REFERENCES accounts(id) ON DELETE RESTRICT ON UPDATE CASCADE"))
	private Account account;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name = "city_id")
	private City city;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name = "variation_id", foreignKey = @ForeignKey(name = "fk_variations", foreignKeyDefinition = "FOREIGN KEY (variation_id) REFERENCES variations ON UPDATE CASCADE ON DELETE RESTRICT"))
	private Variation variation;

	@JdbcTypeCode(SqlTypes.JSON)
	@Column(columnDefinition = "JSONB", nullable = false)
	private Complectation complectation;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 25)
	private OfferType offerType;

	@PositiveOrZero(message = "Field 'price' must be positive or zero.")
	@Column(check = @CheckConstraint(name = "positive_price", constraint = "price >= 0"), nullable = false)
	private Long price;

	@Lob
	@Column(nullable = false, columnDefinition = "TEXT")
	private String description;

	@Column(nullable = false, columnDefinition = "DATE", updatable = false, insertable = false)
	@ColumnDefault("NOW()")
	private Date creationDate;

	@Column(nullable = false, columnDefinition = "DATE")
	private Date lastUpdate;

	@Column(nullable = false)
	@ColumnDefault("FALSE")
	private Boolean isDeleted;

	@Column(nullable = false)
	@ColumnDefault("FALSE")
	private Boolean wasInAccident;

	@PositiveOrZero(message = "Field 'mileage' must be positive or zero.")
	@Column(check = @CheckConstraint(name = "positive_mileage", constraint = "mileage >= 0"), nullable = false)
	private Integer mileage;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "vrc_id", updatable = false, check = @CheckConstraint(name = "may_empty_vrc", constraint = "offer_type = 'IN_STOCK' and vrc_id IS NOT NULL"),
	foreignKey = @ForeignKey(name = "fk_vrces", foreignKeyDefinition = "FOREIGN KEY (vrc_id) REFERENCES vrces(id) ON UPDATE CASCADE ON DELETE RESTRICT"))
	private Vrc vrc;

	@PositiveOrZero(message = "Field 'body_color' must be positive or zero.")
	@Column(check = @CheckConstraint(name = "range_body_color", constraint = "body_color >= 0 and body_color <= 128"), nullable = false)
	private Byte bodyColor;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 25)
	private BodyColorType bodyColorType;

	@PositiveOrZero(message = "Field 'interior_color' must be positive or zero.")
	@Column(check = @CheckConstraint(name = "range_interior_color", constraint = "interior_color >= 0 and interior_color <= 128"), nullable = false)
	private Byte interiorColor;

	@Column(nullable = false)
	@ColumnDefault("FALSE")
	private Boolean hasGuarantee;

	@Column(nullable = false)
	@ColumnDefault("FALSE")
	private Boolean mayChange;

	@OneToMany(mappedBy = "offer", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@BatchSize(size = 20)
	private Set<OfferPhoto> photos;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "liked_offers",
			joinColumns = @JoinColumn(name = "offer_id"),
			inverseJoinColumns = @JoinColumn(name = "account_id")
	)
	private Set<Account> likedAccounts = new HashSet<>();

	@Override
	public Boolean hasFullView() {
		return true;
	}

	@Override
	public Boolean hasShortView() {
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