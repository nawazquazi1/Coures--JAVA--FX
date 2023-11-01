package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Controller implements Initializable {
	
	@FXML
    private Circle circle;
    @FXML
    private Text text;
    @FXML
    private Text timeLine;
    
    TextAnimator textAnimator;
    
    Thread thread;
    
    TranslateTransition transition;
    
    int i = 0;

    @FXML
    void start(MouseEvent event) {
    	thread = new Thread(textAnimator);
    	thread.start();
    }

    @FXML
    void stop(MouseEvent event) {
    	thread.interrupt();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		textAnimator = new TextAnimator(text, 100);
		
		transition = new TranslateTransition();
		transition.setNode(circle);
		transition.setToX(500.0);
		transition.setToY(300.0);
		transition.setDuration(Duration.seconds(3));
		transition.setAutoReverse(true);
		transition.setCycleCount(2);
		
		timeLine.setText(String.valueOf(i));
		
		Timeline tLine = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
			i++;
			timeLine.setText(String.valueOf(i));
		}));
		tLine.setCycleCount(Animation.INDEFINITE);
		tLine.play();
	}
	
	@FXML
    void go(ActionEvent event) {
		transition.play();
    }
	
	@FXML
    private CheckBox checkbox;

    @FXML
    private PasswordField passwordHidden;

    @FXML
    private TextField passwordText;

    @FXML
    void changeVisibility(ActionEvent event) {
    	if(checkbox.isSelected()) {
    		passwordText.setText(passwordHidden.getText());
    		passwordText.setVisible(true);
    		passwordHidden.setVisible(false);
    		return;
    	}
		passwordHidden.setText(passwordText.getText());
		passwordHidden.setVisible(true);
		passwordText.setVisible(false);
    }

}
