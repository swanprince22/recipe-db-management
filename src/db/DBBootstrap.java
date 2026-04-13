package db;
import java.sql.*;

public class DBBootstrap {
    public static void initDatabase() {
        try (Connection conn = DriverManager.getConnection(DBConfig.getBootstrapURL(), 
                                                           DBConfig.getUser(), 
                                                           DBConfig.getPassword());
             Statement stmt = conn.createStatement()) {
            
                stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS recipes_db");
                stmt.executeUpdate("USE recipes_db");
                
                /*
                // Create tables template
                stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS users (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "username VARCHAR(50) UNIQUE NOT NULL, " +
                    "password VARCHAR(255) NOT NULL, " +
                    "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                    ")"
                );
                
                // Add more CREATE TABLE statements here
                 */
                
            System.out.println("Database and tables initialized.");

        } catch (SQLException e) {
            System.out.println("DB Bootstrap error: " + e.getMessage());
            System.exit(1);
        }
    }
}