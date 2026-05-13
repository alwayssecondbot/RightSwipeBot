package ru.yanes.users.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
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
@Table(name = "accounts")
public class Account extends YanesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(unique = true, check = @CheckConstraint(name = "valid_mail", constraint = "mail ~* '^[a-z0-9!#$%&''*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&''*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$'"),
	length = 100)
	private String mail;

	@Column(length = 100, nullable = false, unique = true, updatable = false)
	private String login;

	@Column(length = 30, unique = true, check = @CheckConstraint(name = "valid_phone_number", constraint = "phone_number ~ '^\\+[1-9]{1,9} \\([0-9]{3}\\) [0-9]{7}$'"))
	private String phoneNumber;

	@Column
	private String fullName;

	@Column
	private Date birthday;

	@Column(unique = true)
	private String photoUrl;

	@Column(nullable = false)
	@ColumnDefault("FALSE")
	private boolean isCorporation;

	@Column(nullable = false, columnDefinition = "DATE", insertable = false, updatable = false)
	@ColumnDefault("NOW()")
	private Date creationDate;

	@Column(nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private LocalDateTime lastOnline;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "country_code")
	private Country country;

	@Column
	private Date driveSince;

	@Column(nullable = false)
	@ColumnDefault("FALSE")
	private boolean isVerified;

	@Embedded
	private Liked liked;

	@Embedded
	private Favourite favourite;

	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Offer> offers;

	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Filter> filters;

	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Report> reports;

	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Review> reviews;

	@Override
	public boolean hasFullView() {
		return true;
	}

	@Override
	public boolean hasShortView() {
		return false;
	}
}
