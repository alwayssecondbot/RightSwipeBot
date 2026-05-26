package ru.yanes.global.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Data;

import ru.yanes.YanesEntity;
import ru.yanes.users.entity.Offer;

import java.util.Set;

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
	private int id;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "country_code", foreignKey =@ForeignKey(name = "fk_countries", foreignKeyDefinition = "FOREIGN KEY (country_code) REFERENCES countries(code) ON DELETE RESTRICT ON UPDATE CASCADE"))
	private Country country;

	@Size(max = 200, min = 3, message = "Length of attribute 'name' must be more than 3 and less than 200")
	@Column(nullable = false, length = 200)
	private String fullName;

	@OneToMany(mappedBy = "city", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Offer> offers;


	@Override
	public boolean hasFullView() {
		return false;
	}

	@Override
	public boolean hasShortView() {
		return false;
	}
}
