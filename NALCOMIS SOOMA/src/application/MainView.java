package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainView {

	// Extends Application

	public void display() {
		try {

			Stage primaryStage = new Stage();
			primaryStage.setMinHeight(600);
			primaryStage.setMinWidth(1000);
			BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("HomeDesign.fxml"));
			Scene scene = new Scene(root, 800, 600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
