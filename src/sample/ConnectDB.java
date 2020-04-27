package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB
{
    public static Connection DB;
    public static void SetUpDB()
    {
        String dbURL = "jdbc:mysql://localhost:3306/DBMS?autoReconnect-true&useSSL=false";
        String username = "root";
        String password = "password";
        try { DB = DriverManager.getConnection(dbURL, username, password);System.out.println("Connected To DataBase Successfully."); }
        catch (SQLException e) { e.printStackTrace(); }
    }
}