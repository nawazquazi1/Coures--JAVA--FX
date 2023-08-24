package com.example.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author im_na
 */
public class Sample extends Application {
    @Override
    public void start(Stage stage) throws Exception {
       FXMLLoader root = new FXMLLoader(Sample.class.getResource("sample.fxml"));
        Scene scene=new Scene(root.load(),600,800);
        stage.setTitle("Fxml Example");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
