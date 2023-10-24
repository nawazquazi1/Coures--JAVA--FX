package main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class Controller implements Initializable{
	
	@FXML
    private AnchorPane scene;
    private MatchHandler matchHandler;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        matchHandler = new MatchHandler(scene);
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                matchHandler.checkMatches();
            }
        };
        animationTimer.start();

    }

    @FXML
    void getWood(ActionEvent event) {
        matchHandler.createWood();
    }

    @FXML
    void getIron(ActionEvent event) {
        matchHandler.createIron();
    }
}











