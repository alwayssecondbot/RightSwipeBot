package ru.yanes.car.parts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;


import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "brands")
public class Brand{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Size(min = 5, max = 100, message = "Length of attribute 'full_name' must be more than 3 and less than 100")
    @Column(name = "full_name", nullable = false, unique = true, length = 100)
    private String brandFullName;

    @Size(max = 25, min = 2, message = "Length of attribute 'short_name' must be more than 2 and less than 25")
    @Column(name = "short_name", nullable = false, unique = true, length = 25)
    private String brandShortName;

    @ManyToOne
    @JoinColumn(name = "country_code", nullable = false)
    private Country country;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private Corporation owner;

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

