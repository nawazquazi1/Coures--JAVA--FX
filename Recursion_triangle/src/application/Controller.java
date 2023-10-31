package application;

import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class Controller implements Initializable {
	
	@FXML
    private Label time;
    @FXML
    private TextField textInput;
    @FXML
    private BorderPane borderPane;
    @FXML
    private Label timeLabel;

    SierpinskiTrianglePane trianglePane = new SierpinskiTrianglePane();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        borderPane.setCenter(trianglePane);

        trianglePane.widthProperty().addListener(ov -> trianglePane.paint());
        trianglePane.heightProperty().addListener(ov -> trianglePane.paint());

        trianglePane.paint();

        textInput.setOnAction(
                e -> trianglePane.setOrder(Integer.parseInt(textInput.getText())));

        //timeHandler = new TimeHandler(time);

        Runnable timeHandler = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                            	try {
                            		timeLabel.setText(String.valueOf(LocalTime.now()));
                            	} catch (NullPointerException e) {}
                            }
                        });
                    } catch (InterruptedException e) {
                    	e.printStackTrace();
                    }
                }
            }
        };

        Thread thread = new Thread(timeHandler);
        thread.start();
    }
}