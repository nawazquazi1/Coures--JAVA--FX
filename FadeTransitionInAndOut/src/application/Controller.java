package application;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Controller {
	
	@FXML
    private Rectangle rectangle;

    @FXML
    void fadeIn(ActionEvent event) {
    	FadeTransition fadeTransition = new FadeTransition(Duration.seconds(2), rectangle);
    	fadeTransition.setFromValue(1.0);
    	fadeTransition.setToValue(0);
    	fadeTransition.play();
    }

    @FXML
    void fadeOut(ActionEvent event) {
    	FadeTransition fadeTransition = new FadeTransition(Duration.seconds(2), rectangle);
    	fadeTransition.setFromValue(0);
    	fadeTransition.setToValue(1.0);
    	fadeTransition.play();
    }
}











