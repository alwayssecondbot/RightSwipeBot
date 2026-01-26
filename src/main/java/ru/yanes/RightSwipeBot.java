package ru.yanes;

import java.util.Scanner;
//TODO добавить логирование (перевести в аннотацию log)
class RightSwipeBot{
    public static void main(String[] args)  {
//        System.out.print("Set car's weight, height and width: ");
//        short[] bodyChars = new short[3];
//        for (int i = 0; i < 3; i++){
//            bodyChars[i]=in.nextShort();
//        }
//        in.close();

        Brand BMW = new Brand("BMW", CountryCode.DE);
        Car bmw3 = new Car("320i",BMW,"engine 120","sedan", (short) 1304,(short) 4987,(short) 1620,(short) 2012,(short) 156);
        System.out.printf("Your car's body type is %s, name is %s, country is %s", bmw3.getBodyType(), bmw3.getBrand().getBrandName() + " " + bmw3.getName(), bmw3.getBrand().getBrandCountry());


    }
}