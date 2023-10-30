package application;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.File;

public class RunningAnimation {

    private ImageView runner;
    int number = 1;

    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.5), event -> {
        if(number == 1){
            runner.setImage(new Image(getFile("runner2.jpg").getAbsolutePath()));
            number = 2;
        } else if( number == 2){
            runner.setImage(new Image(getFile("runner1.jpg").getAbsolutePath()));
            number = 1;
        }
    }));

    public RunningAnimation(ImageView runner) {
        this.runner = runner;
        timeline.setCycleCount(Animation.INDEFINITE);
    }

    private File getFile(String fileName){
        return new File(getClass().getResource(fileName).getPath());
    }

    public void startAnimation(){
        timeline.play();
    }

    public void stopAnimation(){
        timeline.stop();
    }
}