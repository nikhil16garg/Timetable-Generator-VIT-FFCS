package application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
public class Scene3Controller {
@FXML
private Label l1;
@FXML
private TextField t1;
@FXML
private Label l3;
@FXML
private TextField t3;
@FXML
private Label l2;
@FXML
private TextField t2;
@FXML
private Label l4;
@FXML
private TextField t4;
@FXML
private Button b7;
// Event Listener on Button[#b7].onAction
@FXML
public void B7(ActionEvent event) throws ClassNotFoundException {
Connection con = null;
PreparedStatement pst;
ResultSet rs;
String empid = t1.getText();
String subcode = t2.getText();
String type = t3.getText();
String desc = t4.getText();
if(empid == "" || subcode == " " || type == " " || desc == " ")
JOptionPane.showMessageDialog(null, "please fill all the options");
else
{
try
{
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ffcs","root","");
String sql = "insert into wishlist values (?,?,?,?);";
pst=con.prepareStatement(sql);
pst.setString(1, empid);
pst.setString(2, subcode);
pst.setString(3, type);
pst.setString(4, desc);
System.out.println("You have successfully selected your wishlisht");
JOptionPane.showMessageDialog(null, "course selected");
pst.execute();
pst.close();
}
catch(SQLException e)
{
System.out.print(e.getMessage()+" \n enter valid details");
}
}
}
}