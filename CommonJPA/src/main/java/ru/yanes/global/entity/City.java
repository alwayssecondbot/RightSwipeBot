package ru.yanes.global.entity;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Data;

import ru.yanes.YanesEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cities")
public class City extends YanesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Country country;

	@Size(max = 200, min = 3, message = "Length of attribute 'name' must be more than 3 and less than 200")
	@Column(nullable = false, length = 200)
	private String full_name;


	@Override
	public boolean hasFullView() {
		return false;
	}

	@Override
	public boolean hasShortView() {
		return false;
	}
}
