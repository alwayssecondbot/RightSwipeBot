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
	private Short id;

	@Size(max = 100, min = 3, message = "Length of attribute 'name' must be more than 3 and less than 100")
	@Column(nullable = false, length = 100)
	private String full_name;

	@Size(max = 250, min = 250, message = "Length of attribute 'name' must be more than 3 and less than 250")
	@Column(nullable = false, unique = true, length = 250)
	private String photos;

	@ManyToOne
	@JoinColumn(name = "model_id",nullable = false)
	private Model model;

	@Column
	private Short year_start;

	@Column
	private Short year_stop;

	@Column
	private Integer produced_auto;

	@Column
	private Integer sold_auto;

	@Column
	private String description_n_history;

	@Column
	private Integer price_max;

	@Column
	private Integer price_min;

	@OneToMany
	private Set<Complectation> complectations;

	@Override
	public boolean hasFullView() {
		return true;
	}

	@Override
	public boolean hasShortView() {
		return true;
	}
}
