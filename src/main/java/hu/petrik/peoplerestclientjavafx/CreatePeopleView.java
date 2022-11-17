package hu.petrik.peoplerestclientjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

public class CreatePeopleView {
    @FXML
    private TextField emailfield;
    @FXML
    private TextField namefield;
    @FXML
    private Spinner<Integer> agefield;
    @FXML
    private Button submitbutton;

    @FXML
    public void submitClick(ActionEvent actionEvent) {
    }
}
