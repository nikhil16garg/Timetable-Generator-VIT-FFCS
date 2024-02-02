package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBClass{    
    public Connection getConnection() throws ClassNotFoundException, SQLException{       
    	Class.forName("com.mysql.jdbc.Driver");
    	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ffcs","root","");
    	return conn;
    }
}