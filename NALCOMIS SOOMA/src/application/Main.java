package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setMinHeight(400);
			primaryStage.setMinWidth(850);
//			primaryStage.setMaxHeight(400);
//			primaryStage.setMaxWidth(850);
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/resources/SoomaDesign.fxml"));
			Scene scene = new Scene(root, 350, 200);
			scene.getStylesheets().add(getClass().getResource("/resources/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// list View for educational qualification
	}

	public void closeWin(Stage primaryStage) {
		primaryStage.close();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
