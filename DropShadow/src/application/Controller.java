package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.effect.DropShadow;
import javafx.scene.shape.Polygon;

public class Controller implements Initializable {
	
	@FXML
    private Slider offsetXSlider;

    @FXML
    private Slider offsetYSlider;

    @FXML
    private Slider radiusSlider;

    @FXML
    private Polygon triangle;
    
    DropShadow dropShadow = new DropShadow();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		triangle.setEffect(dropShadow);
		
		radiusSlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				dropShadow.setRadius(radiusSlider.getValue());
			}
		});
		
		offsetXSlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				dropShadow.setOffsetX(offsetXSlider.getValue());
			}
		});
		
		offsetYSlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				dropShadow.setOffsetY(offsetYSlider.getValue());
			}
		});
	}
	
	


}
