package ru.yanes.car.parts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "countries")
public class Country {

    @Id
    @Pattern(regexp ="[0-9]{3}", message = "There must be only 3 digits in attribute 'code'.")
    @Column(name = "code", nullable = false, unique = true, length = 3)
    private String code;

    @Size(max = 200, min = 3, message = "Length of attribute 'name' must be more than 3 and less than 200")
    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @Pattern(regexp = "[a-zA-Z]{2}", message = "There must be only 2 symbols in attribute 'alpha2'.")
    @Column(name = "alpha2", nullable = false, unique = true, length = 2)
    private String alpha2;

    @Pattern(regexp = "[a-zA-Z]{3}", message = "There must be only 3 symbols in attribute 'alpha3'.")
    @Column(name = "alpha3", nullable = false, unique = true, length = 3)
    private String alpha3;
}
