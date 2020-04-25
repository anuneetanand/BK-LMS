package sample;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControllerAdmin extends Click {
    static String AID, Name, School, Salary;
    static Statement stmt;
    static ResultSet rs;

    public static void Admin(String ID) {
        stmt = null;
        try {
            stmt = ConnectDB.DB.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "SELECT * FROM Administration WHERE AID = '" + ID + "';";
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
                    AID = rs.getString("AID");
                    Name = rs.getString("Name");
                    School = rs.getString("School");
                    Salary = rs.getString("Salary");
                    System.out.println(Name);
                } while (rs.next());
                Main.setRoot_Admin();
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
