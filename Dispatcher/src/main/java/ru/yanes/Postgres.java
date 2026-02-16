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

import lombok.extern.slf4j.Slf4j;

@Slf4j
//TODO.csv перенести определение переменных в отдельную конфигурацию
public class Postgres {
    private static String URL;
    private static String USER;
    private static String PASSWORD;
    private static String init_db;
    private static String populate_db;
    private static String drop_db;
//    private static final Logger log = LogManager.getLogger(Postgres.class);

    Postgres() {

        try(InputStream input = getClass().getClassLoader().getResourceAsStream("application.yml")) {
            init_db = new String(Files.readAllBytes(Paths.get(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("database\\initDB.sql")).toURI()
            )));
            populate_db = new String(Files.readAllBytes(Paths.get(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("database\\populateDB.sql")).toURI()
            )));
            drop_db = new String(Files.readAllBytes(Paths.get(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("database\\dropDB.sql")).toURI()
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
        log.info("Initiate database....");
        try (Statement statement = getStatement()) {
//            System.out.printf("Updates count in creation is: %d\n", statement.getUpdateCount());
            if (!statement.execute(init_db) && statement.getUpdateCount() == 0){
                log.info(" - Tables have been created successfully");
            } else {
                log.warn(" - Something went wrong on table creation");
            }
        } catch (SQLException e) {
            log.error("There is an error: ", e);
        }
    }

    public void populateDB() {
        log.info("Fill database....");
        try (Statement statement = getStatement()) {
            statement.execute(populate_db);
            if (statement.getUpdateCount() != 0) {
                log.info(" - Tables have been filled successfully");
            } else {
                log.warn(" - Something went wrong on table filling");
            }
        } catch (SQLException e) {
            log.error("There is an error: ", e);
        }
    }

    public void dropDB(){
        log.info("Drop database....");
        try (Statement statement = getStatement()) {
            if (!statement.execute(drop_db) && statement.getUpdateCount() == 0) {
                log.info(" - Tables have been dropped successfully");
            } else {
                log.warn(" - Something went wrong on table dropping");
            }
        } catch (SQLException e) {
            log.error("There is an error: ", e);
        }
    }

//    public void executeSql(String sql, String sqlType){
//
//        try (Statement statement = getStatement()) {
//            boolean result = statement.execute(sql);
//            switch (sqlType){
//                case "select" :{
//                    if (result && statement.getResultSet() != null ) {
//                        System.out.println("- Select complete");
//                    } else {
//                        System.out.println("- Smth went wrong");
//                    }
//                    break;
//                }
//                case "insert":
//                case "update":
//                case "delete": {
//                    if (!result && statement.getUpdateCount() != 0) {
//                        System.out.println("- Changes completed");
//                    } else {
//                        System.out.println("- Nothing to change");
//                    }
//                    break;
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }


    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private Statement getStatement() throws SQLException {
        return getConnection().createStatement();
    }
}