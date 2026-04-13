package model;

// User entity in recipes_db
public class User {
    /*
        Based on user relation on proposed DB design:
        id - int (PRIMARY KEY)
        username - VARCHAR(50)
        password_hash - VARCHAR(255)
    */
    private int id;
    private String username;
    private String passwordHash;

    public User(int id, String username, String passwordHash) {
        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
}