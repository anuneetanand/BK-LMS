package sample;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControllerGuardian extends Click {
    static String GID, Name, Phone, Address, Account;
    static Statement stmt;
    static ResultSet rs;

    @FXML
    public Label Att;
    public Label SS;
    public Label Details;
    public JFXTextField Height;
    public JFXTextField Weight;
    public Label SchoolRank;
    public Label OP;
    public Label Fee;

    public static void Guardian(String ID) {
        stmt = null;
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }
        String sql = "SELECT * FROM Guardian WHERE GID = '" + ID + "';";
        System.out.println(sql);
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }
        try { if (!rs.next()) { System.out.println("No Record Found"); } else {
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
        } catch (SQLException | IOException e) { e.printStackTrace(); }
    }

    public void Back(MouseEvent mouseEvent) throws IOException
    { Main.setRoot_Login(); }

    public void GetAttendance(MouseEvent mouseEvent) throws SQLException
    {
        stmt = null;
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }
        String sql = "SELECT COUNT(*) FROM Attendance JOIN Student S on Attendance.SID = S.SID WHERE S.GID = '" + GID +"';";
        System.out.println(sql);
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }
        rs.next();
        int n = Integer.parseInt(rs.getString("Count(*)"));
        int a = (n*100)/20;
        Att.setText(a+"%");
    }

    public void GetSS(MouseEvent mouseEvent) throws SQLException
    {
        stmt = null;
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }
        String sql = "SELECT Scholarship FROM Student WHERE GID = '"+GID+"';";
        System.out.println(sql);
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }
        rs.next();
        SS.setText((rs.getString("Scholarship")));
    }

    public void UpdateDetails(MouseEvent mouseEvent) throws SQLException
    {
        stmt = null;
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }
        String sql = "UPDATE Student SET Height = '"+Height.getText()+"' AND Weight = '" + Weight.getText() + "' WHERE GID = '"+GID+"';";
        System.out.println(sql);
        try { if (stmt != null) { stmt.executeUpdate(sql); } } catch (SQLException e) { e.printStackTrace(); }
    }

    public void GetSR(MouseEvent mouseEvent) throws SQLException
    {
        stmt = null;
        String P = "";
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }
        String sql = " SELECT School, RANK() over (order by Performance) AS R from School;";
        System.out.println(sql);
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }
        try { if (!rs.next()) { System.out.println("No Record Found"); }
        else { do { P = P + rs.getString("School") + ":" + rs.getString("R")+"\n"; } while (rs.next()); } }
        catch (SQLException e) { e.printStackTrace(); }
        SchoolRank.setText(P);
    }

    public void GetOP(MouseEvent mouseEvent) throws SQLException
    {
        stmt = null;
        int x = 0;
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }
        String sql = "SELECT Marks,Subject from Grades JOIN Exams E on Grades.EID = E.EID WHERE Grades.SID IN (SELECT SID FROM Student WHERE GID = '"+GID+"');";
        System.out.println(sql);
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }
        try {
            if (!rs.next()) {System.out.println("No Record Found"); } else {
                do { x = x + Integer.parseInt(rs.getString("Marks")); } while (rs.next());
            }
        } catch (SQLException e) { e.printStackTrace(); }
        x = x / 5;
        OP.setText(x+"%");
    }

    public void GetFee(MouseEvent mouseEvent) throws SQLException
    {
        stmt = null;
        String P = "";
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }
        String sql = "SELECT Quarter,Status from Fee_Details where GID = '" + GID + "';";
        System.out.println(sql);
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }
        try {
            if (!rs.next()) {System.out.println("No Record Found"); } else
                { do { P = P + rs.getString("Quarter")+": "+rs.getString("Status"); } while (rs.next()); }
        } catch (SQLException e) { e.printStackTrace(); }
        Fee.setText(P);
    }

    public void Info(MouseEvent mouseEvent)
    { Details.setText(GID+"\n"+Name+"\n"+ Phone); }
}
