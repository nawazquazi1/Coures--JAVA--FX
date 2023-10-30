package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class Controller implements Initializable {
	
	@FXML
    private LineChart<?, ?> chart;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		XYChart.Series series = new XYChart.Series();
		
		series.getData().add(new XYChart.Data("1", 5));
		series.getData().add(new XYChart.Data("2", 4));
		series.getData().add(new XYChart.Data("3", 6));
		
		XYChart.Series series2 = new XYChart.Series();
		
		series2.getData().add(new XYChart.Data("1", 2));
		series2.getData().add(new XYChart.Data("3", 2));
		series2.getData().add(new XYChart.Data("4", 5));
		
		chart.getData().addAll(series, series2);
	}
    
}











