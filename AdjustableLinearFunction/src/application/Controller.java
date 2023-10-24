package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Pane coordinateSystem;
    @FXML
    private Slider aSlider;
    @FXML
    private Slider bSlider;
    @FXML
    private Text functionText;
    @FXML
    private RadioButton powerFunction;
    @FXML
    private RadioButton exponentialFunction;

    private int paneWidth = 300;

    Function function;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setupSlider(aSlider);
        setupSlider(bSlider);
    }

    private void setupSlider(Slider Slider) {
        Slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                if(powerFunction.isSelected()){
                    function = new PowerFunction(aSlider.getValue(),bSlider.getValue());
                } else if(exponentialFunction.isSelected()){
                    function = new ExponentialFunction(aSlider.getValue(),bSlider.getValue());
                }
                coordinateSystem.getChildren().clear();
                drawFunction();
            }
        });
    }

    public void drawFunction(){
        functionText.setText(function.toString());
        for (double i = 0; i < 200; i = i + 0.5) {
            coordinateSystem.getChildren().add(drawPoint(i,function.getY(i)));
        }
    }

    public Circle drawPoint(double x, double y){
        return new Circle(x,-(y-paneWidth),1);
    }
}









