package controllers;

import application.AddBirdWindow;
import application.Main;
import application.MainView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Aircraft_Model;

public class AddWindowController {
	protected Main loginView;
	protected MainView homepage = new MainView();	
	protected Aircraft_Model ac;
	protected AddBirdWindow aw = new AddBirdWindow();
	protected soomaController sc;	
	@FXML TextField addBuno, addModex, addTsn, addType;
	@FXML Button addWinButton;
	static String s = " ";
	
	public AddWindowController() {
		
	}
	
	@FXML
	protected void initialize() {
		//handle add button
		addWinButton.setOnAction(e ->{
			String s = addBuno.getText() + " " + addModex.getText();
			sc.birdList.getItems().add(s);
			Stage stage = (Stage) addWinButton.getScene().getWindow();
		    // do what you have to do
		    stage.hide();
		    		   
		});
	}
	
	/*@FXML
	private void handleAddButton() {
		addWinButton.setOnAction(e ->{
			String s = addBuno.getText() + " " + addModex.getText();
			birdList.getItems().add(addBuno.getText() + " " + addModex.getText());
			Stage stage = (Stage) addWinButton.getScene().getWindow();
		    // do what you have to do
		    stage.hide();
		   
		});
	}*/
	
	

}
