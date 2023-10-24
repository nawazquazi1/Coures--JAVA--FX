package com.example.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author im_na
 */
public class SwitchController {

    private Stage stage;
    private Scene scene;
    private FXMLLoader root;

    @FXML
    public void switchToScene1(ActionEvent event) throws IOException {
        root = new  FXMLLoader(getClass().getResource("scene1.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root.load());
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void switchToScene2(ActionEvent event) throws IOException {
        root = new  FXMLLoader(getClass().getResource("scene2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root.load());
        stage.setScene(scene);
        stage.show();
    }


}
