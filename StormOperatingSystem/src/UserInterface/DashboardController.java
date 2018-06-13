package UserInterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;

public class DashboardController {

    @FXML
    private AnchorPane dashBoard;

    @FXML
    private TabPane tabPane;

    @FXML
    private Tab tab_1;

    @FXML
    private Tab tab_2;

    @FXML
    private Tab tab_3;

    @FXML
    private Tab tab_4;

    @FXML
    private Button button_1;

    @FXML
    private Button button_2;

    @FXML
    private Button button_3;

    @FXML
    private Button button_4;

    @FXML
    private Label time;

    @FXML
    void button_1Clocked(ActionEvent event) {
        tabPane.getSelectionModel().select(tab_1);
    }

    @FXML
    void button_2Clicked(ActionEvent event) {
        tabPane.getSelectionModel().select(tab_2);
    }

    @FXML
    void button_3Clicked(ActionEvent event) {
        tabPane.getSelectionModel().select(tab_3);
    }

    @FXML
    void button_4Clicked(ActionEvent event) {
        tabPane.getSelectionModel().select(tab_4);
    }

}

