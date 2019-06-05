package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class InitWorkOrderWindow {
	
	public void display() {
		try {

			Stage primaryStage = new Stage();
			primaryStage.setMinHeight(600);
			primaryStage.setMinWidth(1000);
			GridPane initMaf = (GridPane) FXMLLoader.load(getClass().getResource("/resources/InitWorkOrder.fxml"));
			Scene scene = new Scene(initMaf, 800, 600);
			scene.getStylesheets().add(getClass().getResource("/resources/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
