package org.penton;

import org.penton.view.TestSceneCtrl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		TestSceneCtrl ctrl = new TestSceneCtrl(primaryStage);
		
		try {
			FXMLLoader loader = new FXMLLoader(ctrl.getClass().getResource(ctrl.getClass().getSimpleName() + ".fxml"));
			loader.setController(ctrl);
			loader.load();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		ctrl.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
