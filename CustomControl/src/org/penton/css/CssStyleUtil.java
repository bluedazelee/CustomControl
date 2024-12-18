package org.penton.css;

import java.io.File;

import javafx.stage.Stage;

public class CssStyleUtil {
	private static File cssFile = new File("resource/application.css");
	
	public static void setCssStage(Stage stage) {
		stage.getScene().getStylesheets().add(cssFile.toURI().toString());
	}
}
