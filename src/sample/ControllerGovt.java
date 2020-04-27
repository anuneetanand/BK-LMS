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

    public void Info(MouseEvent mouseEvent)
    { Details.setText(GTID+"\n"+Name+"\n"+Department+"\n"+Zone); }
}
