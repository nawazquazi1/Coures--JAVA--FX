package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

public class Controller implements Initializable {
	
	GameOfLifePane gameOfLifePane = new GameOfLifePane();
	int[][] grid = {
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
			{0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
			{0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	};
	
	GameOfLife gameOfLife = new GameOfLife(grid);
	
	@FXML
	private BorderPane borderPane;
	@FXML
	private Button nextGen;
	
	Timeline timeLine = new Timeline(new KeyFrame(Duration.seconds(0.25),
			e -> {
				grid = gameOfLife.nextGeneration();
				gameOfLifePane.paint(grid);
			}));

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		borderPane.setCenter(gameOfLifePane);
		
		gameOfLifePane.widthProperty().addListener(ov -> gameOfLifePane.paint(grid));
		gameOfLifePane.paint(grid);
		
		timeLine.setCycleCount(Animation.INDEFINITE);
	}
	
	@FXML
	void nextGen(MouseEvent e) {
		grid = gameOfLife.nextGeneration();
		gameOfLifePane.paint(grid);
	}
	
	@FXML
	void startAnimation(MouseEvent e) {
		if(timeLine.getStatus() == Animation.Status.RUNNING) {
			System.out.println("TimeLie already running!");
		} else {
			grid = gameOfLife.nextGeneration();
			gameOfLifePane.paint(grid);
			timeLine.play();
		}
	}
	
	@FXML
	void stopAnimation(MouseEvent e) {
		timeLine.stop();
	}
	
}





















