package application;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.util.Callback;

public class Controller implements Initializable {
	
	ObservableList<LocalDate> selectedDates = FXCollections.observableArrayList();
	
	@FXML
    private DatePicker datePicker;

    @FXML
    private Spinner<Integer> numberSpinner;
    
    SpinnerValueFactory<Integer> svf
    	= new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);

    @FXML
    private Text text;

    @FXML
    void getNumber(MouseEvent event) {
    	text.setText(Integer.toString(numberSpinner.getValue()));
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		numberSpinner.setValueFactory(svf);
		
		datePicker.setOnAction(e -> {
			if(selectedDates.size() > 1) {
				selectedDates.clear();
			}
			selectedDates.add(datePicker.getValue());
		});
		
		datePicker.setDayCellFactory(new Callback<DatePicker, DateCell>() {
			@Override
			public DateCell call(DatePicker arg0) {
				return new DateCell() {
					@Override
					public void updateItem(LocalDate item, boolean empty) {
						super.updateItem(item, empty);
						boolean alreadySelected = selectedDates.contains(item);
						setDisable(alreadySelected);
						setStyle(alreadySelected ? "-fx-background-color: #C06C84" : "");
					}
				};
			}
		});
	}
	
	@FXML
    void show(KeyEvent event) {
		if(event.getCode() == KeyCode.ENTER) {
			System.out.println("Enter pressed!");
		}
		if(event.getCode() == KeyCode.SPACE) {
			System.out.println("SPACE pressed!");
		}
    }
	 
	@FXML
	void getDate(MouseEvent event) {
		for(LocalDate date : selectedDates) {
			System.out.println(date);
		}
	}


}
