package ru.yanes.users.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@EqualsAndHashCode
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "offer_photos", indexes = {
		@Index(name = "idx_offer_photos_offer_id_is_main", columnList = "offer_id", options = "WHERE is_main = TRUE"),
		@Index(name = "idx_offer_photos_offer_id_sort_order", columnList = "offer_id, sort_order")
})
public class OfferPhoto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name="offer_id", foreignKey = @ForeignKey(name = "fk_offers", foreignKeyDefinition = "FOREIGN KEY (offer_id) REFERENCES offers(id) ON UPDATE CASCADE ON DELETE RESTRICT"))
	private Offer offer;

	@Column(unique = true, nullable = false)
	private String url;

	@Column(nullable = false)
	@ColumnDefault("FALSE")
	private Boolean isMain;

	@Column(nullable = false)
	@ColumnDefault("0")
	private Byte sortOrder;
}
