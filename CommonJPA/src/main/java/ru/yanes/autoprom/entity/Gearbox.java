package ru.yanes.autoprom.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.Size;
import lombok.*;

import ru.yanes.YanesEntity;

import java.util.Set;

@EqualsAndHashCode(exclude = "id",callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "gearboxes")
public class Gearbox extends YanesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Size(max = 255, min = 3, message = "Length of attribute 'full_name' must be more than 3 and less than 255")
	@Column(nullable = false, unique = true)
	private String full_name;

	@Column(unique = true)
	private String photos;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "gearbox_parent_id")
	private Gearbox gearbox;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 25)
	private GearboxType gearbox_type;

	@Column
	private byte gear_quantity;

	@Lob
	@Column(columnDefinition = "TEXT")
	private String review;

	@OneToMany(mappedBy = "gearbox", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Gearbox> gearboxes;

	@OneToMany(mappedBy = "gearbox", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Variation> variations;

	@Override
	public boolean hasFullView() {
		return false;
	}

	@Override
	public boolean hasShortView() {
		return false;
	}
}

enum GearboxType {AMT, CVT, DCT, MT, TCA}
//enum GearboxType { BEVEL, HELICAL, PLANETARY, SPUR, WORM}