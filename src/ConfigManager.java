import java.sql.*;

public class ConfigManager {

   private static final String URL =
    "jdbc:mysql://127.0.0.1:3306/recipes_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    private static final String USER = "root";
    private static final String PASS = ""; //add password

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(URL, USER, PASS);
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