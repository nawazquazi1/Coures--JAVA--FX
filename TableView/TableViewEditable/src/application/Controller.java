package application;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

	@FXML
    private TableView<Animal> animals;

    @FXML
    private TableColumn<Animal, Integer> idCol;

    @FXML
    private TableColumn<Animal, String> typeCol;

    @FXML
    private TableColumn<Animal, String> nameCol;


    @FXML
    private TextField inputId;

    @FXML
    private TextField inputType;

    @FXML
    private TextField inputName;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idCol.setCellValueFactory(new PropertyValueFactory<Animal, Integer>("id"));
        typeCol.setCellValueFactory(new PropertyValueFactory<Animal, String>("type"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Animal, String>("name"));
        setupTable();
    }

    @FXML
    void submit(ActionEvent event) {
        ObservableList<Animal> currentTableData = animals.getItems();
        int currentAnimalId = Integer.parseInt(inputId.getText());

        for (Animal animal : currentTableData) {
            if(animal.getId() == currentAnimalId) {
                animal.setType(inputType.getText());
                animal.setName(inputName.getText());

                animals.setItems(currentTableData);
                animals.refresh();
                break;
            }
        }
    }

    @FXML
    void rowClicked(MouseEvent event) {
        Animal clickedAnimal = animals.getSelectionModel().getSelectedItem();
        inputId.setText(String.valueOf(clickedAnimal.getId()));
        inputType.setText(String.valueOf(clickedAnimal.getType()));
        inputName.setText(String.valueOf(clickedAnimal.getName()));
    }

    private void setupTable(){
        Animal animal0 = new Animal(0,"Dog","Buddy");
        Animal animal1 = new Animal(1,"Cat","Bella");
        Animal animal2 = new Animal(2,"Bear","Bob");
        Animal animal3 = new Animal(3,"Squid","Laila");
        animals.getItems().addAll(animal0,animal1,animal2,animal3);
    }
}











