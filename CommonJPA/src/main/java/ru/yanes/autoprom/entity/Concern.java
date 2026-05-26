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
@SQLDelete(sql = "UPDATE concerns SET is_deleted = true WHERE id = ?")
@SQLRestriction("is_deleted = false")
@Table(name = "concerns")
public class Concern extends YanesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(nullable = false, length = 50)
	private String shortName;

	@Column(nullable = false, length = 100)
	private String fullName;

	@Column(unique = true)
	private String logoUrl;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name = "country_code", nullable = false, foreignKey = @ForeignKey(name = "fk_countries", foreignKeyDefinition = "FOREIGN KEY (country_code) REFERENCES countries(code) ON DELETE RESTRICT ON UPDATE CASCADE"))
	private Country country;

	@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = false)
	@JoinColumn(name = "main_brand_id", foreignKey = @ForeignKey(name = "fk_brands", foreignKeyDefinition = "FOREIGN KEY (main_brand_id) REFERENCES brands(id) ON DELETE RESTRICT ON UPDATE CASCADE"))
	private Brand mainBrand;

	@PositiveOrZero(message = "Field 'capitalization' must be positive.")
	@Column(check = @CheckConstraint(name = "positive_capitalization", constraint = "capitalization > 0"))
	private int capitalization;

	@Column
	private byte grows;

	@Lob
	@Column(columnDefinition = "TEXT")
	private String descriptionHistory;

	@Column(nullable = false)
	@ColumnDefault("FALSE")
	private boolean isDeleted;

	@OneToMany(mappedBy = "concern", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Brand> brands;

	@Override
	public boolean hasFullView() {
		return true;
	}

	@Override
	public boolean hasShortView() {
		return true;
	}
}
