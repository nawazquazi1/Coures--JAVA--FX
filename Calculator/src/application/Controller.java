package application;

import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Controller implements Initializable {
	
	@FXML
	private AnchorPane pane;
	
	int size = 1;
	double[] values = new double[(192 * (size*size))];
	
	SimplexNoise simplexNoise = new SimplexNoise();
	
	private double z = 0;
	
	Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.1), e -> {
		pane.getChildren().clear();
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		z += 0.01;
		z = Double.parseDouble(nf.format(z));
		updateNoise(z);
		System.out.println("Z: " + z);
	}));

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		timeline.setCycleCount(600);
		timeline.play();
	}
	
	private void updateNoise(double z) {
		for(int i=0;i<values.length;i++) {
			int x = i % (16*size);
			int y = i / (16*size);
			
			// double value = SimplexNoise.noise(x, y);
			double value = simplexNoise.noise(x, y, z);
			
			values[i] = value;
			int sizeAndPos = 50 / size;
			Rectangle rectangle = new Rectangle(x*sizeAndPos, y*sizeAndPos, sizeAndPos, sizeAndPos);
			if(value > 0.1) {
				rectangle.setFill(Color.gray(values[i]));
			} else {
				rectangle.setFill(Color.WHITE);
			}
			
			pane.getChildren().add(rectangle);
		}
	}
}











