package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {
	
	PigLatinTranslator pigLatinTranslator = new PigLatinTranslator();
	
	@FXML
    private TextField input;

    @FXML
    private TextField output;

    @FXML
    void translate(ActionEvent event) {
    	String translated = pigLatinTranslator.translate(input.getText());
    	if(translated == null) {
    		output.setText("Not possible");
    	} else {
    		output.setText(translated);
    	}
    }
	
}











