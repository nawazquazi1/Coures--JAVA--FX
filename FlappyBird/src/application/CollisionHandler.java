package application;

import java.util.ArrayList;

import javafx.scene.shape.Rectangle;

public class CollisionHandler {
	
    public boolean collisionDetection(ArrayList<Rectangle> obstacles , Rectangle bird){
        for (Rectangle rectangle: obstacles) {
            if(rectangle.getBoundsInParent().intersects(bird.getBoundsInParent())){
                return true;
            }
        }
        return  false;
    }
}