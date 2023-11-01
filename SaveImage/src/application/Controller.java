package application;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {
	
	@FXML
    private ImageView imageView;

    @FXML
    void saveImage(ActionEvent event) {
    	// Getting the image from the ImageView
    	Image imageToBeSaved = imageView.getImage();
    	
    	// Create a new file path at the position we want to save our image
    	File file = new File("C:\\Users\\otabo\\Downloads\\image.jpg");
    	
    	try {
			ImageIO.write(SwingFXUtils.fromFXImage(imageToBeSaved, null), "jpg", file);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}











