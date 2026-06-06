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
@Table(name = "generation_photos", indexes = {
		@Index(name = "idx_generation_photos_generation_id_is_main", columnList = "generation_id", options = "WHERE is_main = TRUE"),
		@Index(name = "idx_generation_photos_generation_id_sort_order", columnList = "generation_id,sort_order")
})
public class GenerationPhoto{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name="generation_id", foreignKey = @ForeignKey(name = "fk_generations", foreignKeyDefinition = "FOREIGN KEY (generation_id) REFERENCES generations(id) ON DELETE RESTRICT ON UPDATE CASCADE"))
	private Generation generation;

	@Column(unique = true, nullable = false)
	private String url;

	@Column(nullable = false)
	@ColumnDefault("FALSE")
	private Boolean isMain;

	@Column(nullable = false)
	@ColumnDefault("0")
	private Byte sortOrder;
}
