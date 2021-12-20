package GUI.Controllers;

import config.Config;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import server.Server;

import java.net.Socket;

public class WebServerController extends Application {
    @FXML
    public Text serverAddress;
    @FXML
    public Text serverStatus;
    @FXML
    public Text serverIp;
    @FXML
    public Button start;
    @FXML
    public TextField listeningPort;
    @FXML
    public CheckBox mainteinanceMode;
    @FXML
    public TextField rootDirectory;
    @FXML
    public TextField mainteinanceDirectory;

    public Server server = new Server("localhost", 2000 ) ;

    public void handleSubmitButtonAction(){
        if(start.getText().equals("Start")){
            server.init();
            System.out.println("miau");
            serverStatus.setText("running");
            serverIp.setText(Integer.toString(Config.port));
            serverAddress.setText("not running");
            start.setText("Stop");
            listeningPort.setDisable(true);
            rootDirectory.setDisable(true);
            mainteinanceMode.setDisable(false);
        }
        else if(start.getText().equals("Stop")){
            serverStatus.setText("not running");
            serverAddress.setText("not running");
            serverIp.setText("not running");
            start.setText("Start");
            listeningPort.setDisable(false);
            rootDirectory.setDisable(false);
            mainteinanceMode.setDisable(true);
        }

     }

     public void handleMaintainanceAction(){
        if(!mainteinanceMode.isSelected()){
         serverStatus.setText("mainteinance");
         serverIp.setText(Integer.toString(Config.port));
         serverAddress.setText("not running");
        }
        else {

        }
     }
     public void onRootChange(){
     }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }

    public void initialize() {
        serverAddress.setText("not running");
        serverStatus.setText("not running");
        serverIp.setText("not running");
        mainteinanceMode.setDisable(true);
    }

}
