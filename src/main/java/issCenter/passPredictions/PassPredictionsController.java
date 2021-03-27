package issCenter.passPredictions;

import issCenter.menu.MenuController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import java.net.URL;
import java.util.ResourceBundle;

public class PassPredictionsController implements Initializable {
    @FXML
    BorderPane borderPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void loadMenu(MouseEvent mouseEvent) {
        MenuController.loadMenuScene(borderPane);
    }
}
