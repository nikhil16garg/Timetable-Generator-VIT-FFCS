package application;

import java.awt.event.ActionEvent;
import java.lang.System.Logger;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class controller implements Initializable
{
	  @FXML
	    private TableColumn<Usermaster, String> c_desc;

	    @FXML
	    private TableColumn<Usermaster,String> c_eid;

	    @FXML
	    private TableColumn<Usermaster,String> c_scode;

	    @FXML
	    private TableColumn<Usermaster, String> c_type;

	    @FXML
	    private TableView<Usermaster> ctable;

	    @FXML
	    private AnchorPane table;
	    private ObservableList<Usermaster>data;
	    private DBClass db;
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			@FXML
			 private void initialize(ActionEvent event)
			{
				try{
					Connection conn = db.getConnection();
				
				data = FXCollections.observableArrayList();
				ResultSet rs = conn.createStatement().executeQuery("select * from facultylogin ;");
				while(rs.next()) {
					data.add(new Usermaster(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
				}
				}
				catch(SQLException ex)
				{
				ex.getMessage();
				}
				c_eid.setCellValueFactory(new PropertyValueFactory<>("eid"));
				c_scode.setCellValueFactory(new PropertyValueFactory<>("scode"));
				c_type.setCellValueFactory(new PropertyValueFactory<>("type"));
				c_desc.setCellValueFactory(new PropertyValueFactory<>("sdesc"));
				ctable.setItems(null);
				ctable.setItems(null);
			}
			
		}

	

}