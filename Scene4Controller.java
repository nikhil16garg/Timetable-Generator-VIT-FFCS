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
public class Scene4Controller {
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
String name = t1.getText();
String id = t2.getText();
String publisher = t3.getText();
String author = t4.getText();
String m_name = t5.getText();
String date = t6.getText();
if(name == "" || id == " " || publisher == " " || author == " " || m_name ==" " || date == " ")
JOptionPane.showMessageDialog(null, "please fill all the options");
else
{
try
{
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
String sql = "insert into lent values (?,?,?,?,?,?);";
pst=con.prepareStatement(sql);
pst.setString(1, name);
pst.setString(2, id);
pst.setString(3, publisher);
pst.setString(4, author);
pst.setString(5, m_name);
pst.setString(6, date);
pst.execute();
String sql1 = "select * from book where name = ? and id = ?;";
pst1 = con.prepareStatement(sql1);
pst1.setString(1, name);
pst1.setString(2, id);
rs = pst1.executeQuery();
if(rs.next()==false)
{
JOptionPane.showMessageDialog(null, "No record");
String sql2 = "delete from lent where name=? and id=?;";
pst2=con.prepareStatement(sql2);
pst2.setString(1, name);
pst2.setString(2, id);
pst2.executeUpdate();
}
else
JOptionPane.showMessageDialog(null, "Book has been lent");
pst1.close();
pst.close();
}
catch(SQLException e)
{
System.out.print(e.getMessage()+" \n this book is not available or the correct value is not entered \n");
JOptionPane.showMessageDialog(null, "\n this book is not available or the correct value is not entered \n");
}
}
}
}
