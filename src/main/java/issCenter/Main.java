package issCenter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.net.URL;



public class Main extends Application {
    public Stage mainStage;
    @Override
    public void start(Stage primaryStage) throws Exception {
        URL resource = getClass().getClassLoader().getResource("fxml/menu.fxml");
        if (resource != null) {
            Parent root = FXMLLoader.load(resource);
            primaryStage.setTitle("ISS Center");
            primaryStage.getIcons().add(new Image("images/ISSCommandCenter.png"));
            primaryStage.setScene(new Scene(root, 1800, 850));
            primaryStage.setMaximized(true);
            primaryStage.show();
            mainStage = primaryStage;
        }else {
            System.err.println("MAIN:Resource is null");
        }
    }
    public static void main (String[]args){
            launch(args);

        }

    }

