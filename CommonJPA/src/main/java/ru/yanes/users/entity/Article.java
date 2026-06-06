package ru.yanes.users.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import ru.yanes.YanesEntity;
import ru.yanes.autoprom.records.Rating;

import java.util.Date;
import java.util.Set;

//Delayed until next times
@EqualsAndHashCode(exclude = "id",callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "articles", indexes = @Index(name = "idx_articles_creation_date", columnList = "creation_date"))
public class Article extends YanesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String title;

	@Lob
	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;

	@Column(nullable = false, columnDefinition = "DATE", updatable = false, insertable = false)
	@ColumnDefault("NOW()")
	private Date creationDate;

	@JdbcTypeCode(SqlTypes.JSON)
	@Column(columnDefinition = "JSONB")
	private Rating rating;

	@OneToMany(mappedBy = "article", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@BatchSize(size = 20)
	private Set<ArticlePhoto> photos;

	@Override
	public Boolean hasFullView() {
		return true;
	}

	@Override
	public Boolean hasShortView() {
		return true;
	}
}