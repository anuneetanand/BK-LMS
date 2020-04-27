package sample;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControllerGovt extends Click {
    static String GTID, Name, Department, Zone, Salary;
    static Statement stmt;
    static ResultSet rs;

    @FXML
    public Label Details;
    public JFXTextField SchoolName;
    public JFXTextField Score;
    public Label TR;
    public JFXTextField approveSID;
    public Label BMI;
    public Label AvgAttendance;
    public Label AvgMarks;

    public static void Govt(String ID) {
        stmt = null;
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }
        String sql = "SELECT * FROM Government_Officials WHERE ID = '" + ID + "';";
        System.out.println(sql);
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }
        try { if (!rs.next()) { System.out.println("No Record Found"); } else {
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
        } catch (SQLException | IOException e) { e.printStackTrace(); }
    }

    public void Back(MouseEvent mouseEvent) throws IOException
    { Main.setRoot_Login(); }

    public void UpdateScholarship(MouseEvent mouseEvent) throws SQLException
    {
        stmt = null;
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }
        String sql = "UPDATE Student SET Scholarship = '" + "YES" +"' WHERE SID = '"+approveSID.getText()+"';";
        System.out.println(sql);
        try { if (stmt != null) {stmt.executeUpdate(sql); } } catch (SQLException e) { e.printStackTrace(); }
    }

    public void GetSR(MouseEvent mouseEvent) throws SQLException
    {
        stmt = null;
        String P = "";
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }
        String sql = "SELECT School, AVG(Feedback) as A from Teacher group by School;";
        System.out.println(sql);
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }
        try { if (!rs.next()) { System.out.println("No Record Found"); }
        else { do { P = P + rs.getString("School") + ":" + rs.getString("A")+"\n"; } while (rs.next()); } }
        catch (SQLException e) { e.printStackTrace(); }
        TR.setText(P);
    }

    public void UpdateScore(MouseEvent mouseEvent) throws SQLException
    {
        stmt = null;
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }
        String sql = "UPDATE School SET Performance = '" + Score.getText() +"' WHERE School = '"+SchoolName+"';";
        System.out.println(sql);
        try { if (stmt != null) {stmt.executeUpdate(sql); } } catch (SQLException e) { e.printStackTrace(); }
    }

    public void BMI(MouseEvent mouseEvent) throws SQLException
    {
        stmt = null;
        String P = "";
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }
        String sql = "SELECT School, Class, ROUND(AVG(Weight*10000/(Height*Height)),2) AS BMI FROM Student group by Class,School;";
        System.out.println(sql);
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }
        try { if (!rs.next()) { System.out.println("No Record Found"); }
        else { do { P = P + rs.getString("School") + ":" +rs.getString("Class") +":" + rs.getString("BMI")+"\n"; } while (rs.next()); } }
        catch (SQLException e) { e.printStackTrace(); }
        BMI.setText(P);
    }

    public void AM(MouseEvent mouseEvent) throws SQLException
    {
        stmt = null;
        String P = "";
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }
        String sql = "SELECT School,Class,AVG(Marks) as x from Grades JOIN Student S on Grades.SID = S.SID group by Class, School;";
        System.out.println(sql);
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }
        try { if (!rs.next()) { System.out.println("No Record Found"); }
        else { do { P = P + rs.getString("School") + ":" +rs.getString("Class") +":"+ rs.getString("x")+"\n"; } while (rs.next()); } }
        catch (SQLException e) { e.printStackTrace(); }
        AvgMarks.setText(P);
    }

    public void AA(MouseEvent mouseEvent) throws SQLException
    {
        stmt = null;
        String P = "";
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }
        String sql = "SELECT School,Class,AVG(A) as x from (SELECT COUNT(Student.SID) AS A,Student.SID,Class,School from Student JOIN Attendance A on Student.SID = A.SID group by Student.SID) as SA group by Class,School;";
        System.out.println(sql);
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }
        try { if (!rs.next()) { System.out.println("No Record Found"); }
        else { do { P = P + rs.getString("School") + ":" +rs.getString("Class") +":"+ rs.getString("x")+"\n"; } while (rs.next()); } }
        catch (SQLException e) { e.printStackTrace(); }
        AvgAttendance.setText(P);
    }

    public void Info(MouseEvent mouseEvent)
    { Details.setText(GTID+"\n"+Name+"\n"+Department+"\n"+Zone); }
}
