package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Controller implements Initializable {

	@FXML
    private Rectangle rectangle;

    @FXML
    private AnchorPane anchorPane;


    DraggableMaker draggableMaker = new DraggableMaker();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        draggableMaker.makeDraggable(rectangle);
        draggableMaker.makeDraggable(anchorPane);
    }

}












