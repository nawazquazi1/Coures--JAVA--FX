package com.example.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author im_na
 */
public class EventHandel extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader root = new FXMLLoader(EventController.class.getResource("EventController.fxml"));
        Scene scene=new Scene(root.load());
        stage.setTitle("Event Example");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
