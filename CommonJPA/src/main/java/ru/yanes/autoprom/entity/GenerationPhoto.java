package ru.yanes.autoprom.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@EqualsAndHashCode
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "generation_photos")
public class GenerationPhoto{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name="generation_id", foreignKey = @ForeignKey(name = "fk_generations", foreignKeyDefinition = "FOREIGN KEY (generation_id) REFERENCES generations(id) ON DELETE RESTRICT ON UPDATE CASCADE"))
	Generation generation;

	@Column(unique = true, nullable = false)
	private String url;

	@Column(nullable = false)
	@ColumnDefault("FALSE")
	private boolean isMain;

	@Column(nullable = false)
	@ColumnDefault("0")
	private byte sortOrder;
}
