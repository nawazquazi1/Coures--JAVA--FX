package application;

import javafx.application.Platform;
import javafx.scene.text.Text;

public class TextAnimator implements Runnable {
	
	private Text textArea;
	private String text;
	private int time;
	
	public TextAnimator(Text textArea, int time) {
		this.textArea = textArea;
		this.time = time;
	}

	@Override
	public void run() {
		try {
			while(true) {
				if(textArea.getText().trim().length() == 0) {
					text = "Text";
				} else {
					text = "";
				}
				Platform.runLater(() -> {
					textArea.setText(text);
				});
				Thread.sleep(time);
			}
		}catch (InterruptedException e) {}
	}

}
