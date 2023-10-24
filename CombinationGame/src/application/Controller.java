package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Controller implements Initializable{
	
	@FXML
	private AnchorPane scene;
	DraggableMaker draggableMaker = new DraggableMaker();
	ArrayList<Circle> elements = new ArrayList<Circle>();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		AnimationTimer animationTimer = new AnimationTimer() {
			
			@Override
			public void handle(long arg0) {
				checkMatches();
			}
		};
		animationTimer.start();
	}
	
	@FXML
	void createWood(ActionEvent e) {
		createElement(Color.BROWN);
	}
	
	@FXML
	void createIron(ActionEvent e) {
		createElement(Color.GRAY);
	}
	
	public void checkMatches() {
		for(int i=0;i<elements.size(); i++) {
			for(int k=0;k<elements.size();k++) {
				if(i != k) {
					if(checkCollision(elements.get(i), elements.get(k))){
						combine(elements.get(i), elements.get(k));
						System.out.println("COMBINED");
					}
				}
			}
		}
	}
	
	public boolean checkCollision(Circle shape1, Circle collisionShape) {
		return shape1.getBoundsInParent().intersects(collisionShape.getBoundsInParent());
	}
	
	public void combine(Circle circle1, Circle circle2) {
		removeElement(circle1);
		removeElement(circle2);
		Circle circle = createElement(Color.BLUE);
	}

	public Circle createElement(Color color) {
		Circle circle = new Circle(150, 150, 15);
		circle.setFill(color);
		draggableMaker.makeDraggable(circle);
		scene.getChildren().add(circle);
		elements.add(circle);
		return circle;
	}
	
	private void removeElement(Circle circle) {
		scene.getChildren().remove(circle);
		elements.remove(circle);
	}
}











