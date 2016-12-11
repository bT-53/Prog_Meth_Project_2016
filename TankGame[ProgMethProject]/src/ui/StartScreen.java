package ui;

import Main.Main;
import Utility.GameUtility;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class StartScreen extends StackPane{
	private Button startButton;
	private Canvas canvas;
	public StartScreen(){
		super();
		this.setVisible(true);
		
		initializeGUI();
		
		addListener();
		
	}
	
	public void addListener(){
		startButton.setOnAction((ActionEvent e) -> {
			Main.instance.ChangeScene();
		});
	}
	
	public void initializeGUI(){
		this.setPrefSize(GameUtility.GAMESCREEN_WIDTH, GameUtility.GAMESCREEN_HEIGHT);
		this.setAlignment(Pos.CENTER);
		
		startButton = new Button("Start");
		startButton.setAlignment(Pos.CENTER);
		
		canvas = new Canvas();
		
		this.getChildren().add(canvas);
		this.getChildren().add(startButton);
	}

}
