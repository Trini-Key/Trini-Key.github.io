package application;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginController {
	protected Main loginView;
	protected MainView homepage = new MainView();
	protected Aircraft_Model ac;
	protected AddBirdWindow aw = new AddBirdWindow();

	@FXML
	protected TextField uName;
	@FXML
	protected PasswordField pWord;
	@FXML
	protected Button login;

	@FXML
	protected void submission() {
		login.setOnAction(e -> {
			new MainView().display();
			closeCurrentWin();
		});
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
