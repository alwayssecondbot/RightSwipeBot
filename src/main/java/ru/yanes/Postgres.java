package ru.yanes;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.Properties;


public class Postgres {
    private static String URL;
    private static String USER;
    private static String PASSWORD;
    private static String init_db;
    private static String populate_db;


    Postgres() {
        try(InputStream input = getClass().getClassLoader().getResourceAsStream("application.properties")) {
            init_db = new String(Files.readAllBytes(Paths.get(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("database\\initDB.sql")).toURI()
            )));
            populate_db = new String(Files.readAllBytes(Paths.get(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("database\\populateDB.sql")).toURI()
            )));
            Properties properties = new Properties();
            properties.load(input);
            URL = properties.getProperty("database.url");
            USER = properties.getProperty("database.username");
            PASSWORD = properties.getProperty("database.password");
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }

    }

    public void initiateDB() {
        try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
            System.out.println("Database initiation...." + statement.executeUpdate(init_db));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void populateDB() {
        try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
            System.out.printf("Database population....\n" + statement.executeUpdate(populate_db));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
