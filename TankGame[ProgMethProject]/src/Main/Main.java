package Main;

import Logic.GameManager;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import ui.GameScreen;

public class Main extends Application{
	private GameScreen gameScreen ;
	private Scene gameScene;
	
	public static void main(String args[]) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		// TODO: ...
		
		gameScreen = new GameScreen();
		gameScene = new Scene(gameScreen,1150,600);	

		
		

		gameScene.setOnKeyPressed((KeyEvent e) ->{
			System.out.println(e.getCode().toString());
			gameScreen.keyPressed(e.getCode());
		});
		
		
		gameScene.setOnKeyReleased((KeyEvent e) ->{
			System.out.println("           "+e.getCode().toString());
			gameScreen.keyReleased(e.getCode());
		});
		
		AnimationTimer animation = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				gameScreen.update();
				gameScreen.paintComponenet();

			}
		};
		animation.start();
		

		primaryStage.setScene(gameScene);
		primaryStage.sizeToScene();
		primaryStage.show();
		
	}
	
	
	
	
	
}