package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

public class Controller {

    @FXML
    private TextArea textInput;

    @FXML
    private TextArea morseOutput;

    MorseCodeTranslator morseCodeTranslator = new MorseCodeTranslator();

    boolean morseToText = false;

    @FXML
    void updateMorseCode(KeyEvent event) {
        if(morseToText){
            morseOutput.setText(morseCodeTranslator.translateToText(textInput.getText()));
        }else {
            morseOutput.setText(morseCodeTranslator.translateToMorse(textInput.getText()));
        }
    }

    @FXML
    void switchStyle(ActionEvent event) {
        morseToText = !morseToText;
    }

}






