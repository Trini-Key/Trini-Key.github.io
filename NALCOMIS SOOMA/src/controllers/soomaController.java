package controllers;

import application.AddBirdWindow;
import application.EditAcWindow;
import application.InitWorkOrderWindow;
import application.Main;
import application.MainView;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import models.Aircraft_Model;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

public class soomaController {
	protected Main loginView;
	protected MainView homepage = new MainView();	
	protected Aircraft_Model ac;
	protected AddBirdWindow aw = new AddBirdWindow();
	protected EditAcWindow ew;
	protected InitWorkOrderWindow wow;
	
	private ObservableList<String> names = FXCollections.observableArrayList();
	private ObservableList<Aircraft_Model> acs = FXCollections.observableArrayList();
	
	@FXML 
	protected ListView<String> birdList;	
	@FXML
	protected TextField uName, addBuno, addModex, addTsn, addType;
	@FXML
	protected PasswordField pWord;
	@FXML
	protected Button login, addWinButton, newMafBtn;
	@FXML
	protected GridPane logInWindow;	
	@FXML
	protected Label remIntVal, repDueVal, tsnVal, tsoVal, statusVal, modexVal, bunoVal;
	@FXML
	protected ContextMenu contextMenu;
	@FXML
	protected MenuItem add, remove, view, edit;
	
