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
public class Scene131Controller {
@FXML
private Label l1;
@FXML
private TextField t1;
@FXML
private Label l3;
@FXML
private TextField t3;
@FXML
private Label l5;
@FXML
private TextField t5;
@FXML
private Label l2;
@FXML
private TextField t2;
@FXML
private Label l4;
@FXML
private TextField t4;
@FXML
private Label l6;
@FXML
private TextField t6;
@FXML
private Button b8;
// Event Listener on Button[#b8].onAction
@FXML
public void B8(ActionEvent event) throws ClassNotFoundException {
Connection con = null;
PreparedStatement pst,pst1,pst2;
ResultSet rs;
String subcode = t1.getText();
String empid = t2.getText();
String subname = t3.getText();
String day = t4.getText();
String startsat = t5.getText();
String endsat = t6.getText();
if(subcode == "" || empid == " " || subname == " " || day == " " || startsat ==" " || endsat == " ")
JOptionPane.showMessageDialog(null, "please fill all the options");
else
{
try
{
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ffcs","root","");
String sql = "insert into timetable values (?,?,?,?,?,?);";
pst=con.prepareStatement(sql);
pst.setString(1, subcode);
pst.setString(2, empid);
pst.setString(3, subname);
pst.setString(4, day);
pst.setString(5, startsat);
pst.setString(6, endsat);
pst.execute();
String sql1 = "select * from wishlist where subcode = ? and empid = ?;";
pst1 = con.prepareStatement(sql1);
pst1.setString(1, subcode);
pst1.setString(2, empid);
rs = pst1.executeQuery();
if(rs.next()==false)
{
JOptionPane.showMessageDialog(null, "No record");
String sql2 = "delete from timetable where subcode=? and empid=?;";
pst2=con.prepareStatement(sql2);
pst2.setString(1, subcode);
pst2.setString(2, empid);
pst2.executeUpdate();
}
else
JOptionPane.showMessageDialog(null, "Subject allocated !!");
pst1.close();
pst.close();
}
catch(SQLException e)
{
System.out.print(e.getMessage()+" \n this course is not wishlisted by the faculty or the correct value is not entered \n");
JOptionPane.showMessageDialog(null, "\n this course is not wishlisted by the faculty or the correct value is not entered \n");
}
}
}
}
