package GUI.Controllers;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class WebServerController extends Application {
    @FXML
    public TextField usernameField;
    @FXML
    public TextField mailField;
    @FXML
    public TextField addressField;
    @FXML
    public TextField accountField;
    @FXML
    public TextField passwordField;
    @FXML
    public Text submitMessage;
    @FXML
    public Button submitButton;

    public void handleSubmitButtonAction(){
     }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
