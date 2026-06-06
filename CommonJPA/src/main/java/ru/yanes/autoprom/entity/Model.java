package ru.yanes.autoprom.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Data;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import ru.yanes.YanesEntity;
import ru.yanes.users.entity.Account;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(exclude = "id",callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@BatchSize(size = 50)
@SQLDelete(sql = "UPDATE models SET is_deleted = true WHERE id = ?")
@SQLRestriction("is_deleted = false")
@Table(name = "models", indexes = @Index(name = "idx_models_brand_id", columnList = "brand_id"))
public class Model extends YanesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 100)
	private String fullName;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name = "brand_id", nullable = false, foreignKey = @ForeignKey(name = "fk_brands", foreignKeyDefinition = "FOREIGN KEY (brand_id) REFERENCES brands(id) ON DELETE RESTRICT ON UPDATE CASCADE"))
	private Brand brand;

	@Lob
	@Column(columnDefinition = "TEXT")
	private String descriptionHistory;

	@Column(nullable = false)
	@ColumnDefault("FALSE")
	private Boolean isDeleted;

	@OneToMany(mappedBy = "model", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@BatchSize(size = 25)
	private Set<Generation> generations;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "liked_models",
			joinColumns = @JoinColumn(name = "model_id"),
			inverseJoinColumns = @JoinColumn(name = "account_id")
	)
	@BatchSize(size = 25)
	private Set<Account> likedAccounts = new HashSet<>();

	@Override
	public Boolean hasFullView() {
		return true;
	}

	@Override
	public Boolean hasShortView() {
		return true;
	}
}
