package com.example.javafx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author im_na
 */
public class PolygonNod extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        Group group = new Group();
        Scene scene = new Scene(group, 600, 600, Color.LIGHTBLUE);

        Polygon polygon=new Polygon();
        polygon.getPoints().setAll(
                200.0,200.0,300.0,300.0,200.0,300.0
        );
        polygon.setFill(Color.ORANGE);

        group.getChildren().add(polygon);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
