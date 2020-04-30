package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.Math.round;

public class ControllerTeacher
{
    static String TID, Name, DOB, Sex, Phone, Subject, Qualification, YOS, School, Feedback, Salary, Class;
    static Statement stmt;
    static ResultSet rs;
    static String sql;

    @FXML
    public Label NameBox;
    public Label TIDBox;
    public Label Details;
    public Label FeedbackData;
    public Label MinMarks;
    public Label AvgMarks;
    public Label MaxMarks;
    public Label Submissions;
    public Label WeakList;
    public TextField AD;
    public TextField AI;

    public static void Teacher(String ID) {
        stmt = null;
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }
        sql = "SELECT * FROM Teacher WHERE TID = '" + ID + "';";
        System.out.println(sql);
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }
        try {
            if (!rs.next()) { System.out.println("No Record Found"); } else {
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
                } while (rs.next());
                Main.setRoot_Teacher();
            }
        } catch (SQLException | IOException e) { e.printStackTrace(); }
    }

    public void Info()
    {
        NameBox.setText(Name);
        TIDBox.setText(TID);
        Details.setText("Subject : "+Subject+"\nSchool  : "+School);
    }

    public void RetrieveFB() throws SQLException
    {
        stmt = null;
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }

        sql = "SELECT Feedback,FBCount FROM Teacher WHERE TID = '" + TID + "';";
        System.out.println(sql);
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }

        rs.next();
        double F = Double.parseDouble(rs.getString("Feedback"));
        int n = Integer.parseInt(rs.getString("FBCount"));
        FeedbackData.setText("      "+F+"\n("+n+" Entries)");
    }

    public void AnalyseMarks() throws SQLException
    {
        stmt = null;
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }

        sql = "select AVG(Marks), MAX(Marks),MIN(Marks) from Grades JOIN Exams E on Grades.EID = E.EID WHERE E.Class = '"+Class+"' AND E.Subject = '"+Subject+"' AND Grades.SID in ( SELECT SID FROM Student where School = '"+School+"');";
        System.out.println(sql);
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }

        rs.next();
        Double x = Double.parseDouble(rs.getString("AVG(Marks)"));
        AvgMarks.setText(String.valueOf(round(x)));
        MaxMarks.setText(rs.getString("Max(Marks)"));
        MinMarks.setText(rs.getString("Min(Marks)"));
    }

    public void CheckSubmissions() throws SQLException
    {
        stmt = null;
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }
        
        sql = "SELECT S.AssignmentID,COUNT(*) from Assignments JOIN Submissions S on Assignments.AssignmentID = S.AssignmentID where TID = '"+TID+"' group by S.AssignmentID;";
        System.out.println(sql);
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }

        String P = "";
        if (!rs.next()) { System.out.println("No Record Found"); P = "None"; }
        else { do { P = P + rs.getString("AssignmentID")+": "+rs.getString("COUNT(*)")+"\n"; } while (rs.next());}
        Submissions.setText(P);
    }

    public void List() throws SQLException
    {
        stmt = null;
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }
        
        sql = "SELECT Name FROM Student JOIN Grades G on Student.SID = G.SID WHERE G.Marks<30 AND Student.Class = '"+Class+"' " + "AND Student.School = '"+ School + "'AND G.EID LIKE 'EXAM000"+Subject.substring(0,1)+"%' ;";
        System.out.println(sql);
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }
        
        String P = "";
        if (!rs.next()) { System.out.println("No Record Found"); P = "None";}
        else { do { P = P + rs.getString("Name")+"\n"; } while (rs.next());}
        WeakList.setText(P);
    }

    public void Add() throws SQLException
    {
        stmt = null;
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }

        sql = "SELECT NumberOfAssignments FROM SubjectInfo WHERE Class = '" + Class + "' AND School = '" + School + "'AND Name = '" + Subject + "';";
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }

        rs.next();
        int n = Integer.parseInt(rs.getString("NumberOfAssignments"));
        n++;

        sql = "UPDATE SubjectInfo SET NumberOfAssignments = NumberOfAssignments + 1 WHERE Class = '" + Class + "' AND School = '" + School + "'AND Name = '" + Subject + "';";
        try { if (stmt != null) { stmt.executeUpdate(sql); } } catch (SQLException e) { e.printStackTrace(); }

        String x = "ASSIG" + n + "0" + Subject.substring(0, 1) + (Integer.parseInt(Class) + 10);

        PreparedStatement stm = ConnectDB.DB.prepareStatement("INSERT INTO Assignments values(?,?,?,?,?,?,?)");
        stm.setString(1, x);
        stm.setString(2, TID);
        stm.setString(3, Class);
        stm.setString(4, Subject);
        stm.setString(5, School);
        stm.setString(6, AD.getText());
        stm.setString(7, AI.getText());
        stm.executeUpdate();
    }

    public void Back() throws IOException
    { Main.setRoot_Login(); }

    public void GoHome() throws IOException
    { Main.setRoot_Home(); }

    public void Error() throws IOException
    { Main.setRoot_Error(); }
    
    public void Refresh() throws SQLException
    { Info();RetrieveFB();CheckSubmissions();AnalyseMarks();List(); }
}
