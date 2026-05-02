package ru.yanes.autoprom.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Data;

import ru.yanes.YanesEntity;
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
@Table(name = "generations")
public class Generation extends YanesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Size(max = 100, min = 3, message = "Length of attribute 'name' must be more than 3 and less than 100")
	@Column(nullable = false, length = 100)
	private String full_name;

	@Column(unique = true)
	private String photos;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name = "model_id")
	private Model model;

	@Enumerated
	@Column(nullable = false, length = 25)
	private CarClass car_class;

	@PositiveOrZero(message = "Field 'year_start' must be more than 1900.")
	@Column(check = @CheckConstraint(name = "positive_year_start", constraint = "year_start >= 1900 "))
	private short year_start;

	@PositiveOrZero(message = "Field 'year_stop' must be less than now.")
	@Column(check = @CheckConstraint(name = "positive_year_stop", constraint = "year_stop <= EXTRACT(YEAR FROM NOW())"))
	private short year_stop;

	@PositiveOrZero(message = "Field 'produced_auto' must be positive or zero.")
	@Column(check = @CheckConstraint(name = "positive_produced_auto", constraint = "produced_auto >= 0"))
	private int produced_auto;

	@PositiveOrZero(message = "Field 'sold_auto' must be positive or zero.")
	@Column(check = @CheckConstraint(name = "positive_sold_auto", constraint = "sold_auto >= 0"))
	private int sold_auto;

	@Lob
	@Column(columnDefinition = "TEXT")
	private String description_n_history;

	@PositiveOrZero(message = "Field 'price_max' must be positive or zero.")
	@Column(check = @CheckConstraint(name = "positive_price_max", constraint = "price_max >= 0"))
	private int price_max;

	@PositiveOrZero(message = "Field 'price_min' must be positive or zero.")
	@Column(check = @CheckConstraint(name = "positive_price_min", constraint = "price_min >= 0"))
	private int price_min;

	@OneToMany(mappedBy = "generation", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Complectation> complectations;

	@OneToMany(mappedBy = "generation", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Variation> variations;

	@OneToMany(mappedBy = "generation", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Report> reports;

	@OneToMany(mappedBy = "generation", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Review> reviews;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "liked_generations",
			joinColumns = @JoinColumn(name = "generation_id"),
			inverseJoinColumns = @JoinColumn(name = "account_id")
	)
	private Set<Account> liked_accounts = new HashSet<>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "favourite_generations",
			joinColumns = @JoinColumn(name = "generation_id"),
			inverseJoinColumns = @JoinColumn(name = "account_id")
	)
	private Set<Account> favourite_accounts = new HashSet<>();

	@Override
	public boolean hasFullView() {
		return true;
	}

	@Override
	public boolean hasShortView() {
		return true;
	}
}

enum CarClass { A, B, C, D, E, F, SUV, M, S}