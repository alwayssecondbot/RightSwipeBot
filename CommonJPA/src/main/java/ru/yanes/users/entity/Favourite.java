package ru.yanes.users.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.yanes.autoprom.entity.Generation;
import ru.yanes.autoprom.entity.Model;
import ru.yanes.autoprom.entity.Variation;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class Favourite {

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "favourite_models",
			joinColumns = @JoinColumn(name = "account_id"),
			inverseJoinColumns = @JoinColumn(name = "model_id")
	)
	private Set<Model> models = new HashSet<>();


	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "favourite_generations",
			joinColumns = @JoinColumn(name = "account_id"),
			inverseJoinColumns = @JoinColumn(name = "generation_id")
	)
	private Set<Generation> generations = new HashSet<>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "favourite_variations",
			joinColumns = @JoinColumn(name = "account_id"),
			inverseJoinColumns = @JoinColumn(name = "variation_id")
	)
	private Set<Variation> variations = new HashSet<>();
}
