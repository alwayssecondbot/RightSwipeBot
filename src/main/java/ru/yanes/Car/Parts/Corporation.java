package ru.yanes.Car.Parts;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "corporations")
public class Corporation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_code", nullable = false)
    private Country country;

    public Corporation(){}

}
