package ru.yanes.autoprom.entity;

import com.fasterxml.jackson.databind.JsonNode;
import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.*;

import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Data;

import org.hibernate.annotations.Type;
import ru.yanes.YanesEntity;


@EqualsAndHashCode(exclude = "id",callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "complectations")
public class Complectation extends YanesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Size(max = 100, min = 3, message = "Length of attribute 'name' must be more than 3 and less than 100")
	@Column(nullable = false, length = 100)
	private String full_name;

	@ManyToOne
	@JoinColumn(name = "generation_id",nullable = false)
	private Generation generation;

	@Type(JsonBinaryType.class)
	@Column(columnDefinition = "jsonb", nullable = false)
	private JsonNode light_props;

	@Type(JsonBinaryType.class)
	@Column(columnDefinition = "jsonb", nullable = false)
	private JsonNode antitheft_props;

	@Type(JsonBinaryType.class)
	@Column(columnDefinition = "jsonb", nullable = false)
	private JsonNode interior_props;

	@Type(JsonBinaryType.class)
	@Column(columnDefinition = "jsonb", nullable = false)
	private JsonNode safety_props;

	@Type(JsonBinaryType.class)
	@Column(columnDefinition = "jsonb", nullable = false)
	private JsonNode multimedia_props;

	@Type(JsonBinaryType.class)
	@Column(columnDefinition = "jsonb", nullable = false)
	private JsonNode exterior_props;

	@Override
	public boolean hasFullView() {
		return false;
	}

	@Override
	public boolean hasShortView() {
		return false;
	}
}
