package sample;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControllerGuardian extends Click {
    static String GID, Name, Phone, Address, Account;
    static Statement stmt;
    static ResultSet rs;

    public static void Guardian(String ID) {
        stmt = null;
        try {
            stmt = ConnectDB.DB.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "SELECT * FROM Guardian WHERE GID = '" + ID + "';";
        System.out.println(sql);
        try {
            if (stmt != null) {
                rs = stmt.executeQuery(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (!rs.next()) {
                System.out.println("No Record Found");
            } else {
                do {
                    GID = rs.getString("GID");
                    Name = rs.getString("Name");
                    Phone = rs.getString("Phone");
                    Address = rs.getString("Address");
                    Account = rs.getString("Account");
                    System.out.println(Name);
                } while (rs.next());
                Main.setRoot_Guardian();
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
