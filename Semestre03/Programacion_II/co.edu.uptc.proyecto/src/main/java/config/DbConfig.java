package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// aqui se hace el cambio de mi base de datos en local a externo

public class DbConfig {
    private static final String URL = "jdbc:mysql://localhost:3306/hotel_db"; 
    private static final String USER = "root";
    private static final String PASS = "root";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
