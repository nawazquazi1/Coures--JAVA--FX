package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.Transition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Controller implements Initializable{

	private String text = "Software!";

    @FXML
    private AnchorPane anchorPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Point2D center = new Point2D(300, 130);
        drawText(text, 60, center);
    }

    public void drawText(String word, double initialRotation, Point2D center){
        double curveAngle = 80; // 60 to 150 looks best
        char[] wordArray = word.toCharArray();

        double radius = 100;

        boolean aboveCenter = initialRotation < 180;

        final ObservableList<Text> parts = FXCollections.observableArrayList();
        final ObservableList<PathTransition> transitions = FXCollections.observableArrayList();

        for (int i = 0; i < word.length(); i++) {
            double finalAngle = (i+1)*curveAngle/word.length();

            Shape arc = createCurve(center, radius, curveAngle,  finalAngle, initialRotation, aboveCenter);

            Text part = new Text(String.valueOf(wordArray[i]));

            part.setStyle("-fx-font-size: 25px");
            parts.add(part);

            transitions.add(createPathTransition(arc, part));
        }

        for (int i = 0; i < parts.size(); i++) {
            parts.get(i).setVisible(true);
            final Transition transition = transitions.get(i);
            transition.stop();
            transition.play();
        }

        anchorPane.getChildren().addAll(parts);
    }

    private PathTransition createPathTransition(Shape curve, Text text) {
        final PathTransition transition = new PathTransition(Duration.millis(1), curve, text);

        transition.setAutoReverse(false);
        transition.setCycleCount(1);
        transition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        transition.setInterpolator(Interpolator.LINEAR);

        return transition;
    }

    private Shape createCurve(Point2D center, double radius, double totalAngle, double angel, double initialRotation, boolean revert) {
        Arc arc = new Arc();
        arc.setCenterX(center.getX());
        arc.setCenterY(center.getY());
        if (revert) {
            final double endAngle = initialRotation + totalAngle;
            arc.setStartAngle(endAngle);
            arc.setLength(-angel);
        } else {
            arc.setStartAngle(initialRotation);
            arc.setLength(angel);
        }
        arc.setRadiusX(radius);
        arc.setRadiusY(radius);
        return arc;
    }
}











