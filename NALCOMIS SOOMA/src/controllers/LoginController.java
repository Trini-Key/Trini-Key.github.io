package controllers;

import java.io.IOException;

import application.Main;
import application.MainView;
import dbconnect.DBConnect;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Aircraft_Model;

public class LoginController {
	protected Main loginView;
	protected MainView homepage = new MainView();
	protected Aircraft_Model ac;
	protected DBConnect con = new DBConnect();

	@FXML
	protected AnchorPane rootPane;
	@FXML
	protected TextField uName;
	@FXML
	protected PasswordField pWord;
	@FXML
	protected Button login;

	@FXML
	protected void initialize() {
//		login.setDisable(true);
//
//		uName.focusedProperty().addListener(new ChangeListener<Boolean>() {
//			@Override
//			public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue,
//					Boolean newPropertyValue) {
//				if (newPropertyValue) {
//					login.setDisable(false);
//				} else if (newPropertyValue && uName.getText().isEmpty()) {
//					login.setDisable(true);
//				}
//			}
//		});
	}

	@FXML
	protected void submission() throws IOException {
		int attempts = 0;

		if (uName.getText().isEmpty() || pWord.getText().isEmpty()) {
			return;
		}

		if (con.getUserName(uName.getText())) {
			System.out.println("you're here");
			if (con.getUserPword(pWord.getText())) {
				AnchorPane pane = FXMLLoader.load(getClass().getResource("/resources/HomeDesign.fxml"));
				rootPane.getChildren().setAll(pane);
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Incorrect Password");
				alert.setHeaderText("The password you entered is incorrect!");
				alert.setContentText(
						"Try again another password acount will lock after " + (3 - ++attempts) + " failed attempts");
				alert.showAndWait();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Unrecognized Username");
			alert.setHeaderText("Not a recognized Username!");
			alert.setContentText("Try again or register a new account");
			alert.showAndWait();
		}

	}

	private void closeCurrentWin() {
		// TODO Auto-generated method stub
		Stage stage = (Stage) login.getScene().getWindow();
		// do what you have to do
		stage.close();
	}

	private void verify(String uname, String pword) {

	}
}
