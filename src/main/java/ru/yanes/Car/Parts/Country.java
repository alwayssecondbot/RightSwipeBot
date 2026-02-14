package ru.yanes.Car.Parts;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "countries")
public class Country {

    @Id
    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "alpha2", nullable = false, unique = true)
    private String alpha2;

    @Column(name = "alpha3", nullable = false, unique = true)
    private String alpha3;

    public Country(){}
}
