package org.penton.custom;

import java.io.IOException;

import javafx.animation.TranslateTransition;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class SwitchButtonCtrl extends AnchorPane{
    @FXML
    private Rectangle background;
    @FXML
    private Rectangle knob;
    
    private BooleanProperty isOn = new SimpleBooleanProperty(false);
    
    private ObjectProperty<Paint> knobColor = new SimpleObjectProperty<>(Color.rgb(221, 221, 221));
    private ObjectProperty<Paint> backgroundColor = new SimpleObjectProperty<>(Color.rgb(201, 201, 201));
    
    private ObjectProperty<Paint> originBackground = new SimpleObjectProperty<>();
    
    protected TranslateTransition transition;
    
    public SwitchButtonCtrl() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(this.getClass().getSimpleName() + ".fxml"));
//			fxmlLoader.setRoot(this);
			
			fxmlLoader.setController(SwitchButtonCtrl.this);
			Node node = fxmlLoader.load();
			this.getChildren().add(node);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		initElements();
	}
    
    void initElements() {
    	transition = new TranslateTransition(Duration.millis(200), knob);
    	
    	background.onMouseClickedProperty().set(event -> switchState());
    	knob.onMouseClickedProperty().set(event -> switchState());
    	
    	knob.fillProperty().bind(knobColor);
    	background.fillProperty().bind(backgroundColor);
    	
    	originBackground.setValue(backgroundColor.getValue());
    }
    
    public Paint getKnobColor() {
    	return knobColor.getValue();
    }
    
    public void setKnobColor(Paint knobColor) {
    	this.knobColor.setValue(knobColor);
    }
    
    public Paint getBackgroundColor() {
    	return backgroundColor.getValue();
    }
    
    public void setBackgroundColor(Paint backgroundColor) {
    	this.backgroundColor.setValue(backgroundColor);
    }
    
    public void setOriginBackground(Paint originbackground) {
    	this.originBackground.setValue(originbackground);
    }
    
    public boolean getIsOn() {
    	return isOn.getValue();
    }
    
    public void setIsOn(boolean isOn) {
		this.isOn.setValue(isOn);
		
		if(isOn) {
			transition.setToX(45-15);
			transition.play();
			setBackgroundColor(Paint.valueOf("#005A9C"));
		} else {
			transition.setToX(0);
			transition.play();
			setBackgroundColor(originBackground.getValue());
		}
	}
    
    public void switchState() {
		setIsOn(!isOn.getValue());
	}
    
    public BooleanProperty onProperty() {
    	return isOn;
    }
}
