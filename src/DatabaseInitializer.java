import java.sql.*;

public class DatabaseInitializer {

    public static void initTables(Connection conn) {

        createUsers(conn);
        createRecipes(conn);
    }

    private static void createUsers(Connection conn) {

        String sql = """
            CREATE TABLE IF NOT EXISTS users (
                id INT AUTO_INCREMENT PRIMARY KEY,
                username VARCHAR(50) UNIQUE NOT NULL,
                password VARCHAR(255) NOT NULL
            )
        """;

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Users table ready.");
        } catch (SQLException e) {
            System.out.println("User table error: " + e.getMessage());
        }
    }

    private static void createRecipes(Connection conn) {

        String sql = """
            CREATE TABLE IF NOT EXISTS recipes (
                id INT AUTO_INCREMENT PRIMARY KEY,
                user_id INT,
                title VARCHAR(100),
                ingredients TEXT,
                instructions TEXT,
                FOREIGN KEY (user_id) REFERENCES users(id)
            )
        """;

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Recipes table ready.");
        } catch (SQLException e) {
            System.out.println("Recipe table error: " + e.getMessage());
        }
    }
}