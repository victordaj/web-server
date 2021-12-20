package GUI;

import GUI.Controllers.WebServerController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL fxmlResource = getClass().getResource("FXML/WebServer.fxml");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(fxmlResource);
        Parent root = loader.load();
        primaryStage.setTitle("Web Server");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}


