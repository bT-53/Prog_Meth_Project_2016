package ui;

import Main.Main;
import Utility.GameUtility;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class StartScreen extends GridPane{
	private Button startButton;
	
	public StartScreen(){
		super();
		this.setVisible(true);
		this.setPrefSize(GameUtility.GAMESCREEN_WIDTH, GameUtility.GAMESCREEN_HEIGHT);
		this.setAlignment(Pos.CENTER);
		startButton = new Button("Start");
		startButton.setAlignment(Pos.CENTER);
		this.add(startButton, 0, 0);
		addListener();
		
	}
	
	public void addListener(){
		startButton.setOnAction((ActionEvent e) -> {
			Main.instance.ChangeScene();
		});
	}

}