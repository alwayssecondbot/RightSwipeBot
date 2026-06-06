package ru.yanes.autoprom.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.*;

import org.hibernate.annotations.BatchSize;
import ru.yanes.YanesEntity;
import ru.yanes.autoprom.enums.GearboxType;

import java.util.Set;

@EqualsAndHashCode(exclude = "id",callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@BatchSize(size = 50)
@Table(name = "gearboxes", indexes = {
		@Index(name = "idx_gearboxes_type", columnList = "type"),
		@Index(name = "idx_gearboxes_parent_id", columnList = "parent_id")
})
public class Gearbox extends YanesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Size(max = 255, min = 3, message = "Length of attribute 'full_name' must be more than 3 and less than 255")
	@Column(nullable = false, unique = true)
	private String fullName;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "parent_id", foreignKey = @ForeignKey(name = "fk_gearboxes", foreignKeyDefinition = "FOREIGN KEY (parent_id) REFERENCES gearboxes(id) ON DELETE RESTRICT ON UPDATE CASCADE"))
	private Gearbox gearbox;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 25)
	private GearboxType type;

	@PositiveOrZero(message = "Field 'gear_quantity' must be positive.")
	@Column(check = @CheckConstraint(name = "positive_gear_quantity", constraint = "gear_quantity > 0"))
	private Byte gearQuantity;

	@Lob
	@Column(columnDefinition = "TEXT")
	private String review;

	@OneToMany(mappedBy = "gearbox", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@BatchSize(size = 20)
	private Set<GearboxPhoto> photos;

	@OneToMany(mappedBy = "gearbox", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@BatchSize(size = 25)
	private Set<Gearbox> gearboxes;

	@OneToMany(mappedBy = "gearbox", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@BatchSize(size = 20)
	private Set<Variation> variations;

	@Override
	public Boolean hasFullView() {
		return true;
	}

	@Override
	public Boolean hasShortView() {
		return false;
	}
}

//enum GearboxType { BEVEL, HELICAL, PLANETARY, SPUR, WORM}