	/**
	 * The constructor (is called before the initialize()-method).
	 */
	public soomaController() {
		names = FXCollections.observableArrayList("129460 00", "192461 01", "192462 02", "192463 03", "192464 04", "192465 05", "192466 06"); 
		acs = FXCollections.observableArrayList(Aircraft_Model.ac0, Aircraft_Model.ac1, Aircraft_Model.ac2, Aircraft_Model.ac3, Aircraft_Model.ac4, Aircraft_Model.ac5, Aircraft_Model.ac6, Aircraft_Model.ac7);
				
		// Create some sample data for the ComboBox and ListView.	
	}
	
	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	protected void initialize() {
		birdList.setContextMenu(contextMenu);
		
		birdList.setItems(names);
		birdList.setCellFactory(lv -> {

	        ListCell<String> cell = new ListCell<>();
	        edit.textProperty().bind(Bindings.format("Edit AC", cell.itemProperty()));
            //handle onAction for edit contextMenu Item
	        edit.setOnAction(event -> {
	        	new EditAcWindow().display();
                //String item = cell.getItem();
            });//end edit menuItem event            
           
            remove.textProperty().bind(Bindings.format("Delete AC", cell.itemProperty()));
            //Handle onAction for remove cmi
            remove.setOnAction(event -> birdList.getItems().remove(cell.getItem()));

            add.textProperty().bind(Bindings.format("Add new Aircraft", cell.itemProperty()));
            //Handle onAction for add cmi
            add.setOnAction(event ->{
            	new AddBirdWindow().display();
            });
          
            view.textProperty().bind(Bindings.format("View \"%s\"", cell.itemProperty()));
            //Handle onAction for view cmi
            view.setOnAction(event ->{
            	//add action
            });

            cell.textProperty().bind(cell.itemProperty());

            cell.emptyProperty().addListener((obs, wasEmpty, isNowEmpty) -> {
                if (isNowEmpty) {
                    cell.setContextMenu(null);
                } else {
                    cell.setContextMenu(contextMenu);
                }
            });
            return cell ;
        });//end cell handling
		
		birdList.getSelectionModel().selectedItemProperty().addListener(
	            new ChangeListener<String>() {
	                public void changed(ObservableValue<? extends String> ov, 
	                    String old_val, String new_val) {
	                	
	                	 System.out.println("clicked on " + new_val);
	                	 
	 		            switch(new_val){
	 		            case "129460 00":
	 		            	String a = Integer.toString(acs.get(0).getPhInterval());
	 		            	remIntVal.setText(a);
	 		            	a = Integer.toString(acs.get(0).getPhDue());
	 		            	repDueVal.setText(a);
	 		            	a = Integer.toString(acs.get(0).getTsn());
	 		            	tsnVal.setText(a);
	 		            	a = Integer.toString(acs.get(0).getTso());
	 		            	tsoVal.setText(a); 
	 		            	a = acs.get(0).getstatus();
	 		            	statusVal.setText(a); 
	 		            	a = Integer.toString(acs.get(0).getModex());
	 		            	modexVal.setText(a); 
	 		            	a = Integer.toString(acs.get(0).getBuno());
	 		            	bunoVal.setText(a);
	 		            	break;
	 		            case "192461 01":
	 		            	a = Integer.toString(acs.get(1).getPhInterval());
	 		            	remIntVal.setText(a);
	 		            	a = Integer.toString(acs.get(1).getPhDue());
	 		            	repDueVal.setText(a);
	 		            	a = Integer.toString(acs.get(1).getTsn());
	 		            	tsnVal.setText(a);
	 		            	a = Integer.toString(acs.get(1).getTso());
	 		            	tsoVal.setText(a); 
	 		            	a = acs.get(1).getstatus();
	 		            	statusVal.setText(a); 
	 		            	a = Integer.toString(acs.get(1).getModex());
	 		            	modexVal.setText(a);
	 		            	a = Integer.toString(acs.get(1).getBuno());
	 		            	bunoVal.setText(a);
	 		            	break;
	 		            case "192462 02":
	 		            	a = Integer.toString(acs.get(2).getPhInterval());
	 		            	remIntVal.setText(a);
	 		            	a = Integer.toString(acs.get(2).getPhDue());
	 		            	repDueVal.setText(a);
	 		            	a = Integer.toString(acs.get(2).getTsn());
	 		            	tsnVal.setText(a);
	 		            	a = Integer.toString(acs.get(2).getTso());
	 		            	tsoVal.setText(a); 
	 		            	a = acs.get(2).getstatus();
	 		            	statusVal.setText(a);
	 		            	a = Integer.toString(acs.get(2).getModex());
	 		            	modexVal.setText(a);
	 		            	a = Integer.toString(acs.get(2).getBuno());
	 		            	bunoVal.setText(a);
	 		            	break;
	 		            case "192463 03":
	 		            	a = Integer.toString(acs.get(3).getPhInterval());
	 		            	remIntVal.setText(a);
	 		            	a = Integer.toString(acs.get(3).getPhDue());
	 		            	repDueVal.setText(a);
	 		            	a = Integer.toString(acs.get(3).getTsn());
	 		            	tsnVal.setText(a);
	 		            	a = Integer.toString(acs.get(3).getTso());
	 		            	tsoVal.setText(a);
	 		            	a = acs.get(3).getstatus();
	 		            	statusVal.setText(a); 
	 		            	a = Integer.toString(acs.get(3).getModex());
	 		            	modexVal.setText(a);
	 		            	a = Integer.toString(acs.get(3).getBuno());
	 		            	bunoVal.setText(a);
	 		            	break;
	 		            case "192464 04":
	 		            	a = Integer.toString(acs.get(4).getPhInterval());
	 		            	remIntVal.setText(a);
	 		            	a = Integer.toString(acs.get(4).getPhDue());
	 		            	repDueVal.setText(a);
	 		            	a = Integer.toString(acs.get(4).getTsn());
	 		            	tsnVal.setText(a);
	 		            	a = Integer.toString(acs.get(4).getTso());
	 		            	tsoVal.setText(a); 
	 		            	a = acs.get(4).getstatus();
	 		            	statusVal.setText(a);
	 		            	a = Integer.toString(acs.get(4).getModex());
	 		            	modexVal.setText(a);
	 		            	a = Integer.toString(acs.get(4).getBuno());
	 		            	bunoVal.setText(a);
	 		            	break;
	 		            case "192465 05":
	 		            	a = Integer.toString(acs.get(5).getPhInterval());
	 		            	remIntVal.setText(a);
	 		            	a = Integer.toString(acs.get(5).getPhDue());
	 		            	repDueVal.setText(a);
	 		            	a = Integer.toString(acs.get(5).getTsn());
	 		            	tsnVal.setText(a);
	 		            	a = Integer.toString(acs.get(5).getTso());
	 		            	tsoVal.setText(a);
	 		            	a = acs.get(5).getstatus();
	 		            	statusVal.setText(a);
	 		            	a = Integer.toString(acs.get(5).getModex());
	 		            	modexVal.setText(a);
	 		            	a = Integer.toString(acs.get(5).getBuno());
	 		            	bunoVal.setText(a);
	 		            	break;
	 		            case "192466 06":
	 		            	a = Integer.toString(acs.get(6).getPhInterval());
	 		            	remIntVal.setText(a);
	 		            	a = Integer.toString(acs.get(6).getPhDue());
	 		            	repDueVal.setText(a);
	 		            	a = Integer.toString(acs.get(6).getTsn());
	 		            	tsnVal.setText(a);
	 		            	a = Integer.toString(acs.get(6).getTso());
	 		            	tsoVal.setText(a); 
	 		            	a = acs.get(6).getstatus();
	 		            	statusVal.setText(a);
	 		            	a = Integer.toString(acs.get(6).getModex());
	 		            	modexVal.setText(a);
	 		            	a = Integer.toString(acs.get(6).getBuno());
	 		            	bunoVal.setText(a);
	 		            	break;
	 		            }//end switch
	 		            
	            }//end event
	        });//end changeListener
		
		 newMafBtn.setOnAction(event ->{
         	new InitWorkOrderWindow().display();
         });
		
	}//end Init method
}

