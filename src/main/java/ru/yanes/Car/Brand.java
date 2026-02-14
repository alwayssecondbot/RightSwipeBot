package ru.yanes.Car;

import jakarta.persistence.*;
import lombok.Getter;
import ru.yanes.Car.Parts.Corporation;
import ru.yanes.Car.Parts.Country;


@Getter
@Entity
@Table(name = "brands")
public class Brand{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short idl;

    @Column(name = "full_name", nullable = false, unique = true)
    private String brandFullName;

    @Column(name = "short_name", nullable = false, unique = true)
    private String brandShortName;

    @ManyToOne
    @JoinColumn(name = "country_code", nullable = false)
    private Country country;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private Corporation owner;

    public Brand(){}
//    public String getBrandCountry(String type){
//        return switch (type) {
//            case "code" -> brandCountry.getNumeric();
//            case "alpha" -> brandCountry.getAlpha3();
//            default -> brandCountry.getName();
//        };
//    }

//    public String getBrandCountry(){
//        return brandCountry.getName();
//    }
}

