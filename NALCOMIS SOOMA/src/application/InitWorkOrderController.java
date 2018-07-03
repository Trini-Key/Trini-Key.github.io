package application;


import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

	
public class InitWorkOrderController {
	
	protected Main loginView;
	protected MainView homepage = new MainView();	
	protected Aircraft_Model ac;
	protected AddBirdWindow aw = new AddBirdWindow();
	
	public InitWorkOrderController() {
		
	}
	
	@FXML
	protected void initialize() {
		
	}

}
