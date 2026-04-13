package db;
import java.sql.*;

public class DBBootstrap {
    public static void initDatabase() {
        try (Connection conn = DriverManager.getConnection(DBConfig.getBootstrapURL(), 
                                                           DBConfig.getUser(), 
                                                           DBConfig.getPassword());
             Statement stmt = conn.createStatement()) {
            
                stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS recipes_db");
                
            System.out.println("Database checked/created.");

        } catch (SQLException e) {
            System.out.println("DB Bootstrap error: " + e.getMessage());
            System.exit(1);
        }
    }
}