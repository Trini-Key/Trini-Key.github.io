package MyAdditions;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AddNumbers extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setMinHeight(500);
			primaryStage.setMinWidth(700);
			primaryStage.setMaxHeight(500);
			primaryStage.setMaxWidth(700);
			HBox root = (HBox) FXMLLoader.load(getClass().getResource("/controllers/AddNumbers.fxml"));
			Scene scene = new Scene(root, 350, 200);
			primaryStage.setTitle("Add Numbers");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
