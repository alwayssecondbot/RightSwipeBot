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
@Table(name = "gearbox_photos", indexes = {
		@Index(name = "idx_gearbox_photos_gearbox_id_is_main", columnList = "gearbox_id", options = "WHERE is_main = TRUE"),
		@Index(name = "idx_gearbox_photos_gearbox_id_sort_order", columnList = "gearbox_id,sort_order")
})
public class GearboxPhoto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name="gearbox_id", foreignKey = @ForeignKey(name = "fk_gearboxes", foreignKeyDefinition = "FOREIGN KEY (gearbox_id) REFERENCES gearboxes(id) ON DELETE RESTRICT ON UPDATE CASCADE"))
	private Gearbox gearbox;

	@Column(unique = true, nullable = false)
	private String url;

	@Column(nullable = false)
	@ColumnDefault("FALSE")
	private Boolean isMain;

	@Column(nullable = false)
	@ColumnDefault("0")
	private Byte sortOrder;
}
