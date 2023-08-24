package com.example.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;

/**
 * @author im_na
 */
public class EventController {

    @FXML
    private Circle circle;
    private double x;
    private double y;

    @FXML
    public void up(ActionEvent event) {
        circle.setCenterY(y -= 10);
    }

    @FXML
    public void down(ActionEvent event) {
        circle.setCenterY(y += 10);
    }

    @FXML
    public void left(ActionEvent event) {
        circle.setCenterX(x -= 10);
    }

    @FXML
    public void right(ActionEvent event) {
        circle.setCenterX(x += 10);
    }

}
