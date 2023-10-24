package application;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javafx.util.Duration;

public class Controller implements Initializable {
	
	// Time time = new Time(new CurrentTime().currentTime());
	Time time = new Time("12:0:0");
	
	@FXML
	private Text timer;
	@FXML
	private TextField alarmTime;
	
	Timeline timeLine = new Timeline(
				new KeyFrame(Duration.seconds(1),
						e -> {
							if(time.getCurrentTime().equals(alarmTime.getText()))
								System.out.println("ALARM!");
							time.oneSecondPassed();
							timer.setText(time.getCurrentTime());
						}));

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		timer.setText(time.getCurrentTime());
		
		timeLine.setCycleCount(Timeline.INDEFINITE);
		timeLine.play();
	}
	
	


}
