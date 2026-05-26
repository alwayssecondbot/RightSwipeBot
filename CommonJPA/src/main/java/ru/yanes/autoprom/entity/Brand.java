package ru.yanes.autoprom.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Data;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import ru.yanes.YanesEntity;
import ru.yanes.global.entity.Country;

import java.util.Set;

@EqualsAndHashCode(exclude = "id",callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@SQLDelete(sql = "UPDATE brands SET is_deleted = true WHERE id = ?")
@SQLRestriction("is_deleted = false")
@Table(name = "brands")
public class Brand extends YanesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(nullable = false, length = 50)
	private String shortName;

	@Column(nullable = false, length = 100)
	private String fullName;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name = "country_code", foreignKey = @ForeignKey(name = "fk_countries", foreignKeyDefinition = "FOREIGN KEY (country_code) REFERENCES countries(code) ON DELETE RESTRICT ON UPDATE CASCADE"))
	private Country country;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name = "concern_id", foreignKey = @ForeignKey(name = "fk_concerns", foreignKeyDefinition = "FOREIGN KEY (concern_id) REFERENCES concerns(id) ON DELETE RESTRICT ON UPDATE CASCADE"))
	private Concern concern;

	@Column(unique = true)
	private String logoUrl;

	@PositiveOrZero(message = "Field 'capitalization' must be positive.")
	@Column(check = @CheckConstraint(name = "positive_capitalization", constraint = "capitalization > 0"))
	private int capitalization;

	@Column
	private byte grows;

	@Lob
	@Column(columnDefinition = "TEXT")
	private String descriptionHistory;

	@PositiveOrZero(message = "Field 'produced_auto' must be positive.")
	@Column(check = @CheckConstraint(name = "positive_produced_auto", constraint = "produced_auto > 0"))
	private int producedAuto;

	@PositiveOrZero(message = "Field 'sold_auto' must be positive.")
	@Column(check = @CheckConstraint(name = "positive_sold_auto", constraint = "sold_auto > 0"))
	private int soldAuto;

	@Column(nullable = false)
	@ColumnDefault("FALSE")
	private boolean isDeleted;

	@OneToMany(mappedBy = "brand", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Model> models;

	@Override
	public boolean hasFullView() {
		return true;
	}

	@Override
	public boolean hasShortView() {
		return true;
	}
}
