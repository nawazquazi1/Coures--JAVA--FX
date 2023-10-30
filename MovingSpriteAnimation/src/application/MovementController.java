package application;
import javafx.animation.AnimationTimer;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;

public class MovementController {

    private BooleanProperty wPressed = new SimpleBooleanProperty();
    private BooleanProperty aPressed = new SimpleBooleanProperty();
    private BooleanProperty sPressed = new SimpleBooleanProperty();
    private BooleanProperty dPressed = new SimpleBooleanProperty();

    private BooleanBinding keyPressed = wPressed.or(aPressed).or(sPressed).or(dPressed);

    private int movementVariable = 2;

    private RunningAnimation runningAnimation;

    @FXML
    private ImageView sprite;

    @FXML
    private AnchorPane scene;

    public void makeRunnerMovable(ImageView sprite, AnchorPane scene){
        this.sprite = sprite;
        this.scene = scene;

        movementSetup();
        runningAnimation = new RunningAnimation(sprite);

        keyPressed.addListener(((observableValue, aBoolean, t1) -> {
            if(!aBoolean){
                timer.start();
                runningAnimation.startAnimation();
            } else {
                timer.stop();
                runningAnimation.stopAnimation();
            }
        }));
    }

    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long timestamp) {

            if(wPressed.get()) {
                sprite.setLayoutY(sprite.getLayoutY() - movementVariable);
            }

            if(sPressed.get()){
                sprite.setLayoutY(sprite.getLayoutY() + movementVariable);
            }

            if(aPressed.get()){
                sprite.setLayoutX(sprite.getLayoutX() - movementVariable);
            }

            if(dPressed.get()){
                sprite.setLayoutX(sprite.getLayoutX() + movementVariable);
            }
        }
    };

    private void movementSetup(){
        scene.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.W) {
                wPressed.set(true);
            }

            if(e.getCode() == KeyCode.A) {
                aPressed.set(true);
            }

            if(e.getCode() == KeyCode.S) {
                sPressed.set(true);
            }

            if(e.getCode() == KeyCode.D) {
                dPressed.set(true);
            }
        });

        scene.setOnKeyReleased(e ->{
            if(e.getCode() == KeyCode.W) {
                wPressed.set(false);
            }

            if(e.getCode() == KeyCode.A) {
                aPressed.set(false);
            }

            if(e.getCode() == KeyCode.S) {
                sPressed.set(false);
            }

            if(e.getCode() == KeyCode.D) {
                dPressed.set(false);
            }
        });
    }
}