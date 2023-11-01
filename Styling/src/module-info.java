module SceneBuilder {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens application to javafx.graphics, javafx.fxml;
}
// --module-path "C:\Programs\javafx-sdk-20.0.2\lib" --add-modules javafx.controls,javafx.fxml