package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Controller implements Initializable {
	
	FileChooser fileChooser = new FileChooser();
	

    @FXML
    private TextArea textArea;

    @FXML
    void getText(MouseEvent event) {
    	File file = fileChooser.showOpenDialog(new Stage());
    	try {
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()) {
				textArea.appendText(sc.nextLine() + "\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void save(MouseEvent event) {
    	File file = fileChooser.showSaveDialog(new Stage());
    	if(file != null) {
    		saveSystem(file, textArea.getText());
    	}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		fileChooser.setInitialDirectory(new File("C:\\Users\\otabo\\Documents\\GUI\\FileChooser\\src\\application"));
	}
	
	public void saveSystem(File file, String content) {
		try {
			PrintWriter pw = new PrintWriter(file);
			pw.write(content);
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
