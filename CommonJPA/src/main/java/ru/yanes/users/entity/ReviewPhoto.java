package ru.yanes.users.entity;

import jakarta.persistence.*;
import lombok.*;

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
	@JoinColumn(name="review_id")
	Review review;

	@Column(unique = true, nullable = false)
	private String url;

	@Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
	private boolean is_main;

	@Column(nullable = false, columnDefinition = "SMALLINT DEFAULT 0")
	private byte sort_order;
}
