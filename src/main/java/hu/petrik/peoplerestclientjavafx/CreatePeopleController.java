package hu.petrik.peoplerestclientjavafx;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class CreatePeopleController extends Controller{
    @FXML
    private TextField emailfield;
    @FXML
    private TextField namefield;
    @FXML
    private Spinner<Integer> agefield;
    @FXML
    private Button submitbutton;

    @FXML
    private void initialize(){
        SpinnerValueFactory.IntegerSpinnerValueFactory valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,200,30);
        agefield.setValueFactory(valueFactory);
    }

    @FXML
    public void submitClick(ActionEvent actionEvent) {
        String name = namefield.getText().trim();
        String email = emailfield.getText().trim();
        int age = agefield.getValue();
        if (name.isEmpty()){
            warning("Name is required");
            return;
        }
        if (email.isEmpty()){
            warning("Email is required ");
            return;
        }
        //TODO: validate email format
        Person newPerson = new Person(0,name, email, age);
        Gson converter = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String json = converter.toJson(newPerson);
        try {
            Response response = RequestHandler.post(App.BASE_URL, json);
            if (response.getResponseCode() == 201){
                warning("Person added!");
                namefield.setText("");
                emailfield.setText("");
                agefield.getValueFactory().setValue(30);
            } else {
                //TODO: error
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
