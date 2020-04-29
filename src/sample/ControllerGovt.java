package sample;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ControllerGovt
{
    static String GTID, Name, Department, Zone, Salary;
    static Statement stmt;
    static ResultSet rs;
    static String sql;

    @FXML
    public TextField NoticeInfo;
    public TextField Audience;
    public TextField SchoolName;
    public TextField Score;
    public TextField approveSID;
    public Label IDBox;
    public Label NameBox;
    public Label Details;
    public Label TopTeachers;
    public Label Stats;

    public static void Govt(String ID)
    {
        stmt = null;
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }
        sql = "SELECT * FROM Government_Officials WHERE ID = '" + ID + "';";
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

    public void Info()
    { IDBox.setText(GTID);NameBox.setText(Name);Details.setText("Zone             : "+Zone+"\nDepartment : "+Department); }

    public void UpdateScholarship()
    {
        stmt = null;
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }
        sql = "UPDATE Student SET Scholarship = '" + "YES" +"' WHERE SID = '"+approveSID.getText()+"';";
        System.out.println(sql);
        try { if (stmt != null) {stmt.executeUpdate(sql); } } catch (SQLException e) { e.printStackTrace(); }
    }

    public void UpdateScore()
    {
        stmt = null;
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }

        sql = "UPDATE School SET Performance = '" + Score.getText() +"' WHERE School = '"+SchoolName.getText()+"';";
        System.out.println(sql);
        try { if (stmt != null) {stmt.executeUpdate(sql); } } catch (SQLException e) { e.printStackTrace(); }
    }

    public void ChkStats()throws SQLException
    {
        stmt = null;
        String P = "";
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }

        sql = "SELECT COUNT(*) FROM School";
        System.out.println(sql);
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }

        rs.next();
        P = P + rs.getString("COUNT(*)") +" Schools\n";

        sql = "SELECT COUNT(*) FROM Student";
        System.out.println(sql);
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }

        rs.next();
        P = P + rs.getString("COUNT(*)") +" Students\n";

        sql = "SELECT COUNT(*) FROM Teacher";
        System.out.println(sql);
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }

        rs.next();
        P = P + rs.getString("COUNT(*)") +" Teachers";

        Stats.setText(P);
    }

    public void ChkTeachers()
    {
        stmt = null;
        String P = "Best Teachers\n\n";
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }

        sql = "select Name from Teacher where Feedback = 5;";
        System.out.println(sql);
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }

        try
        { if (!rs.next()) { System.out.println("No Record Found");P = "None"; }
        else { do { P = P + rs.getString("Name") + "\n"; } while (rs.next()); }
        } catch (SQLException e) { e.printStackTrace(); }
        TopTeachers.setText(P);
    }

    public void Issue() throws SQLException
    {
        stmt = null;
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }

        sql = "SELECT COUNT(*) FROM Notice;";
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }

        rs.next();
        int n = Integer.parseInt(rs.getString("COUNT(*)"));
        n++;

        sql = "SELECT CURDATE();";
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }

        rs.next();
        String d = rs.getString("CURDATE()");

        String x = "NOTICE000" + n;

        PreparedStatement stm = ConnectDB.DB.prepareStatement("INSERT INTO Notice values(?,?,?,?,?,?,?)");
        stm.setString(1, x);
        stm.setString(2, GTID);
        stm.setString(3, d);
        stm.setString(4, Zone);
        stm.setString(5, "Notice");
        stm.setString(6, Audience.getText());
        stm.setString(7, NoticeInfo.getText());
        stm.executeUpdate();
    }

    public void X() throws IOException
    { Main.setRoot_X(); }

    public void Back() throws IOException
    { Main.setRoot_Login(); }

    public void GoHome() throws IOException
    { Main.setRoot_Home(); }

    public void Refresh() throws SQLException
    { Info(); ChkStats(); ChkTeachers(); }

}
