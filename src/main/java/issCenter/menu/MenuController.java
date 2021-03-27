package issCenter.menu;

import database.hibernate.HibernateSingleton;
import issCenter.settings.SettingsController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @FXML
    GridPane mainGridPane;

    @FXML
    ImageView currentSpeedImageView;

    @FXML
    ImageView peopleInSpaceImageView;

    @FXML
    ImageView passPredictionsImageView;

    @FXML
    ImageView currentPositionImageView;

    @FXML
    ImageView settingsImageView;

    public static HibernateSingleton hibernateSingleton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hibernateSingleton = HibernateSingleton.getInstance();
    }

    public void loadCurrentSpeed(MouseEvent mouseEvent) {
        URL resource = getClass().getClassLoader().getResource("fxml/currentSpeed.fxml");
        loadNewScene(resource);
    }

    public void loadPeopleInSpace(MouseEvent mouseEvent){
        URL resource = getClass().getClassLoader().getResource("fxml/peopleInSpace.fxml");
        loadNewScene(resource);
    }

    public void loadCurrentPosition(MouseEvent mouseEvent){
        URL resource = getClass().getClassLoader().getResource("fxml/currentPosition.fxml");
        loadNewScene(resource);
    }

    public void loadPassPredictions(MouseEvent mouseEvent){
        URL resource = getClass().getClassLoader().getResource("fxml/passPredictions.fxml");
        loadNewScene(resource);
    }

    public void loadSettings(MouseEvent mouseEvent){
        URL resource = getClass().getClassLoader().getResource("fxml/settings.fxml");
        loadNewScene(resource);
    }

    private void loadNewScene(URL resource) {
        if (resource != null) {
            try {
                Pane peopleInSpace = FXMLLoader.load(resource);
                Stage stage = (Stage) mainGridPane.getScene().getWindow();
                stage.setScene(new Scene(peopleInSpace, mainGridPane.getWidth(), mainGridPane.getHeight()));
                if (SettingsController.fullScreenModeOn) {
                    stage.setFullScreenExitHint("");
                    stage.setFullScreen(true);
                }
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void loadMenuScene(Node node){
        URL resource = MenuController.class.getClassLoader().getResource("fxml/menu.fxml");
        if (resource != null) {
            try {
                Pane peopleInSpace = FXMLLoader.load(resource);
                Stage stage = (Stage) node.getScene().getWindow();
                stage.setScene(new Scene(peopleInSpace, node.getScene().getWidth(), node.getScene().getHeight()));
                if(SettingsController.fullScreenModeOn){
                    stage.setFullScreen(true);
                    stage.setFullScreenExitHint("");
                }
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
