package sample;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControllerTeacher extends Click {
    static String TID, Name, DOB, Sex, Phone, Subject, Qualification, YOS, School, Feedback, Salary, Class;
    static Statement stmt;
    static ResultSet rs;

    public static void Teacher(String ID) {
        stmt = null;
        try {
            stmt = ConnectDB.DB.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "SELECT * FROM Teacher WHERE TID = '" + ID + "';";
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
                    TID = rs.getString("TID");
                    Name = rs.getString("Name");
                    DOB = rs.getString("DOB");
                    Sex = rs.getString("Sex");
                    Phone = rs.getString("Phone");
                    Subject = rs.getString("Subject");
                    Qualification = rs.getString("Qualification");
                    YOS = rs.getString("YearsOfService");
                    School = rs.getString("School");
                    Feedback = rs.getString("Feedback");
                    Salary = rs.getString("Salary");
                    Class = rs.getString("Class");
                    System.out.println(Name);
                } while (rs.next());
                Main.setRoot_Teacher();
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
