package ru.yanes.users.entity;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "article_photos")
public class ArticlePhoto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name="article_id")
	Article article;

	@Column(unique = true, nullable = false)
	private String url;

	@Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
	private boolean is_main;

	@Column(nullable = false, columnDefinition = "SMALLINT DEFAULT 0")
	private byte sort_order;
}
