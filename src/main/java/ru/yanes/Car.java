package ru.yanes;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
//TODO переделать на билдер сначала вручную, потом через конструктор
@AllArgsConstructor
public class Car {
    private String name;
    private Brand brand;
    private String engineName;
    private String bodyType;
    private short weight;
    private short length;
    private short height;
    private short width;
    private short power;
}
