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
@Table(name = "review_photos")
public class ReviewPhoto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name="review_id", foreignKey = @ForeignKey(name = "fk_reviews", foreignKeyDefinition = "FOREIGN KEY (review_id) REFERENCES reviews ON DELETE RESTRICT ON UPDATE CASCADE"))
	Review review;

	@Column(unique = true, nullable = false)
	private String url;

	@Column(nullable = false)
	@ColumnDefault("FALSE")
	private boolean isMain;

	@Column(nullable = false)
	@ColumnDefault("0")
	private byte sortOrder;
}
