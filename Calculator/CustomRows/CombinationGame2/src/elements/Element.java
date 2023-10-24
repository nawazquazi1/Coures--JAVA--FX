package elements;

import java.io.File;
import java.util.Objects;

import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import main.DraggableMaker;

public abstract class Element {

    private Circle circle;
    private final DraggableMaker draggableMaker = new DraggableMaker();
    private final ElementType elementType;
    private final AnchorPane scene;

    public Element(ElementType elementType, AnchorPane scene) {
        this.elementType = elementType;
        this.scene = scene;
    }

    public Circle getCircle() {
        return circle;
    }

    public ElementType getElementType() {
        return elementType;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public Circle createCircle(Color color){
        Circle circle = new Circle(250,250,30);
        circle.setFill(color);
        draggableMaker.makeDraggable(circle);

        scene.getChildren().add(circle);
        return circle;
    }

    public void remove(){
        scene.getChildren().remove(circle);
    }

    public void setImage(String imageName){
        File file = new File(Objects.requireNonNull(getClass().getResource(imageName).getPath()));
        Image ironTexture = new Image(file.getAbsolutePath());

        circle.setFill(new ImagePattern(ironTexture));
    }
}