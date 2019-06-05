package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EditAcWindow {
	
	public void display() {
		try {
			Stage primaryStage = new Stage();
			primaryStage.setMinHeight(500);
			primaryStage.setMinWidth(400);
			primaryStage.setMaxHeight(500);
			primaryStage.setMaxWidth(400);
			VBox editACWindow = (VBox)FXMLLoader.load(getClass().getResource("/resources/EditAC.fxml"));
			Scene scene = new Scene(editACWindow,350,200);
			scene.getStylesheets().add(getClass().getResource("/resources/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}	
				
	}

}
