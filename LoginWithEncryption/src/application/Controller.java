package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller {
	
	@FXML
	public TextField usernameTextField;
	@FXML
	public TextField passwordTextField;
	@FXML
	public TextField errorField;
	@FXML
	private PasswordField hiddenPasswordTextField;
	@FXML
	private CheckBox showPassword;
	
	File file = new File("data.txt");
	
	HashMap<String, String> loginInfo = new HashMap<String, String>();
	
	Encryptor encryptor = new Encryptor();
	
	byte[] encryptionKey = {65, 12, 12, 12, 12, 12, 12, 12, 12,
            12, 12, 12, 12, 12, 12, 12};
	
	@FXML
	void changeVisibility(ActionEvent e) {
		if(showPassword.isSelected()) {
			passwordTextField.setText(hiddenPasswordTextField.getText());
			passwordTextField.setVisible(true);
			hiddenPasswordTextField.setVisible(false);
			return;
		}
		hiddenPasswordTextField.setText(passwordTextField.getText());
		hiddenPasswordTextField.setVisible(true);
		passwordTextField.setVisible(false);
	}
	
	@FXML
	void loginHandler(ActionEvent e) throws FileNotFoundException, InvalidKeyException,
			NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException,
			IllegalBlockSizeException, BadPaddingException {
		
		String username = usernameTextField.getText();
		String password = getPassword();
		updateUsernameAndPasswords();
		
		String encryptedPassword = loginInfo.get(username);
		if(password.equals(encryptor.decrypt(encryptedPassword, encryptionKey))) {
			System.out.println("Successfully login!");
		} else {
			errorField.setVisible(true);
		}
	}
	
	@FXML
	void createAccount(ActionEvent e) throws InvalidKeyException, NoSuchAlgorithmException,
			NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException,
			InvalidAlgorithmParameterException, IOException {
		
		writeToFile();
	}
	
	private String getPassword() {
		if(passwordTextField.isVisible()) {
			return passwordTextField.getText();
		} else {
			return hiddenPasswordTextField.getText();
		}
	}
	
	private void updateUsernameAndPasswords() throws FileNotFoundException {
		Scanner sc = new Scanner(file);
		loginInfo.clear();
		loginInfo = new HashMap<String, String>();
		while(sc.hasNext()) {
			String[] splitInfo = sc.nextLine().split(",");
			loginInfo.put(splitInfo[0], splitInfo[1]);
		}
	}
	
	private void writeToFile() throws InvalidKeyException, NoSuchAlgorithmException,
			NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException,
			InvalidAlgorithmParameterException, IOException {
		
		String username = usernameTextField.getText();
		String password = getPassword();
		BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
		
		writer.write(username + "," + encryptor.encrypt(password, encryptionKey) + "\n");
		writer.close();
	}
}














