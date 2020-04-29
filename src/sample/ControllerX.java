package sample;

import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.Math.*;

public class ControllerX
{
    static Statement stmt;
    static ResultSet rs;
    static String sql;
    @FXML
    public TextField AnalyseClass;
    public LineChart BMIChart;
    public CategoryAxis BMIx;
    public NumberAxis BMIy;
    public LineChart AAChart;
    public CategoryAxis AAx;
    public NumberAxis AAy;
    public LineChart MarksChart;
    public CategoryAxis Marksx;
    public NumberAxis Marksy;
    public LineChart FBChart;
    public CategoryAxis FBx;
    public NumberAxis FBy;
    public Label Score;
    public TextField A;
    public TextField M;
    public TextField B;
    public TextField Fb;


    public void BMI()
    {
        stmt = null;
        XYChart.Series S = new XYChart.Series();
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }

        sql = "SELECT School,ROUND(AVG(Weight*10000/(Height*Height)),2) AS x FROM Student where Class = '"+AnalyseClass.getText()+"'group by School;";
        System.out.println(sql);
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }

        try { if (!rs.next()) { System.out.println("No Record Found"); }
        else { do { S.getData().add(new XYChart.Data(rs.getString("School").substring(4),Double.parseDouble(rs.getString("x")))); } while (rs.next()); } }
        catch (SQLException e) { e.printStackTrace(); }
        S.setName(AnalyseClass.getText());
        BMIChart.getData().addAll(S);
    }

    public void AM()
    {
        stmt = null;
        XYChart.Series S = new XYChart.Series();
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }

        sql = "SELECT School,AVG(Marks) as x from Grades JOIN Student S on Grades.SID = S.SID where Class = '"+AnalyseClass.getText()+" 'group by School;";
        System.out.println(sql);
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }

        try { if (!rs.next()) { System.out.println("No Record Found"); }
        else { do {  S.getData().add(new XYChart.Data(rs.getString("School").substring(4),Double.parseDouble(rs.getString("x")))); } while (rs.next()); } }
        catch (SQLException e) { e.printStackTrace(); }
        S.setName(AnalyseClass.getText());
        MarksChart.getData().addAll(S);
    }

    public void AA()
    {
        stmt = null;
        XYChart.Series S = new XYChart.Series();
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }

        sql = "SELECT School,AVG(A)*5 as x from (SELECT COUNT(Student.SID) AS A,Student.SID,Class,School from Student JOIN Attendance A on Student.SID = A.SID group by Student.SID) as SA where  Class = '"+AnalyseClass.getText()+"' group by School;";
        System.out.println(sql);
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }

        try { if (!rs.next()) { System.out.println("No Record Found"); }
        else { do {S.getData().add(new XYChart.Data(rs.getString("School").substring(4),Double.parseDouble(rs.getString("x")))); } while (rs.next()); } }
        catch (SQLException e) { e.printStackTrace(); }
        S.setName(AnalyseClass.getText());
        AAChart.getData().addAll(S);
    }

    public void FB()
    {
        stmt = null;
        XYChart.Series S = new XYChart.Series();
        try { stmt = ConnectDB.DB.createStatement(); } catch (SQLException e) { e.printStackTrace(); }

        sql = "SELECT School,AVG(Feedback) as x FROM Teacher WHERE Class = '"+AnalyseClass.getText()+" ' group by School;";
        try { if (stmt != null) { rs = stmt.executeQuery(sql); } } catch (SQLException e) { e.printStackTrace(); }

        try { if (!rs.next()) { System.out.println("No Record Found"); }
        else { do {S.getData().add(new XYChart.Data(rs.getString("School").substring(4),Double.parseDouble(rs.getString("x")))); } while (rs.next()); } }
        catch (SQLException e) { e.printStackTrace(); }
        S.setName(AnalyseClass.getText());
        FBChart.getData().addAll(S);
    }


    public void Analyse()
    { BMI();FB();AA();AM(); }

    public void GoHome() throws IOException
    { Main.setRoot_Home(); }

    public void Back() throws IOException
    { Main.setRoot_Login(); }

    public void Predict()
    {
        double a = Double.parseDouble(Fb.getText())*0.5;
        double b =Double.parseDouble(A.getText())*0.05;
        double c = Double.parseDouble(M.getText())*0.05;
        double d = abs(23.0 - Double.parseDouble(B.getText()))*0.5;
        double z = max(min(a+b+c-d,10),0);
        Score.setText(String.valueOf(z));
    }

}
