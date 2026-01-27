package ru.yanes;

import java.sql.*;

public class DriverCheck {
    public static void main(String[] args) {
        System.out.println("=== Проверка драйверов ===");

        // 1. Проверка classpath
        String classpath = System.getProperty("java.class.path");
        System.out.println("Classpath: " + classpath);

        // 2. Попытка загрузить драйвер
        try {
            Class<?> driverClass = Class.forName("org.postgresql.Driver");
            System.out.println("Драйвер найден: " + driverClass.getName());

            // 3. Проверка доступных драйверов
            System.out.println("\nЗарегистрированные драйверы:");
            java.util.Enumeration<Driver> drivers = DriverManager.getDrivers();
            while (drivers.hasMoreElements()) {
                Driver driver = drivers.nextElement();
                System.out.println("  " + driver.getClass().getName());
            }

        } catch (ClassNotFoundException e) {
            System.err.println("Драйвер PostgreSQL НЕ найден в classpath!");
            System.err.println("Добавьте postgresql-42.x.x.jar в classpath");
        }
    }
}