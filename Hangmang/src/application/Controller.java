package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller implements Initializable{

	@FXML
    private Text hangmanTextArea;

    @FXML
    private TextField guess;

    @FXML
    private Text textForWord;

    @FXML
    private Text endOfGameText;

    private String word;

    private StringBuilder secretWord = new StringBuilder();

    private int livesPos = 0;

    ArrayList<String> hangManLives = new ArrayList<>(Arrays.asList(
            """
            +---+
            |   |
                |
                |
                |
                |
          =========""",
            """
            +---+
            |   |
            O   |
                |
                |
                |
          =========""",
            """
            +---+
            |   |
            O   |
            |   |
                |
                |
          =========""",
            """
            +---+
            |   |
            O   |
           /|   |
                |
                |
          =========""",
            """
            +---+
            |   |
            O   |
           /|\\  |
                |
                |
          =========""",
            """
            +---+
            |   |
            O   |
           /|\\  |
           /    |
                |
          =========""",
            """
            +---+
            |   |
            O   |
           /|\\  |
           / \\  |
                |
          ========="""
    ));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hangmanTextArea.setText(hangManLives.get(livesPos));
    }

    @FXML
    void getTextInput(ActionEvent event) {
        if(word == null){
            word = guess.getText();
            setupWord();
            guess.clear();
        } else{
            playTurn();
        }
    }

    public void setupWord(){
        int wordLength = word.length();
        secretWord.append("*".repeat(wordLength));
        textForWord.setText(String.valueOf(secretWord));
    }

    public void playTurn(){
        String guess = this.guess.getText();
        ArrayList<Integer> positions = new ArrayList<>();
        char[] wordChars = word.toCharArray();
        char letterGuess = guess.charAt(0);

        if(word.equals(guess)){
            endOfGameText.setText("You won!!");
            return;
        }

        if(word.contains(guess)){
            for (int i = 0; i < word.length(); i++) {
                if(wordChars[i] == letterGuess){
                    positions.add(i);
                }
            }
            positions.forEach(pos ->{
                secretWord.setCharAt(pos,letterGuess);
            });

            textForWord.setText(String.valueOf(secretWord));
        } else {
            hangmanTextArea.setText(hangManLives.get(++livesPos));
            if(livesPos == 6){
                endOfGameText.setText("You LOST!!");
            }
        }
    }

    @FXML
    void reset(ActionEvent event) {
        word = null;
        secretWord.setLength(0);
        livesPos = 0;
        hangmanTextArea.setText(hangManLives.get(0));
        endOfGameText.setText("");
    }
}











