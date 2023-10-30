package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class Controller implements Initializable{
	
	@FXML
	public ModeButton modeButton;
	@FXML
	private Label welcomeText;
	
	@FXML
	protected void onHelloButtonClick() {
		welcomeText.setText("Welcome to JavaFX Application!");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		modeButton.setOnActivation(e -> {
			if(modeButton.isState()) {
				System.out.println("Connect");
			} else {
				System.out.println("Disconnect");
			}
		});
	}
	
	
}











