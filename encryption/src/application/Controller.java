package application;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {
	
	Encryptor encryptor = new Encryptor();
	
	@FXML
	private TextField keyTextField;
	@FXML
	private TextField inputTextField;
	@FXML
	private TextField outputTextField;
	
	@FXML
	void decryptButton(ActionEvent e) throws InvalidKeyException, NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException,
			BadPaddingException {
		
		// Could be 128, 192, or 256 bits.
		byte[] key = encryptor.stringToByteArray(keyTextField.getText());
		String input = inputTextField.getText();
		String encryptedString = encryptor.decrypt(input, key);
		outputTextField.setText(encryptedString);
	}
	
	@FXML
	void encryptButton(ActionEvent e) throws InvalidKeyException, NoSuchAlgorithmException,
			NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException,
			InvalidAlgorithmParameterException {
		
		// Cound be 128, 192, or 256 bits.
		byte[] key = encryptor.stringToByteArray(keyTextField.getText());
		String input = inputTextField.getText();
		
		String encryptedString = encryptor.encrypt(input, key);
		outputTextField.setText(encryptedString);
	}
}