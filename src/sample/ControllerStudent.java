package sample;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControllerStudent extends Click {
    static String SID, GID, Name, DOB, Sex, Father, Mother, Class, School, DOE, Height, Weight, BG, S, P;
    static Statement stmt;
    static ResultSet rs;
    @FXML
    public ImageView LoginID;
    public Label Attendance;
    public Label Details;
    public Label Books;
    public Label Work;
    public JFXTextField GF;
    public JFXTextField HF;
    public JFXTextField SF;
    public JFXTextField MF;
    public JFXTextField EF;
    public Label English;
    public Label Maths;
    public Label Science;
    public Label Hindi;
    public Label GK;

    public static void Student(String ID) {
        stmt = null;
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }
        String sql = "SELECT * FROM STUDENT WHERE SID = '" + ID + "';";
        System.out.println(sql);
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }
        try {
            if (!rs.next()) { System.out.println("No Record Found"); } else {
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

    public void Back(MouseEvent mouseEvent) throws IOException
    {
        Main.setRoot_Login();
    }

    public void Check_Attendance(MouseEvent mouseEvent) throws SQLException
    {
        stmt = null;
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }
        String sql = "SELECT COUNT(*) FROM Attendance WHERE SID = '" + SID + "';";
        System.out.println(sql);
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }
        rs.next();
        int n = Integer.parseInt(rs.getString("Count(*)"));
        int a = (n*100)/20;
        Attendance.setText(a+"%");
    }

    public void RetrieveAssignment(MouseEvent mouseEvent)
    {
        stmt = null;
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }
        String sql = "SELECT AssignmentID,Subject,Date,Info FROM Assignments WHERE CURDATE()<Date AND School = '" + School +"'AND Class = '"+Class+"';";
        System.out.println(sql);
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }
        try {
            String P = " ";
            if (!rs.next()) { Work.setText("No Assignments Due :)"); } else {
                do {
                    P = P + rs.getString("AssignmentID")+" ("+rs.getString("Subject")+") : "+rs.getString("Date")+"\n";
                } while (rs.next());
                Work.setText(P);
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void SubmitFB(MouseEvent mouseEvent)
    {
        boolean Flag = true;
        if (!((EF.getText().equals("1")) | (EF.getText().equals("2")) | (EF.getText().equals("3")) | (EF.getText().equals("4")) | (EF.getText().equals("5")))) { Flag = false;}
        if (!((HF.getText().equals("1")) | (HF.getText().equals("2")) | (HF.getText().equals("3")) | (HF.getText().equals("4")) | (HF.getText().equals("5")))) { Flag = false;}
        if (!((MF.getText().equals("1")) | (MF.getText().equals("2")) | (MF.getText().equals("3")) | (MF.getText().equals("4")) | (MF.getText().equals("5")))) { Flag = false;}
        if (!((GF.getText().equals("1")) | (GF.getText().equals("2")) | (GF.getText().equals("3")) | (GF.getText().equals("4")) | (GF.getText().equals("5")))) { Flag = false;}
        if (!((SF.getText().equals("1")) | (SF.getText().equals("2")) | (SF.getText().equals("3")) | (SF.getText().equals("4")) | (SF.getText().equals("5")))) { Flag = false;}
        if (Flag){
        stmt = null;
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }
        String sql = "";


        sql = "UPDATE Teacher SET Feedback = ((Feedback * 10)+"+EF.getText()+")/FBCount WHERE ( Class = '" + Class + "' AND School = '" + School + "' AND Subject = 'English' );";
        System.out.println(sql); try { if (stmt != null) { stmt.executeUpdate(sql); } } catch (SQLException e) { e.printStackTrace(); }
        sql = "UPDATE Teacher SET FBCount = FBCount + 1 WHERE ( Class = '" + Class + "' AND School = '" + School + "' AND Subject = 'English' );";
        System.out.println(sql); try { if (stmt != null) { stmt.executeUpdate(sql); } } catch (SQLException e) { e.printStackTrace(); }

        sql = "UPDATE Teacher SET Feedback = ((Feedback * 10)+"+HF.getText()+")/FBCount WHERE ( Class = '" + Class + "' AND School = '" + School + "' AND Subject = 'Hindi' );";
        System.out.println(sql); try { if (stmt != null) { stmt.executeUpdate(sql); } } catch (SQLException e) { e.printStackTrace(); }
        sql = "UPDATE Teacher SET FBCount = FBCount + 1 WHERE ( Class = '" + Class + "' AND School = '" + School + "' AND Subject = 'Hindi' );";
        System.out.println(sql); try { if (stmt != null) { stmt.executeUpdate(sql); } } catch (SQLException e) { e.printStackTrace(); }

        sql = "UPDATE Teacher SET Feedback = ((Feedback * 10)+"+GF.getText()+")/FBCount WHERE ( Class = '" + Class + "' AND School = '" + School + "' AND Subject = 'GK' );";
        System.out.println(sql); try { if (stmt != null) { stmt.executeUpdate(sql); } } catch (SQLException e) { e.printStackTrace(); }
        sql = "UPDATE Teacher SET FBCount = FBCount + 1 WHERE ( Class = '" + Class + "' AND School = '" + School + "' AND Subject = 'GK' );";
        System.out.println(sql); try { if (stmt != null) { stmt.executeUpdate(sql); } } catch (SQLException e) { e.printStackTrace(); }

        sql = "UPDATE Teacher SET Feedback = ((Feedback * 10)+"+MF.getText()+")/FBCount WHERE ( Class = '" + Class + "' AND School = '" + School + "' AND Subject = 'Maths' );";
        System.out.println(sql); try { if (stmt != null) {  stmt.executeUpdate(sql); } } catch (SQLException e) { e.printStackTrace(); }
        sql = "UPDATE Teacher SET FBCount = FBCount + 1 WHERE ( Class = '" + Class + "' AND School = '" + School + "' AND Subject = 'Maths' );";
        System.out.println(sql); try { if (stmt != null) { stmt.executeUpdate(sql); } } catch (SQLException e) { e.printStackTrace(); }

        sql = "UPDATE Teacher SET Feedback = ((Feedback * 10)+"+MF.getText()+")/FBCount WHERE ( Class = '" + Class + "' AND School = '" + School + "' AND Subject = 'Science' );";
        System.out.println(sql); try { if (stmt != null) {  stmt.executeUpdate(sql); } } catch (SQLException e) { e.printStackTrace(); }
        sql = "UPDATE Teacher SET FBCount = FBCount + 1 WHERE ( Class = '" + Class + "' AND School = '" + School + "' AND Subject = 'Science' );";
        System.out.println(sql); try { if (stmt != null) { stmt.executeUpdate(sql); } } catch (SQLException e) { e.printStackTrace(); }
    }}

    public void RetrieveMarks(MouseEvent mouseEvent)
    {
        stmt = null;
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }
        String sql = "SELECT Marks,Subject from Grades JOIN Exams E on Grades.EID = E.EID WHERE Grades.SID = '"+SID+"';";
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void RetrieveBooks(MouseEvent mouseEvent)
    {
        stmt = null;
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }
        String sql = "SELECT Book from Subject_Details where Class = '"+Class+"';";
        System.out.println(sql);
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }
        try {
            P = "";
            if (!rs.next()) { System.out.println("No Records Found"); } else {
                do {
                P = P + rs.getString("Book")+"\n";
                } while (rs.next());
                Books.setText(P);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Info(MouseEvent mouseEvent)
    {
        Details.setText(SID+"\n"+Name+"\nClass:"+Class+"\nSchool:"+School+"\n");
    }
}
