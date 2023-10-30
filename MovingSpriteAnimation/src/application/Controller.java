package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Controller implements Initializable{
	
	@FXML
	private AnchorPane scene;
	
	@FXML
	private ImageView runner;
	
	private MovementController movementController = new MovementController();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		movementController.makeRunnerMovable(runner, scene);
	}
	
}











