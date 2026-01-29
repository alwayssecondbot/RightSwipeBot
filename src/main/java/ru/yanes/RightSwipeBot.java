package ru.yanes;

import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.Scanner;

//TODO добавить логирование (перевести в аннотацию log)
//TODO добавить запись в БД
class RightSwipeBot{
    public static void main(String[] args){
        fixSystemOutEncoding();
//        System.out.print("Set car's weight, height and width: ");
//        short[] bodyChars = new short[3];
//        for (int i = 0; i < 3; i++){
//            bodyChars[i]=in.nextShort();
//        }
//        in.close();


        Scanner scanner = new Scanner(System.in);
        Postgres postgres = new Postgres();

        System.out.print("Select action: 1 - create, 2 - drop: ");
        switch (scanner.nextShort()) {
            case 1:
                postgres.initiateDB();
                postgres.populateDB();
                break;
            case 2:
                postgres.dropDB();
                break;
        }

        Brand BMW = new Brand("BMW", CountryCode.DE);
        Car bmw3 = new Car("320i",BMW,"engine 120","sedan", (short) 1304,(short) 4987,(short) 1620,(short) 2012,(short) 156);
        System.out.printf("Your car's body type is %s, name is %s, country is %s.\n", bmw3.getBodyType(), bmw3.getBrand().getBrandName() + " " + bmw3.getName(), bmw3.getBrand().getBrandCountry());

    }
    private static void fixSystemOutEncoding() {
        // Принудительная установка UTF-8 для System.out
        System.setOut(new java.io.PrintStream(System.out, true, StandardCharsets.UTF_8));
        System.setErr(new java.io.PrintStream(System.err, true, StandardCharsets.UTF_8));
    }
}