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
@Table(name = "review_photos", indexes = {
		@Index(name = "idx_review_photos_review_id_is_main", columnList = "review_id", options = "WHERE is_main = TRUE"),
		@Index(name = "idx_review_photos_review_id_sort_order", columnList = "review_id,sort_order")
})
public class ReviewPhoto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name="review_id", foreignKey = @ForeignKey(name = "fk_reviews", foreignKeyDefinition = "FOREIGN KEY (review_id) REFERENCES reviews ON DELETE RESTRICT ON UPDATE CASCADE"))
	private Review review;

	@Column(unique = true, nullable = false)
	private String url;

	@Column(nullable = false)
	@ColumnDefault("FALSE")
	private Boolean isMain;

	@Column(nullable = false)
	@ColumnDefault("0")
	private Byte sortOrder;
}
