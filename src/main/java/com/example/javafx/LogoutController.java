package com.example.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LogoutController {

    @FXML
    private Button logoutButton;
    @FXML
    private AnchorPane pane;
    @FXML
    private Stage stage;

    public void logOut(ActionEvent event){
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are about to logout");
        alert.setContentText("Co You Want To Save Before Exiting ? :");
        if (alert.showAndWait().get()== ButtonType.OK) {
            stage = (Stage) pane.getScene().getWindow();
            System.out.println("You  logout");
            stage.close();
        }
    }
}
