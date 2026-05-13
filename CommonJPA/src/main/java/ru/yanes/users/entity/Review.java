package ru.yanes.users.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import ru.yanes.YanesEntity;
import ru.yanes.autoprom.entity.Complectation;
import ru.yanes.autoprom.entity.Generation;
import ru.yanes.autoprom.records.Rating;
import ru.yanes.autoprom.entity.Variation;

import java.util.Date;
import java.util.Set;

@EqualsAndHashCode(exclude = "id",callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "reviews")
public class Review extends YanesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name = "account_id", updatable = false)
	private Account account;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name = "generation_id")
	private Generation generation;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, optional = true)
	@JoinColumn(name = "variation_id")
	private Variation variation;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, optional = true)
	@JoinColumn(name = "complectationr_id")
	private Complectation complectation;

	@Lob
	@Column(nullable = false, columnDefinition = "TEXT")
	private String description;

	@Column(nullable = false, columnDefinition = "DATE", updatable = false, insertable = false)
	@ColumnDefault("NOW()")
	private Date creationDate;

	@JdbcTypeCode(SqlTypes.JSON)
	@Column(columnDefinition = "JSONB")
	private Rating rating;

	@OneToMany(mappedBy = "review", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ReviewPhoto> photos;

	@Override
	public boolean hasFullView() {
		return true;
	}

	@Override
	public boolean hasShortView() {
		return true;
	}
}
