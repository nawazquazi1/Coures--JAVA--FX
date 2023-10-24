package com.example.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author im_na
 */
public class StageAndSceneExample extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Group group = new Group();
        Scene scene = new Scene(group, 320, 240);
        primaryStage.setTitle("JavaFX DEMO");
        primaryStage.setScene(scene);
//        Image icon = new Image("path/to/icon.png");
//        primaryStage.getIcons().add(icon);
        // Enter full-screen mode
        primaryStage.setFullScreen(true);
        // Exit full-screen mode
        primaryStage.setFullScreen(false);
       // Minimize the stage
        primaryStage.setIconified(true);
       // Maximize the stage
        primaryStage.setMaximized(true);
        // Set X position
        primaryStage.setX(100);
        // Set Y position
        primaryStage.setY(200);
        // Set minimum width
        primaryStage.setMinWidth(400);
        // Set minimum height
        primaryStage.setMinHeight(300);
        // Set maximum width
        primaryStage.setMaxWidth(800);
        // Set maximum height
        primaryStage.setMaxHeight(600);
       // Close the stage

// primaryStage.close();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

