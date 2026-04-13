import java.sql.Connection;

import db.DBConnection;
import db.DBBootstrap;

public class Main {

    public static void main(String[] args) {

        DBBootstrap.initDatabase();

        Connection conn = DBConnection.getConnection();

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