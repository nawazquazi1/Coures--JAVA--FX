package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Controller implements Initializable {
	
	@FXML
    private VBox options;

    Random random = new Random();

    @FXML
    private Text fruit;

    ArrayList<String> optionList = new ArrayList<>(Arrays.asList(
            "Orange", "Apple", "Grapes", "Mango", "Pineapple", "Strawberry",
            "Cherry", "Fig", "Kiwi", "Lemon"
    ));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeButtons();
    }

    @FXML
    void getOption(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();
        fruit.setText(value);
    }

    @FXML
    void rerollOptions(ActionEvent event) {
        initializeButtons();
    }

    private void initializeButtons(){
        ObservableList<Node> buttons = options.getChildren();
        ArrayList<String> fruits = getFruitOptions(buttons.size());
        for (int i = 0; i < buttons.size(); i++) {
            Button button = (Button) buttons.get(i);
            button.setText(fruits.get(i));
        }
    }

    private ArrayList<String> getFruitOptions(int optionAmount){

        ArrayList<String> optionsCopy = (ArrayList<String>) optionList.clone();
        ArrayList<String> pickedFruits = new ArrayList<>();

        for (int i = 0; i < optionAmount; i++) {
            int randomIndex = random.nextInt(optionsCopy.size());
            pickedFruits.add(optionsCopy.remove(randomIndex));
        }
        return pickedFruits;
    }
}











