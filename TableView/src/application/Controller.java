package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller implements Initializable {
	
	@FXML
	private TableView<User> table;

    @FXML
    private TableColumn<User, String> name;

    @FXML
    private TableColumn<User, Integer> age;

    @FXML
    private TableColumn<User, String> animal;
    
    ObservableList<User> list = FXCollections.observableArrayList(
    		new User("Daniel", 20, "Dog"),
    		new User("Hello", 40, "Cat"),
    		new User("Dasss", 30, "Bird")
    );

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		name.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
		age.setCellValueFactory(new PropertyValueFactory<User, Integer>("age"));
		animal.setCellValueFactory(new PropertyValueFactory<User, String>("animal"));
		
		table.setItems(list);
	}
    
    

}
