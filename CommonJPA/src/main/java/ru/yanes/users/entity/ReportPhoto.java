package ru.yanes.users.entity;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "report_photos")
public class ReportPhoto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name="report_id")
	Report report;

	@Column(unique = true, nullable = false)
	private String url;

	@Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
	private boolean is_main;

	@Column(nullable = false, columnDefinition = "SMALLINT DEFAULT 0")
	private byte sort_order;
}
