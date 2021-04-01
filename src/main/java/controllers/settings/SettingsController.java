package controllers.settings;

import controllers.menu.MenuController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class SettingsController implements Initializable {

    @FXML
    BorderPane borderPane;

    @FXML
    CheckBox fullScreenCheckBox;

    public static boolean fullScreenModeOn = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (fullScreenModeOn) {
            fullScreenCheckBox.setSelected(true);
        }
    }

    public void loadMenu(MouseEvent mouseEvent) {
        MenuController.loadMenuScene(borderPane);
    }

    public void changeScreenMode(ActionEvent event) {
        List<Window> open = Stage.getWindows().stream().filter(Window::isShowing).collect(Collectors.toList());
        if (!open.isEmpty()) {
            Stage stage = (Stage) open.get(0);
            if (fullScreenCheckBox.isSelected()) {
                stage.setFullScreen(true);
                setFullScreenModeOn(true);
            } else {
                stage.setFullScreen(false);
                setFullScreenModeOn(false);
            }
        }
    }

    public static void setFullScreenModeOn(boolean fullScreenModeOn) {
        SettingsController.fullScreenModeOn = fullScreenModeOn;
    }
}
