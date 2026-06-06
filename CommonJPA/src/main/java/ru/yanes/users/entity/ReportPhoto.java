package ru.yanes.users.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@EqualsAndHashCode
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "report_photos", indexes = {
		@Index(name = "idx_report_photos_report_id_is_main", columnList = "report_id", options = "WHERE is_main = TRUE"),
		@Index(name = "idx_report_photos_report_id_sort_order", columnList = "report_id,sort_order")
})
public class ReportPhoto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name="report_id", foreignKey = @ForeignKey(name = "fk_reports", foreignKeyDefinition = "FOREIGN KEY (report_id) REFERENCES reports(id) ON DELETE RESTRICT ON UPDATE CASCADE"))
	private Report report;

	@Column(unique = true, nullable = false)
	private String url;

	@Column(nullable = false)
	@ColumnDefault("FALSE")
	private Boolean isMain;

	@Column(nullable = false)
	@ColumnDefault("0")
	private Byte sortOrder;
}
