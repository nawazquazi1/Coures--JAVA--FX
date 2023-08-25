package com.example.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class ImageViewController {

    @FXML
    ImageView view;
    @FXML
    Button button;
    Image image=new Image(getClass().getResourceAsStream("img2.jpg"));
    @FXML
    public void displayImage(){
        view.setImage(image);
    }
}
