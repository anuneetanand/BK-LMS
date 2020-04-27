package sample;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControllerAdmin extends Click {
    static String AID, Name, School, Salary;
    static Statement stmt;
    static ResultSet rs;

    @FXML
    public Label Details;
    public Label FeeDue;
    public JFXTextField UpdateStudentFee;
    public Label SchoolRank;

    public JFXTextField SName;
    public JFXTextField DOB;
    public JFXTextField Sex;
    public JFXTextField F;
    public JFXTextField M;
    public JFXTextField Class;
    public JFXTextField Phone;
    public JFXTextField Address;
    public JFXTextField Account;

    public JFXTextField TName;
    public JFXTextField TDOB;
    public JFXTextField TSex;
    public JFXTextField Tphone;
    public JFXTextField Subject;
    public JFXTextField Qualification;
    public JFXTextField YOS;
    public JFXTextField TClass;

    public static void Admin(String ID) {
        stmt = null;
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }
        String sql = "SELECT * FROM Administration WHERE AID = '" + ID + "';";
        System.out.println(sql);
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }
        try { if (!rs.next()) { System.out.println("No Record Found"); } else {
                do {
                    AID = rs.getString("AID");
                    Name = rs.getString("Name");
                    School = rs.getString("School");
                    Salary = rs.getString("Salary");
                    System.out.println(Name);
                } while (rs.next());
                Main.setRoot_Admin();
            }
        } catch (SQLException | IOException e) { e.printStackTrace(); }
    }

    public void Back(MouseEvent mouseEvent) throws IOException
    { Main.setRoot_Login(); }

    public void enrollTeacher(MouseEvent mouseEvent) throws SQLException
    {
        stmt = null;
        int n = 0;
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }
        String sql = "SELECT COUNT(*) FROM Teacher;";
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }
        if (!rs.next()) { System.out.println("No Record Found"); }
        else { do { n = Integer.parseInt(rs.getString("COUNT(*)")); } while (rs.next());}
        n++;
        PreparedStatement stm = ConnectDB.DB.prepareStatement("INSERT INTO Teacher values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
        stm.setString(1,"TID0000"+n);
        stm.setString(2,TName.getText());
        stm.setString(3,TDOB.getText());
        stm.setString(4,TSex.getText());
        stm.setString(5,Tphone.getText());
        stm.setString(6,Subject.getText());
        stm.setString(7,Qualification.getText());
        stm.setString(8,YOS.getText());
        stm.setString(9,School);
        stm.setString(10,"5.00");
        stm.setString(11,"25000");
        stm.setString(12,TClass.getText());
        stm.setString(13,"0");
        stm.executeUpdate();
    }

    public void enrollStudent(MouseEvent mouseEvent) throws SQLException
    {
        stmt = null;
        int n = 0;
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }
        String sql = "SELECT COUNT(*) FROM Student;";
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }
        if (!rs.next()) { System.out.println("No Record Found"); }
        else { do { n = Integer.parseInt(rs.getString("COUNT(*)")); } while (rs.next());}
        n++;
        PreparedStatement stm1 = ConnectDB.DB.prepareStatement("INSERT INTO Guardian values(?,?,?,?,?)");
        stm1.setString(1,"GID0000"+n);
        stm1.setString(2,F.getText());
        stm1.setString(3,Phone.getText());
        stm1.setString(4,Address.getText());
        stm1.setString(5,Account.getText());
        stm1.executeUpdate();
        PreparedStatement stm = ConnectDB.DB.prepareStatement("INSERT INTO Student values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        stm.setString(1,"SID0000"+n);
        stm.setString(2,SName.getText());
        stm.setString(3,DOB.getText());
        stm.setString(4,Sex.getText());
        stm.setString(5,F.getText());
        stm.setString(6,M.getText());
        stm.setString(7,Class.getText());
        stm.setString(8,School);
        stm.setString(9,"2020-04-30");
        stm.setString(10,"0");
        stm.setString(11,"0");
        stm.setString(12,"-");
        stm.setString(13,"100");
        stm.executeUpdate();
    }

    public void ChkFee(MouseEvent mouseEvent) throws SQLException
    {
        stmt = null;
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }
        String sql = "SELECT S.SID from Fee_Details JOIN Student S on Fee_Details.SID = S.SID WHERE School = '" + School +"' AND Status = 'Due';";
        System.out.println(sql);
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }
        String P = "";
        if (!rs.next()) { System.out.println("No Record Found"); }
        else { do { P = P + rs.getString("SID")+", "; } while (rs.next());}
        FeeDue.setText(P);
    }

    public void UpdateFee(MouseEvent mouseEvent) throws SQLException
    {
        stmt = null;
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }
        String sql = "UPDATE Fee_Details SET Status = 'Paid' WHERE SID = '" + UpdateStudentFee.getText() + "';";
        System.out.println(sql);
        try { if (stmt != null) {stmt.executeUpdate(sql); } } catch (SQLException e) { e.printStackTrace(); }
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

    public void Info(MouseEvent mouseEvent)
    { Details.setText(AID+"\n"+Name+"\n"+School);}

}
