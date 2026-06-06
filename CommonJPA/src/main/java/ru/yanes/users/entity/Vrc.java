package ru.yanes.users.entity;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import ru.yanes.YanesEntity;

import java.util.Date;

@EqualsAndHashCode(exclude = "id",callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "vrces")
public class Vrc extends YanesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, updatable = false)
	private Boolean isOriginal;

	@Column(nullable = false, columnDefinition = "DATE", updatable = false)
	private Date producedDate;

	@JdbcTypeCode(SqlTypes.JSON)
	@Column(columnDefinition = "JSONB", nullable = false, updatable = false)
	private JsonNode owners;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "vrc", optional = false)
	private Offer offer;


	@Override
	public Boolean hasFullView() {
		return false;
	}

	@Override
	public Boolean hasShortView() {
		return false;
	}
}
