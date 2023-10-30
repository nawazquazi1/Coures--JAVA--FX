package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.AnimationTimer;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

public class Controller implements Initializable {
	
	private BooleanProperty wPressed = new SimpleBooleanProperty();
    private BooleanProperty aPressed = new SimpleBooleanProperty();
    private BooleanProperty sPressed = new SimpleBooleanProperty();
    private BooleanProperty dPressed = new SimpleBooleanProperty();

    private BooleanBinding keyPressed = wPressed.or(aPressed).or(sPressed).or(dPressed);

    private int movementVariable = 2;
    private double shapeSize;

    @FXML
    private Rectangle shape1;

    @FXML
    private AnchorPane scene;

    @FXML
    void start(ActionEvent event) {
        shape1.setLayoutY(200);
        shape1.setLayoutX(280);
    }
    
    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long timestamp) {

            if(wPressed.get()) {
                shape1.setLayoutY(shape1.getLayoutY() - movementVariable);
            }

            if(sPressed.get()){
                shape1.setLayoutY(shape1.getLayoutY() + movementVariable);
            }

            if(aPressed.get()){
                shape1.setLayoutX(shape1.getLayoutX() - movementVariable);
            }

            if(dPressed.get()){
                shape1.setLayoutX(shape1.getLayoutX() + movementVariable);
            }
            squareAtBorder();
        }
    };

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		shapeSize = shape1.getHeight();
		movementSetup();

        keyPressed.addListener(((observableValue, aBoolean, t1) -> {
            if(!aBoolean){
                timer.start();
            } else {
                timer.stop();
            }
        }));
	}
	
	public void movementSetup(){
        scene.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.W) {
                wPressed.set(true);
            }

            if(e.getCode() == KeyCode.A) {
                aPressed.set(true);
            }

            if(e.getCode() == KeyCode.S) {
                sPressed.set(true);
            }

            if(e.getCode() == KeyCode.D) {
                dPressed.set(true);
            }
        });

        scene.setOnKeyReleased(e ->{
            if(e.getCode() == KeyCode.W) {
                wPressed.set(false);
            }

            if(e.getCode() == KeyCode.A) {
                aPressed.set(false);
            }

            if(e.getCode() == KeyCode.S) {
                sPressed.set(false);
            }

            if(e.getCode() == KeyCode.D) {
                dPressed.set(false);
            }
        });
    }
	
	public void squareAtBorder() {
		double leftBound = 0;
		double rightBound = scene.getWidth() - shapeSize;
		double bottomBound = scene.getHeight() - shapeSize;
		double topBound = 0;
		
		if(shape1.getLayoutX() <= leftBound) {
			shape1.setLayoutX(leftBound);
		}
		if(shape1.getLayoutX() >= rightBound) {
			shape1.setLayoutX(rightBound);
		}
		if(shape1.getLayoutY() <= topBound) {
			shape1.setLayoutY(topBound);
		}
		if(shape1.getLayoutY() > bottomBound) {
			shape1.setLayoutY(bottomBound);
		}
	}
	
}
























