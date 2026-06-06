package ru.yanes.users.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import ru.yanes.YanesEntity;
import ru.yanes.global.entity.Country;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@EqualsAndHashCode(exclude = "id",callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@BatchSize(size = 50)
@SQLDelete(sql = "UPDATE accounts SET is_deleted = true WHERE id = ?")
@SQLRestriction("is_deleted = false")
@Table(name = "accounts", indexes = @Index(name = "idx_accounts_country_code", columnList = "country_code"))
public class Account extends YanesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, check = @CheckConstraint(name = "valid_mail", constraint = "mail ~* '^[a-z0-9!#$%&''*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&''*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$'"),
	length = 100)
	private String mail;

	@Column(length = 100, nullable = false, unique = true, updatable = false)
	private String login;

	@Column(length = 30, unique = true, check = @CheckConstraint(name = "valid_phone_number", constraint = "phone_number ~ '^\\+[1-9]{1,9} \\([0-9]{3}\\) [0-9]{7}$'"))
	private String phoneNumber;

	@Column
	private String fullName;

	@Column(columnDefinition = "DATE")
	private Date birthday;

	@Column(unique = true)
	private String photoUrl;

	@Column(nullable = false)
	@ColumnDefault("FALSE")
	private Boolean isCorporation;

	@Column(nullable = false, columnDefinition = "DATE", insertable = false, updatable = false)
	@ColumnDefault("NOW()")
	private Date creationDate;

	@Column(nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private LocalDateTime lastOnline;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "country_code", foreignKey = @ForeignKey(name = "fk_country", foreignKeyDefinition = "FOREIGN KEY (country_code) REFERENCES countries(code) ON DELETE RESTRICT ON UPDATE CASCADE"))
	private Country country;

	@Column(columnDefinition = "DATE")
	private Date driveSince;

	@Column(nullable = false)
	@ColumnDefault("FALSE")
	private Boolean isVerified;

	@Column(nullable = false)
	@ColumnDefault("FALSE")
	private Boolean isDeleted;

	@Embedded
	private Liked liked;

	@Embedded
	private Favourite favourite;

	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@BatchSize(size = 20)
	private Set<Offer> offers;

	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@BatchSize(size = 20)
	private Set<Filter> filters;

	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@BatchSize(size = 20)
	private Set<Report> reports;

	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@BatchSize(size = 20)
	private Set<Review> reviews;

	@Override
	public Boolean hasFullView() {
		return true;
	}

	@Override
	public Boolean hasShortView() {
		return false;
	}
}
