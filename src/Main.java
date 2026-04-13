import java.sql.Connection;

import auth.AuthService;
import auth.Session;
import db.DBConnection;
import db.DBInit;
import model.User;
import db.DBBootstrap;

/* App? entry point? */
public class Main {

    public static void main(String[] args) {

        DBBootstrap.initDatabase();

        Connection conn = DBConnection.getConnection();

        if (conn == null) {
            System.out.println("Cannot start app.");
            return;
        }

        DBInit.initTables(conn);

        AuthService auth = new AuthService(conn);
        User user = auth.start();

        Session.setUser(user);

        System.out.println("\nWelcome " + Session.getUser().getUsername());
    }
}