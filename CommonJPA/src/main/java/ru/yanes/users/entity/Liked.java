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
public class Liked {

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "liked_models",
			joinColumns = @JoinColumn(name = "account_id", foreignKey = @ForeignKey(name = "fk_accounts", foreignKeyDefinition = "FOREIGN KEY (account_id) REFERENCES accounts(id) ON DELETE RESTRICT ON UPDATE CASCADE")),
			inverseJoinColumns = @JoinColumn(name = "model_id", foreignKey = @ForeignKey(name = "fk_models", foreignKeyDefinition = "FOREIGN KEY (model_id) REFERENCES models(id) ON DELETE RESTRICT ON UPDATE CASCADE"))
	)
	private Set<Model> models = new HashSet<>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "liked_generations",
			joinColumns = @JoinColumn(name = "account_id", foreignKey = @ForeignKey(name = "fk_accounts", foreignKeyDefinition = "FOREIGN KEY (account_id) REFERENCES accounts(id) ON DELETE RESTRICT ON UPDATE CASCADE")),
			inverseJoinColumns = @JoinColumn(name = "generation_id", foreignKey = @ForeignKey(name = "fk_generations", foreignKeyDefinition = "FOREIGN KEY (generation_id) REFERENCES generations(id) ON DELETE RESTRICT ON UPDATE CASCADE"))
	)
	private Set<Generation> generations = new HashSet<>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "liked_variations",
			joinColumns = @JoinColumn(name = "account_id", foreignKey = @ForeignKey(name = "fk_accounts", foreignKeyDefinition = "FOREIGN KEY (account_id) REFERENCES accounts(id) ON DELETE RESTRICT ON UPDATE CASCADE")),
			inverseJoinColumns = @JoinColumn(name = "variation_id", foreignKey = @ForeignKey(name = "fk_variations", foreignKeyDefinition = "FOREIGN KEY (variation_id) REFERENCES variations(id) ON DELETE RESTRICT ON UPDATE CASCADE"))
	)
	private Set<Variation> variations = new HashSet<>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "liked_offers",
			joinColumns = @JoinColumn(name = "account_id", foreignKey = @ForeignKey(name = "fk_accounts", foreignKeyDefinition = "FOREIGN KEY (account_id) REFERENCES accounts(id) ON DELETE RESTRICT ON UPDATE CASCADE")),
			inverseJoinColumns = @JoinColumn(name = "offer_id", foreignKey = @ForeignKey(name = "fk_offers", foreignKeyDefinition = "FOREIGN KEY (offer_id) REFERENCES offers(id) ON DELETE RESTRICT ON UPDATE CASCADE"))
	)
	private Set<Offer> offers = new HashSet<>();
}
