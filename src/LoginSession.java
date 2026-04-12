import java.sql.*;
import java.util.Scanner;

public class LoginSession {

    private Connection conn;
    private static final int MAX_ATTEMPTS = 3;

    public LoginSession(Connection conn) {
        this.conn = conn;
    }

    public User login() {

        System.out.println(">>> LOGINSESSION ACTIVE VERSION <<<");

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== LOGIN REQUIRED ===");

        int attempts = 0;

        while (attempts < MAX_ATTEMPTS) {

            System.out.print("Username: ");
            String username = scanner.nextLine();

            // 1. CHECK IF USER EXISTS FIRST
            User existingUser = getUserByUsername(username);

            if (existingUser == null) {
                System.out.println("User does not exist.");
                continue; // no penalty (or you can count it if you want)
            }

            // 2. PASSWORD CHECK LOOP
            System.out.print("Password: ");
            String password = scanner.nextLine();

            if (authenticate(username, password)) {
                System.out.println("Login successful!\n");
                return existingUser;
            }

            attempts++;
            System.out.println("Wrong password (" + attempts + "/" + MAX_ATTEMPTS + ")");
        }

        System.out.println("Too many failed attempts. Exiting...");
        System.exit(0);
        return null;
    }

    // CHECK USERNAME ONLY
    private User getUserByUsername(String username) {

        String sql = "SELECT id, username FROM users WHERE username = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new User(rs.getInt("id"), rs.getString("username"));
            }

        } catch (SQLException e) {
            System.out.println("Error checking user: " + e.getMessage());
        }

        return null;
    }

    // CHECK PASSWORD ONLY
    private boolean authenticate(String username, String password) {

        String sql = "SELECT id FROM users WHERE username = ? AND password = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            System.out.println("Login error: " + e.getMessage());
        }

        return false;
    }
}