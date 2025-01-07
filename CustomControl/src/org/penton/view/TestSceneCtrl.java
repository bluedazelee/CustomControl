package org.penton.view;

import java.net.URL;
import java.util.ResourceBundle;

import org.penton.css.CssStyleUtil;
//import org.penton.custom.SwitchButtonCtrl;
import org.penton.custom.SwitchButtonCtrl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Window;

public class TestSceneCtrl implements Initializable{
	
	@FXML
    private AnchorPane root;
	
	@FXML
	private SwitchButtonCtrl switchBtn;
	
	@FXML
	private Button btn;
	
	private Window owner;
	private Stage stage;
	
	public TestSceneCtrl(Window owner) {
		this.owner = owner;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initInstance();
	}
	
	private void initInstance() {
		stage = new Stage();
		
		stage.setScene(new Scene(root));
		stage.initOwner(owner);
		CssStyleUtil.setCssStage(stage);
		
//		System.out.println(switchBtn.getIsOn());
//		switchBtn.setIsOn(false);
		
		btn.disableProperty().bind(switchBtn.onProperty());
		
//		SwitchButtonCtrl switchButton = new SwitchButtonCtrl();
//		root.getChildren().add(switchButton);
	}
	
	public void show() {
		stage.show();
	}
	
	@FXML
	void handleBtn(ActionEvent event) {
		if (switchBtn.getKnobColor() == Color.DODGERBLUE) {
			switchBtn.setKnobColor(Color.rgb(221, 221, 221));
		} else {
			switchBtn.setKnobColor(Color.DODGERBLUE);
		}
	}

}
