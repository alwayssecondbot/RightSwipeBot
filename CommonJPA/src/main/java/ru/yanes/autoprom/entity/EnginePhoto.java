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
@Table(name = "engine_photos", indexes = {
		@Index(name = "idx_engine_photos_engine_id_is_main", columnList = "engine_id", options = "WHERE is_main = TRUE"),
		@Index(name = "idx_engine_photos_engine_id_sort_order", columnList = "engine_id,sort_order")
})
public class EnginePhoto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name="engine_id", foreignKey = @ForeignKey(name = "fk_engines", foreignKeyDefinition = "FOREIGN KEY (engine_id) REFERENCES engines(id) ON DELETE RESTRICT ON UPDATE CASCADE"))
	Engine engine;

	@Column(unique = true, nullable = false)
	private String url;

	@Column(nullable = false)
	@ColumnDefault("FALSE")
	private boolean isMain;

	@Column(nullable = false)
	@ColumnDefault("0")
	private byte sortOrder;
}
