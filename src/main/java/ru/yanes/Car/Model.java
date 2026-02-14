package ru.yanes.Car;

import jakarta.persistence.*;
import lombok.Getter;
import ru.yanes.Car.Parts.Country;

import java.util.Date;

@Getter
@Entity
@Table(name = "car_models")
public class Model extends Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model_name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "assemble_country", nullable = false)
    private Country country;

    @Column(name = "assemble_date", nullable = false)
    private Date date;

    public Model(){}

}
