package ru.yanes.Car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.yanes.Car.Parts.SqlEntity;
import ru.yanes.Postgres;

@AllArgsConstructor
public class Brand implements SqlEntity {
    @Getter
    private String brandName;
    private CountryCode brandCountry;
    private

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

    @Override
    public void addToBase(Postgres postgres) {
        postgres.executeSql("INSERT INTO public.brands (full_name, short_name, country_code, owner_id ) VALUES ('" + brandName + "', '', ''); COMMIT;"
                , "insert");
    }

    @Override
    public void editInBase(Postgres postgres) {

    }

    @Override
    public void deleteFromBase(Postgres postgres) {

    }

    @Override
    public void getFromBase(Postgres postgres) {

    }
}

