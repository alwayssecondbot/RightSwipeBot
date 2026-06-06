package ru.yanes.autoprom.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Data;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import ru.yanes.YanesEntity;
import ru.yanes.autoprom.enums.CarClass;
import ru.yanes.users.entity.Account;
import ru.yanes.users.entity.Report;
import ru.yanes.users.entity.Review;

import java.util.HashSet;
import java.util.Set;


@EqualsAndHashCode(exclude = "id",callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@BatchSize(size = 50)
@SQLDelete(sql = "UPDATE generations SET is_deleted = true WHERE id = ?")
@SQLRestriction("is_deleted = false")
@Table(name = "generations", indexes = {
		@Index(name = "idx_generations_model_id", columnList = "model_id"),
		@Index(name = "idx_generations_car_class", columnList = "car_class")
})
public class Generation extends YanesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 100)
	private String fullName;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name = "model_id", foreignKey = @ForeignKey(name = "fk_models", foreignKeyDefinition = "FOREIGN KEY (model_id) REFERENCES models(id) ON DELETE RESTRICT ON UPDATE CASCADE"))
	private Model model;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 25)
	private CarClass carClass;

	@PositiveOrZero(message = "Field 'year_start' must be more than 1900.")
	@Column(check = @CheckConstraint(name = "positive_year_start", constraint = "year_start >= 1900 "))
	private Short yearStart;

	@PositiveOrZero(message = "Field 'year_stop' must be less than now.")
	@Column(check = @CheckConstraint(name = "positive_year_stop", constraint = "year_stop <= EXTRACT(YEAR FROM NOW())"))
	private Short yearStop;

	@PositiveOrZero(message = "Field 'produced_auto' must be positive or zero.")
	@Column(check = @CheckConstraint(name = "positive_produced_auto", constraint = "produced_auto >= 0"))
	private Integer producedAuto;

	@PositiveOrZero(message = "Field 'sold_auto' must be positive or zero.")
	@Column(check = @CheckConstraint(name = "positive_sold_auto", constraint = "sold_auto >= 0"))
	private Integer soldAuto;

	@Lob
	@Column(columnDefinition = "TEXT")
	private String descriptionHistory;

	@PositiveOrZero(message = "Field 'price_max' must be positive or zero.")
	@Column(check = @CheckConstraint(name = "positive_price_max", constraint = "price_max >= 0"))
	private Integer priceMax;

	@PositiveOrZero(message = "Field 'price_min' must be positive or zero.")
	@Column(check = @CheckConstraint(name = "positive_price_min", constraint = "price_min >= 0"))
	private Integer priceMin;

	@Column(nullable = false)
	@ColumnDefault("FALSE")
	private Boolean isDeleted;

	@OneToMany(mappedBy = "generation", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@BatchSize(size = 25)
	private Set<Complectation> complectations;

	@OneToMany(mappedBy = "generation", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@BatchSize(size = 25)
	private Set<Variation> variations;

	@OneToMany(mappedBy = "generation", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@BatchSize(size = 20)
	private Set<Report> reports;

	@OneToMany(mappedBy = "generation", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@BatchSize(size = 20)
	private Set<Review> reviews;

	@OneToMany(mappedBy = "generation", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@BatchSize(size = 20)
	private Set<GenerationPhoto> photos;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "liked_generations",
			joinColumns = @JoinColumn(name = "generation_id"),
			inverseJoinColumns = @JoinColumn(name = "account_id")
	)
	@BatchSize(size = 50)
	private Set<Account> likedAccounts = new HashSet<>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "favourite_generations",
			joinColumns = @JoinColumn(name = "generation_id"),
			inverseJoinColumns = @JoinColumn(name = "account_id")
	)
	@BatchSize(size = 50)
	private Set<Account> favouriteAccounts = new HashSet<>();



	@Override
	public Boolean hasFullView() {
		return true;
	}

	@Override
	public Boolean hasShortView() {
		return true;
	}
}


