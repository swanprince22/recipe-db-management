import java.sql.*;

public class DatabaseBootstrap {

    private static final String URL =
    "jdbc:mysql://127.0.0.1:3306/?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    
    private static final String USER = "root";
    private static final String PASS = "P@ssw0rd1";

    public static void initDatabase() {

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS recipes_db");

            System.out.println("Database checked/created.");

        } catch (SQLException e) {
            System.out.println("DB Bootstrap error: " + e.getMessage());
            System.exit(1);
        }
    }
}