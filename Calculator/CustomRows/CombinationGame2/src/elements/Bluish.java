package elements;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class Bluish extends Element {

    public Bluish(AnchorPane scene) {
        super(ElementType.BLUISH, scene);
        setCircle(createCircle(Color.BLUE));
    }
}