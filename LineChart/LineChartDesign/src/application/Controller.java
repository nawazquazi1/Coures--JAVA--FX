package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller implements Initializable {
	
	private Stage stage;
	
	private double x=0, y=0;
	
	@FXML
    private LineChart<?, ?> lineChart;

    @FXML
    private AnchorPane sideBar;

    @FXML
    void closeProgram(ActionEvent event) {
    	stage.close();
    }
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	sideBar.setOnMousePressed(mouseEvent -> {
    		x = mouseEvent.getSceneX();
    		y = mouseEvent.getSceneY();
    	});
    	
    	sideBar.setOnMouseDragged(mouseEvent -> {
    		stage.setX(mouseEvent.getScreenX() - x);
    		stage.setY(mouseEvent.getScreenY() - y);
    	});
    	
    	lineChart.getXAxis().setLabel("XAxis");
    	lineChart.getYAxis().setLabel("YAxis");
    	
    	XYChart.Series series1 = new XYChart.Series();
    	
    	series1.getData().add(new XYChart.Data<String, Integer>("1",5));
        series1.getData().add(new XYChart.Data<String, Integer>("2",4));
        series1.getData().add(new XYChart.Data<String, Integer>("3",6));
        series1.getData().add(new XYChart.Data<String, Integer>("5",3));
        series1.getData().add(new XYChart.Data<String, Integer>("9",10));

        XYChart.Series series2 = new XYChart.Series();

        series2.getData().add(new XYChart.Data<String, Integer>("1",2));
        series2.getData().add(new XYChart.Data<String, Integer>("3",2));
        series2.getData().add(new XYChart.Data<String, Integer>("4",5));

        XYChart.Series series3 = new XYChart.Series();

        series3.getData().add(new XYChart.Data<String, Integer>("1",1));
        series3.getData().add(new XYChart.Data<String, Integer>("2",4));
        series3.getData().add(new XYChart.Data<String, Integer>("4",9));

        lineChart.getData().addAll(series1,series2,series3);
    	
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
}
























