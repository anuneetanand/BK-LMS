package sample;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

import java.io.IOException;

public class ControllerLogin
{
    @FXML
    private JFXTextField Login;
    @FXML
    private JFXPasswordField Password;

    @FXML
    public void Resolve()
    {
        if ((!Password.getText().equals("password")) || (Login.getText().length() != 10))
        { Login.setText(""); Password.setText(""); }
        else
        {
            String Who = Login.getText().substring(0, 4);
            if (Who.equals("SID0")) { ControllerStudent.Student(Login.getText()); }
            else if (Who.equals("TID0")) { ControllerTeacher.Teacher(Login.getText()); }
            else if (Who.equals("GID0")) { ControllerGuardian.Guardian(Login.getText()); }
            else if (Who.equals(("AID0"))) { ControllerAdmin.Admin(Login.getText()); }
            else if (Who.equals("GOVT")) { ControllerGovt.Govt(Login.getText()); }
            else { Login.setText("Invalid!");Password.setText("Invalid!"); }
        }
    }

    public void GoHome() throws IOException
    { Main.setRoot_Home(); }

    public void Error() throws IOException
    { Main.setRoot_Error(); }
}


