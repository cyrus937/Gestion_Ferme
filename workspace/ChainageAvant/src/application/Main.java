package application;
	
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			URL ressource = Main.class.getResource("../view/chainageAvant.fxml");
			Parent root = FXMLLoader.load(ressource);
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.centerOnScreen();
			primaryStage.setResizable(true);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void printError(String title,String headerText,String contentText) {
		Alert error = new Alert(AlertType.ERROR);
		if(title == null || contentText == null ) 
			System.out.println("Erreur dans printError");
		else{
			error.setTitle(title);
			error.setHeaderText(headerText);
			error.setContentText(contentText);
			
			Stage dStage = (Stage)(error.getDialogPane().getScene().getWindow());
			dStage.getIcons().add(new Image("/view/error.jpg"));
			
			error.showAndWait();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
