package ru.yanes.autoprom.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Data;

import ru.yanes.YanesEntity;

import java.util.Set;


@EqualsAndHashCode(exclude = "id",callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "complectations")
public class Generation extends YanesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Size(max = 100, min = 3, message = "Length of attribute 'name' must be more than 3 and less than 100")
	@Column(nullable = false, length = 100)
	private String full_name;

	@Column(unique = true)
	private String photos;

	@ManyToOne
	@JoinColumn(name = "model_id",nullable = false)
	private Model model;

	@Enumerated
	private CarClass  car_class;

	@Column
	private short year_start;

	@Column
	private short year_stop;

	@Column
	private int produced_auto;

	@Column
	private int sold_auto;

	@Lob
	@Column(columnDefinition = "TEXT")
	private String description_n_history;

	@Column
	private int price_max;

	@Column
	private int price_min;

	@OneToMany(mappedBy = "generation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Complectation> complectations;

	@OneToMany(mappedBy = "generation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Variation> variations;

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