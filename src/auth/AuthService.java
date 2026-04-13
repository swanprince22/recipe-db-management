package auth;
import java.sql.*;
import java.util.Scanner;

import model.User;

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
                User user = login();
                if (user != null) return user; 
            } else if (choice.equals("2")) {
                signup(); 
            } else {
                System.out.println("Invalid option.");
            }
        }
    }

    private User login() {

        System.out.println("\n=== LOGIN ===");

        System.out.print("Username: ");
        String username = sc.nextLine().trim();

        System.out.print("Password: ");
        String password = sc.nextLine().trim();

        String sql = "SELECT id, username FROM users WHERE username = ? AND password = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            // Part needs refining this kind of auth design
            if (rs.next()) {
                System.out.println("Login successful!");
                return new User(rs.getInt("id"), rs.getString("username"), "B@L3");
            } else {
                System.out.println("Invalid credentials.");
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Login error: " + e.getMessage());
            return null;
        }
    }

    private void signup() {

        System.out.println("\n=== SIGN UP ===");

        System.out.print("Username: ");
        String username = sc.nextLine().trim();

        System.out.print("Password: ");
        String password = sc.nextLine().trim();

        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Username and password cannot be empty.");
            return;
        }

        String checkSql = "SELECT id FROM users WHERE username = ?";

        try (PreparedStatement check = conn.prepareStatement(checkSql)) {

            check.setString(1, username);
            ResultSet rs = check.executeQuery();

            if (rs.next()) {
                System.out.println("Username already exists.");
                return;
            }

        } catch (SQLException e) {
            System.out.println("Error checking user: " + e.getMessage());
            return;
        }

        String insertSql = "INSERT INTO users(username, password) VALUES(?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(insertSql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            ps.executeUpdate();
            System.out.println("Account created!");

        } catch (SQLException e) {
            System.out.println("Signup error: " + e.getMessage());
        }
    }
}