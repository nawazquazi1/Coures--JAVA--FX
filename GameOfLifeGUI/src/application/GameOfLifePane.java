package application;

import java.util.Random;

import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class GameOfLifePane extends Pane{
	int amountOfSquares = 10;
	
	Random rand = new Random();
	
	public void paint(int[][] grid) {
		double width = getWidth();
		double height = getHeight();
		double squareSize = width / amountOfSquares;
		
		for(int i=0;i<amountOfSquares;i++) {
			for(int j=0;j<amountOfSquares;j++) {
				Point2D p1 = new Point2D(i * squareSize, j * squareSize);
				Point2D p2 = new Point2D(i * squareSize, (j * squareSize)+squareSize);
				Point2D p3 = new Point2D((i * squareSize)+squareSize, (j * squareSize)+squareSize);
				Point2D p4 = new Point2D((i * squareSize)+squareSize, j * squareSize);
				
				Polygon square = new Polygon();
				square.getPoints().addAll(p1.getX(), p1.getY(), p2.getX(), p2.getY(),
						p3.getX(), p3.getY(), p4.getX(), p4.getY());
				if(grid[j][i] == 1) {
					square.setStroke(Color.BLACK);
					square.setFill(Color.BLACK);
				} else {
					square.setStroke(Color.WHITE);
					square.setFill(Color.WHITE);
				}
				
				this.getChildren().add(square);
			}
		}
	}

}













