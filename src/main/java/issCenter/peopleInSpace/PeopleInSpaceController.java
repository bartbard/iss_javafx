package issCenter.peopleInSpace;


import database.model.Astronaut;

import issCenter.menu.MenuController;
import issCenter.settings.SettingsController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import javax.naming.Name;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PeopleInSpaceController implements Initializable {
    @FXML
    BorderPane borderPane;

    @FXML
    VBox vBox;

    private List<Astronaut> astronautsList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        astronautsList = MenuController.hibernateSingleton.getIssRepository().getAstronautsFromDataBase();
        createLabelForEachAstronaut();
    }
    public void loadMenu(MouseEvent mouseEvent) {
        MenuController.loadMenuScene(borderPane);
    }
    private void createLabelForEachAstronaut() {
        for (Astronaut astronaut : astronautsList) {
            vBox.getChildren().add(addLabel(astronaut.getCraftName(), astronaut.getNameAndSurname()));
            vBox.setAlignment(Pos.CENTER);
        }
    }
    private Label addLabel(String craft, String name) {
        Label label = new Label();
        label.setText(name +" on the " + craft + " spacecraft");
        label.setAlignment(Pos.CENTER);
        label.setTextFill(Paint.valueOf("#FFFFFF"));
        label.setStyle("-fx-font-size: 30");
        label.setMinHeight(75);
        return label;
    }


}
