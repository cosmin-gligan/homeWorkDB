package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionSingletonNOTUSED {

    private static DatabaseConnectionSingletonNOTUSED instance;
    private Connection connection;
    private static String database = "sci";
    private static String url = "jdbc:postgresql://localhost:5432/" + database;
    private static String username = "postgres";
    private static String password = "postgres";

    private DatabaseConnectionSingletonNOTUSED() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        this.connection = DriverManager.getConnection(url, username, password);
    }

    public static DatabaseConnectionSingletonNOTUSED getInstance() throws SQLException, ClassNotFoundException {
        if (instance == null) {
            instance = new DatabaseConnectionSingletonNOTUSED();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnectionSingletonNOTUSED();
        }

        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

}
