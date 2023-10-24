package elements;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class Iron extends Element{
    public Iron(AnchorPane scene) {
        super(ElementType.IRON, scene);
        setCircle(createCircle(Color.GRAY));

        setImage("iron.png");
    }
}