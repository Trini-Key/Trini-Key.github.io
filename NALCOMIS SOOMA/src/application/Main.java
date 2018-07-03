package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setMinHeight(200);
			primaryStage.setMinWidth(450);
			primaryStage.setMaxHeight(200);
			primaryStage.setMaxWidth(450);
			GridPane root = (GridPane) FXMLLoader.load(getClass().getResource("SoomaDesign.fxml"));
			Scene scene = new Scene(root, 350, 200);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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
