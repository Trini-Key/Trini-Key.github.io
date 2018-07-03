package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;


public class AddNumberController {
	
	@FXML
	protected TextField txtField1, txtField2;
	@FXML
	protected Label txtField3;
	@FXML
	protected Button add, clear, exit;
	
	/** I can declare as int or float first then make that var = Float.parseFloat(txtField1.getText()) 
	 * or Integer.parseInt(txtfield2.getText()) and so on. then make a method that 
	 * just adds the two and parse them back to string and return to result textfield.
	 */	
	
	@FXML
	protected void initialize() {
		
	}
	
	@FXML
	protected float getTxt1() {
		float a = Float.parseFloat(txtField1.getText());
		return a;
	}
	
	@FXML
	protected float getTxt2() {
		float b = Float.parseFloat(txtField2.getText());
		return b;
	}
	
	@FXML
	protected void add() {
			float a = getTxt1();
			System.out.println(a);
			float b = getTxt2();
			System.out.println(b);
			float res = a + b;
			String ult = Float.toString(res);
			txtField3.setText(ult);
	}
	
	@FXML
	protected void exitP() {		
			System.exit(0);		
	}
	
	@FXML
	protected void clear() {
		txtField1.setText("");
		txtField2.setText("");
		txtField3.setText("");
	}
	
}
