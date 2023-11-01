module Spinner {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;
	
	opens sample to javafx.graphics, javafx.fxml;
}
