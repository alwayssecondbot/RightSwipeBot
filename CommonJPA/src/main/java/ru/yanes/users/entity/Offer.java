package ru.yanes.users.entity;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import ru.yanes.YanesEntity;
import ru.yanes.autoprom.entity.Variation;
import ru.yanes.global.entity.City;

import java.util.Date;

@EqualsAndHashCode(exclude = "id",callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "accounts")
public class Offer extends YanesEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name = "seller_account_id")
	private Account account;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name = "city_id")
	private City city;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name = "variation_id")
	private Variation variation;

	@JdbcTypeCode(SqlTypes.JSON)
	@Column(columnDefinition = "JSONB", nullable = false)
	private JsonNode complectation;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 25)
	private OfferType offerType;

	@Column(nullable = false)
	private long price;

	@Column(unique = true)
	private String photos;

	@Lob
	@Column(nullable = false, columnDefinition = "TEXT")
	private String description;

	@Column(nullable = false, columnDefinition = "DATE DEFAULT NOW()")
	private Date creation_date;

	@Column(nullable = false, columnDefinition = "DATE DEFAULT NOW()")
	private Date last_update;

	@Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
	private boolean is_actual;

	@Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
	private boolean was_in_accident;

	@Column(nullable = false)
	private short mileage;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name = "vrc_id")
	private Vrc vrc;

	@Column(nullable = false)
	private byte body_color;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 25)
	private BodyColorType body_color_type;

	@Column(nullable = false)
	private byte interior_color;

	@Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
	private boolean has_guarantee;

	@Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
	private boolean may_change;

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