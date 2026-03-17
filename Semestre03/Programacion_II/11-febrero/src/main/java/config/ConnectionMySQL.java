package config;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
public class ConnectionMySQL {
    private static final String URL ="jdbc:mysql://localhost:3306/programacion2";
    
    private static final String USER = "root";

    private static final String PASSWORD = "root";

    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}