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
public class Scene5Controller {
@FXML
private Label l1;
@FXML
private TextField t1;
@FXML
private Label l2;
@FXML
private TextField t2;
@FXML
private Label l3;
@FXML
private TextField t3;
@FXML
private Label l4;
@FXML
private TextField t4;
@FXML
private Button b9;
// Event Listener on Button[#b9].onAction
@FXML
public void B9(ActionEvent event) {
Connection con = null;
ResultSet rs;
String name = t1.getText();
String id = t2.getText();
String m_name = t3.getText();
String date = t4.getText();
if(name == "" || id == " " || m_name ==" " || date == " ")
JOptionPane.showMessageDialog(null, "please fill all the options");
else
{
try {
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
String sql = "delete from lent where name=? and id=?;";
PreparedStatement pst = con.prepareStatement(sql);
pst.setString(1, name);
pst.setString(2, id);
JOptionPane.showMessageDialog(null, "Book receieved");
pst.executeUpdate();
pst.close();
con.close();
}
catch (ClassNotFoundException e) {
e.printStackTrace();
}
catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
}
}