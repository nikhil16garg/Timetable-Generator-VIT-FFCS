package application;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class Usermaster{    

   public SimpleStringProperty eid = new SimpleStringProperty(); 
   public SimpleStringProperty scode = new SimpleStringProperty();
   public SimpleStringProperty type = new SimpleStringProperty();
   public SimpleStringProperty sdesc = new SimpleStringProperty();
   public Usermaster(String eid,String scode,String type,String sdesc)
   {
	   this.eid =new SimpleStringProperty(eid);
	   this.scode = new SimpleStringProperty(scode);
	   this.type = new SimpleStringProperty(type);
	   this.sdesc = new SimpleStringProperty(sdesc);
   }

   public String geteid() {
      return eid.get();
   }

   public String getscode() {
      return scode.get();
   }

   public String gettype() {
      return type.get();
   }

   public String getsdesc() {
      return sdesc.get();
   }
}