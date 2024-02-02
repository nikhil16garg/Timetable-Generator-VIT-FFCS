package application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
public class Scene12Controller {
@FXML
private TextField t1;
@FXML
private TextField t2;
@FXML
private Button b1;
@FXML
private Button b2;
@FXML
public void Login(ActionEvent event) throws IOException{
Connection con = null;
PreparedStatement pst;
ResultSet rs;
String name = t1.getText();
String password = t2.getText();
if(name == "" || password == " ")
JOptionPane.showMessageDialog(null, "Username or Password is blank");
else
{
try
{
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ffcs","root","");
pst = con.prepareStatement("select * from adminlogin where username= ? and password= ? ;");
pst.setString(1, name);
pst.setString(2, password);
rs = pst.executeQuery();
if(rs.next())
{
FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene23.fxml"));
Parent root = loader.load();
Stage stage = new Stage();
stage.setScene(new Scene(root));
stage.show();
}
else
{
JOptionPane.showMessageDialog(null, "Invalid user");
t1.setText("");
t2.setText("");
t1.requestFocus();
}
}
catch (ClassNotFoundException e)
{
e.printStackTrace();
}
catch (SQLException e)
{
e.printStackTrace();
}
}
}
@FXML
public void Cancel(ActionEvent event) {
System.exit(0);
}
}

