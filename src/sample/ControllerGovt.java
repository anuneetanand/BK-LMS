package sample;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControllerGovt extends Click {
    static String GTID, Name, Department, Zone, Salary;
    static Statement stmt;
    static ResultSet rs;

    public static void Govt(String ID) {
        stmt = null;
        try {
            stmt = ConnectDB.DB.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "SELECT * FROM Government_Officials WHERE ID = '" + ID + "';";
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
                    GTID = rs.getString("ID");
                    Name = rs.getString("Name");
                    Department = rs.getString("Department");
                    Zone = rs.getString("Zone");
                    Salary = rs.getString("Salary");
                    System.out.println(Name);
                } while (rs.next());
                Main.setRoot_Govt();
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
