package ru.yanes.users.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;
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
@Table(name = "reports", indexes = {
		@Index(name = "idx_reports_creation_date", columnList = "creation_date"),
		@Index(name = "idx_reports_account_id", columnList = "account_id"),
		@Index(name = "idx_reports_complectation_id", columnList = "complectation_id"),
		@Index(name = "idx_reports_generation_id", columnList = "generation_id"),
		@Index(name = "idx_reports_variation_id", columnList = "variation_id")
})
public class Report extends YanesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name = "account_id", updatable = false, foreignKey = @ForeignKey(name = "fk_accounts", foreignKeyDefinition = "FOREIGN KEY (account_id) REFERENCES accounts ON DELETE RESTRICT ON UPDATE CASCADE"))
	private Account account;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name = "generation_id", foreignKey = @ForeignKey(name = "fk_generations", foreignKeyDefinition = "FOREIGN KEY (generation_id) REFERENCES generations(id) ON DELETE RESTRICT ON UPDATE CASCADE"))
	private Generation generation;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, optional = true)
	@JoinColumn(name = "variation_id", foreignKey = @ForeignKey(name = "fk_variations", foreignKeyDefinition = "FOREIGN KEY (variation_id) REFERENCES variations(id) ON DELETE RESTRICT ON UPDATE CASCADE"))
	private Variation variation;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, optional = true)
	@JoinColumn(name = "complectation_id", foreignKey = @ForeignKey(name = "fk_complectations", foreignKeyDefinition = "FOREIGN KEY (complectation_id) REFERENCES complectations(id) ON DELETE RESTRICT ON UPDATE CASCADE"))
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

	@OneToMany(mappedBy = "report", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@BatchSize(size = 20)
	private Set<ReportPhoto> photos;

	@Override
	public Boolean hasFullView() {
		return true;
	}

	@Override
	public Boolean hasShortView() {
		return true;
	}
}
