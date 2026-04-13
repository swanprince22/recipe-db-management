package db;
import java.sql.*;

public class DBConnection {

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(DBConfig.getAppURL(), 
                                                          DBConfig.getUser(), 
                                                          DBConfig.getPassword());
            System.out.println("Database connected successfully.");
            return conn;

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not found.");
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }

        return null;
    }
}