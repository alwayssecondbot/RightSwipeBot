package ru.yanes.users.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.yanes.autoprom.entity.Generation;
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
	@JoinTable(name = "favourite_generations",
			joinColumns = @JoinColumn(name = "account_id", foreignKey = @ForeignKey(name = "fk_accounts", foreignKeyDefinition = "FOREIGN KEY (account_id) REFERENCES accounts(id) ON DELETE RESTRICT ON UPDATE CASCADE")),
			inverseJoinColumns = @JoinColumn(name = "generation_id", foreignKey = @ForeignKey(name = "fk_generations", foreignKeyDefinition = "FOREIGN KEY (generation_id) REFERENCES generations(id) ON DELETE RESTRICT ON UPDATE CASCADE")),
			indexes = {
					@Index(name = "idx_favourite_generations_account_id", columnList = "account_id"),
					@Index(name = "idx_favourite_generations_generation_id", columnList = "generation_id")
			}
	)
	private Set<Generation> generations = new HashSet<>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "favourite_variations",
			joinColumns = @JoinColumn(name = "account_id", foreignKey = @ForeignKey(name = "fk_accounts", foreignKeyDefinition = "FOREIGN KEY (account_id) REFERENCES accounts(id) ON DELETE RESTRICT ON UPDATE CASCADE")),
			inverseJoinColumns = @JoinColumn(name = "variation_id", foreignKey = @ForeignKey(name = "fk_variations", foreignKeyDefinition = "FOREIGN KEY (variation_id) REFERENCES variations(id) ON DELETE RESTRICT ON UPDATE CASCADE")),
			indexes = {
					@Index(name = "idx_favourite_variations_account_id", columnList = "account_id"),
					@Index(name = "idx_favourite_variations_variation_id", columnList = "variation_id")
			}
	)
	private Set<Variation> variations = new HashSet<>();
}
