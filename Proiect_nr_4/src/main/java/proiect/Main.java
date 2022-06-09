package proiect;

import java.sql.SQLException;

public class Main {
    public static void main(String Args[]) throws SQLException {

        Database.createConnection();
        new MainFrame().setVisible(true);

    }
}
