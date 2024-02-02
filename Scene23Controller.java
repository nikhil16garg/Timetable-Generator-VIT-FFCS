package application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.event.ActionEvent;
public class Scene23Controller {
@FXML
private Button b3;
@FXML
private Button b5;
// Event Listener on Button[#b3].onAction
@FXML
public void B3(ActionEvent event) throws IOException {
FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene3.fxml"));
Parent root = loader.load();
Stage stage = new Stage();
stage.setScene(new Scene(root));
stage.show();
}

// Event Listener on Button[#b5].onAction
@FXML
public void B5(ActionEvent event) throws IOException {
FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene131.fxml"));
Parent root = loader.load();
Stage stage = new Stage();
stage.setScene(new Scene(root));
stage.show();
}
}
