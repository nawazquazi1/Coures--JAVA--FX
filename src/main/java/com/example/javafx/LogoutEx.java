package com.example.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LogoutEx extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader root = new FXMLLoader(LogoutController.class.getResource("logout.fxml"));
        Scene scene=new Scene(root.load());
        stage.setTitle("Logout Example");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
