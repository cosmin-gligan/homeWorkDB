package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private Connection connection;
    private static String database = "sci"; //atentie, eu am numit baza mea de date "sci"
    private static String url = "jdbc:postgresql://localhost:5432/" + database;
    private static String username = "postgres";
    private static String password = "postgres";

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url, username, password);
    }

}
