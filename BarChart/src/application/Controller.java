package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;

public class Controller implements Initializable {
	
	@FXML
    private BarChart<String, Integer> chart;

    @FXML
    private AnchorPane scene;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		XYChart.Series<String, Integer> series1 = new XYChart.Series<String, Integer>();
		series1.setName("2000");
		series1.getData().add(new XYChart.Data<>("Brazil", 200));
		series1.getData().add(new XYChart.Data<>("Germany", 150));
		series1.getData().add(new XYChart.Data<>("Denmark", 150));
		series1.getData().add(new XYChart.Data<>("United States of America", 250));
		
		XYChart.Series<String, Integer> series2 = new XYChart.Series<String, Integer>();
		series2.setName("2001");
		series2.getData().add(new XYChart.Data<>("Brazil", 230));
		series2.getData().add(new XYChart.Data<>("Germany", 250));
		series2.getData().add(new XYChart.Data<>("Denmark", 150));
		series2.getData().add(new XYChart.Data<>("United States of America", 350));
		
		chart.getData().setAll(series1, series2);
	}
    
    
}











