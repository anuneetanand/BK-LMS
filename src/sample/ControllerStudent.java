package sample;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControllerStudent extends Click {
    static String SID, GID, Name, DOB, Sex, Father, Mother, Class, School, DOE, Height, Weight, BG, S, P;
    static Statement stmt;
    static ResultSet rs;

    public static void Student(String ID) {
        stmt = null;
        try {
            stmt = ConnectDB.DB.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "SELECT * FROM STUDENT WHERE SID = '" + ID + "';";
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
                    SID = rs.getString("SID");
                    GID = rs.getString("GID");
                    Name = rs.getString("Name");
                    DOB = rs.getString("DOB");
                    Sex = rs.getString("Sex");
                    Father = rs.getString("Father");
                    Mother = rs.getString("Mother");
                    Class = rs.getString("Class");
                    School = rs.getString("School");
                    DOE = rs.getString("DOE");
                    Height = rs.getString("Height");
                    Weight = rs.getString("Weight");
                    BG = rs.getString("BloodGroup");
                    S = rs.getString("Scholarship");
                    P = rs.getString("Performance");
                    System.out.println(Name);
                } while (rs.next());
                Main.setRoot_Student();
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

    }
}
