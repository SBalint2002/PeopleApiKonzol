package hu.petrik.peoplerestclientjavafx;

import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;

public class ListPeopleController {

    @FXML
    private Button insertButton, updateButton, deleteButton;
    @FXML
    private TableView<Person> peopleTable;
    @FXML
    private TableColumn<Person, String> nameCol;
    @FXML
    private TableColumn<Person, String> emailCol;
    @FXML
    private TableColumn<Person, Integer> ageCol;

    @FXML
    private void initialize() {
        try {
            Response response = RequestHandler.get(App.BASE_URL);
            String content = response.getContent();
            Gson converter = new Gson();
            Person[] people = converter.fromJson(content, Person[].class);
            for(Person person :people){
                peopleTable.getItems().add(person);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void insertClick(ActionEvent actionEvent) {
    }

    @FXML
    public void updateClick(ActionEvent actionEvent) {
    }

    @FXML
    public void deleteClick(ActionEvent actionEvent) {
    }
}