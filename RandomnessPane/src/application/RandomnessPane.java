package application;

import java.util.Random;

import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

public class RandomnessPane extends Pane{
	int amountOfSquares = 10;
	
	Random rand = new Random();
	
	public void paint() {
		double width = getWidth();
		double height = getHeight();
		double squareSize = width / amountOfSquares;
		
		for(int i=0;i<amountOfSquares;i++) {
			for(int j=0;j<amountOfSquares;j++) {
				Point2D p1 = new Point2D(i * squareSize, j*squareSize);
				Point2D p2 = new Point2D(i * squareSize, j*squareSize);
			}
		}
	}

}
