package sample;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.Math.round;

public class ControllerGuardian
{
    static String GID, Name, Phone, Address, Account;
    static Statement stmt;
    static ResultSet rs;
    static String sql;

    @FXML
    public Label NameBox;
    public Label GIDBox;
    public Label English;
    public Label Maths;
    public Label Science;
    public Label Hindi;
    public Label GK;
    public Label Att;
    public Label SS;
    public Label Details;
    public Label SchoolRank;
    public Label OP;
    public Label Fee;
    public TextField Height;
    public TextField Weight;

    public static void Guardian(String ID)
    {
        stmt = null;
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }
        sql = "SELECT * FROM Guardian WHERE GID = '" + ID + "';";
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

    public void Info()
    { GIDBox.setText(GID);NameBox.setText(Name);Details.setText("Phone    : "+Phone+"\nAddress : "+Address+"\n\nAccount : "+Account); }
    
    public void GetAttendance() throws SQLException
    {
        stmt = null;
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }
        
        sql = "SELECT COUNT(*) FROM Attendance JOIN Student S on Attendance.SID = S.SID WHERE S.GID = '" + GID +"';";
        System.out.println(sql);
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }
        rs.next();
        int n = Integer.parseInt(rs.getString("Count(*)"));

        sql = "select COUNT(DISTINCT Date) from Attendance;";
        System.out.println(sql);
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }
        rs.next();
        int t = Integer.parseInt(rs.getString("Count(DISTINCT DATE)"));

        int a = (n*100)/t;
        Att.setText(String.valueOf(a));
    }

    public void GetSS() throws SQLException
    {
        stmt = null;
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }

        sql = "SELECT Scholarship FROM Student WHERE GID = '"+GID+"';";
        System.out.println(sql);
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }

        rs.next();
        SS.setText((rs.getString("Scholarship")));
    }

    public void UpdateDetails()
    {
        stmt = null;
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }

        sql = "UPDATE Student SET Height = '"+Height.getText()+"', Weight = '" + Weight.getText() + "' WHERE GID = '"+GID+"';";
        System.out.println(sql);
        try { if (stmt != null) { stmt.executeUpdate(sql); } } catch (SQLException e) { e.printStackTrace(); }
    }

    public void GetSR()
    {
        stmt = null;
        String P = "";
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }

        sql = " SELECT School, RANK() over (order by Performance) AS R from School;";
        System.out.println(sql);
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }

        try { if (!rs.next()) { System.out.println("No Record Found"); }
        else { do { P = P + rs.getString("School") + " :  " + rs.getString("R")+"\n"; } while (rs.next()); } }
        catch (SQLException e) { e.printStackTrace(); }
        SchoolRank.setText(P);
    }

    public void GetOP()
    {
        stmt = null;
        int x = 0;
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }

        sql = "SELECT Marks,Subject from Grades JOIN Exams E on Grades.EID = E.EID WHERE Grades.SID IN (SELECT SID FROM Student WHERE GID = '"+GID+"');";
        System.out.println(sql);
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }

        try {
            if (!rs.next()) {System.out.println("No Record Found"); }
            else { do { x = x + Integer.parseInt(rs.getString("Marks")); } while (rs.next()); }
        } catch (SQLException e) { e.printStackTrace(); }
        x = x / 5;
        x = round(x);
        OP.setText(String.valueOf(x));
    }

    public void GetFee()
    {
        stmt = null;
        String P = "";
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }

        sql = "SELECT Quarter,Status from Fee_Details where GID = '" + GID + "';";
        System.out.println(sql);
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }
        try {
            if (!rs.next()) {System.out.println("No Record Found"); }
            else { do { P = P + "Quarter "+rs.getString("Quarter")+": "+rs.getString("Status"); } while (rs.next()); }
        } catch (SQLException e) { e.printStackTrace(); }
        Fee.setText(P);
    }

    public void RetrieveMarks()
    {
        stmt = null;
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }

        sql = "SELECT Marks,Subject from Grades JOIN Exams E on Grades.EID = E.EID WHERE Grades.SID IN (SELECT SID FROM Student where GID = '"+GID+"');";
        System.out.println(sql);
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }

        try {
            if (!rs.next()) {System.out.println("No Record Found"); } else {
                do {
                    if (rs.getString("Subject").equals("English")){English.setText(rs.getString("Marks"));}
                    if (rs.getString("Subject").equals("Hindi")){Hindi.setText(rs.getString("Marks"));}
                    if (rs.getString("Subject").equals("Maths")){Maths.setText(rs.getString("Marks"));}
                    if (rs.getString("Subject").equals("Science")){Science.setText(rs.getString("Marks"));}
                    if (rs.getString("Subject").equals("GK")){GK.setText(rs.getString("Marks"));}
                } while (rs.next());
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void Back() throws IOException
    { Main.setRoot_Login(); }

    public void GoHome() throws IOException
    { Main.setRoot_Home(); }

    public void Refresh() throws SQLException
    { Info(); RetrieveMarks();GetOP();GetAttendance();GetSR();GetSS();GetFee();}
}
