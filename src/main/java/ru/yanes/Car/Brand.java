package ru.yanes.Car;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Brand {
    @Getter
    private String brandName;
    private CountryCode brandCountry;

    public String getBrandCountry(String type){
        return switch (type) {
            case "code" -> brandCountry.getNumeric();
            case "alpha" -> brandCountry.getAlpha3();
            default -> brandCountry.getName();
        };
    }

    public String getBrandCountry(){
        return brandCountry.getName();
    }
}

