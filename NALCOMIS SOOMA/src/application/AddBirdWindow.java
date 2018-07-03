package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddBirdWindow {
	
	public void display() {
		try {
			Stage primaryStage = new Stage();
			primaryStage.setMinHeight(400);
			primaryStage.setMinWidth(400);
			VBox addACWindow = (VBox)FXMLLoader.load(getClass().getResource("addAC.fxml"));
			Scene scene = new Scene(addACWindow,350,200);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}	
				
	}
}


