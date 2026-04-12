import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        DatabaseBootstrap.initDatabase();

        Connection conn = ConfigManager.getConnection();

        if (conn == null) {
            System.out.println("Cannot start app.");
            return;
        }

        DatabaseInitializer.initTables(conn);

        AuthService auth = new AuthService(conn);
        User user = auth.start();

        Session.setUser(user);

        System.out.println("\nWelcome " + Session.getUser().getUsername());
    }
}