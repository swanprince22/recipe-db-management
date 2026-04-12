import java.sql.*;
import java.util.Scanner;

public class AuthService {

    private Connection conn;
    private Scanner sc = new Scanner(System.in);

    public AuthService(Connection conn) {
        this.conn = conn;
    }

    public User start() {

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Login");
            System.out.println("2. Sign Up");
            System.out.print("Choice: ");

            String choice = sc.nextLine();

            if (choice.equals("1")) {
                return login();
            } else if (choice.equals("2")) {
                signup();
            } else {
                System.out.println("Invalid option.");
            }
        }
    }

    private User login() {

        System.out.println("\n=== LOGIN ===");

        for (int i = 1; i <= 3; i++) {

            System.out.print("Username: ");
            String u = sc.nextLine();

            System.out.print("Password: ");
            String p = sc.nextLine();

            User user = authenticate(u, p);

            if (user != null) {
                System.out.println("Login successful!");
                return user;
            }

            System.out.println("Failed attempt " + i + "/3");
        }

        System.out.println("Too many attempts.");
        System.exit(0);
        return null;
    }

    private User authenticate(String u, String p) {

        String sql = "SELECT id, username FROM users WHERE username=? AND password=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, u);
            ps.setString(2, p);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new User(rs.getInt("id"), rs.getString("username"));
            }

        } catch (SQLException e) {
            System.out.println("Login error: " + e.getMessage());
        }

        return null;
    }

    private void signup() {

        System.out.println("\n=== SIGN UP ===");

        System.out.print("Username: ");
        String u = sc.nextLine();

        System.out.print("Password: ");
        String p = sc.nextLine();

        String sql = "INSERT INTO users(username, password) VALUES(?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, u);
            ps.setString(2, p);

            ps.executeUpdate();
            System.out.println("Account created!");

        } catch (SQLException e) {
            System.out.println("Signup error: " + e.getMessage());
        }
    }
}