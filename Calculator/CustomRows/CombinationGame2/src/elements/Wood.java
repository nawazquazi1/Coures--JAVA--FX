package elements;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class Wood extends Element{

    public Wood(AnchorPane scene) {
        super(ElementType.WOOD, scene);
        setCircle(createCircle(Color.BROWN));

        setImage("wood.png");
    }
}