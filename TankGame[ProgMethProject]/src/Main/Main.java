package Main;

import Logic.GameManager;
import Utility.GameUtility;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import ui.GameScreen;
import ui.StartScreen;

public class Main extends Application{
	public static Main instance;
	private Stage primaryStage;
	private Scene startScene;
	private Scene gameScene;
	
	private StartScreen startScreen;
	private GameScreen gameScreen ;
	public AnimationTimer animation;
	
	private boolean isGameSceneShown = false;
	
	public static void main(String args[]) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		// TODO: ...
		instance = this;
		this.primaryStage = primaryStage;
		gameScreen = new GameScreen();
		
		gameScene = new Scene(gameScreen,GameUtility.GAMESCREEN_WIDTH, GameUtility.GAMESCREEN_HEIGHT);	
		startScreen = new StartScreen();
		startScene = new Scene(startScreen,GameUtility.GAMESCREEN_WIDTH, GameUtility.GAMESCREEN_HEIGHT);
		

		gameScene.setOnKeyPressed((KeyEvent e) ->{
			System.out.println(e.getCode().toString());
			gameScreen.keyPressed(e.getCode());
		});
		
		
		gameScene.setOnKeyReleased((KeyEvent e) ->{
			System.out.println("           "+e.getCode().toString());
			gameScreen.keyReleased(e.getCode());
		});
		
		animation = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				gameScreen.update();
				gameScreen.paintComponenet();
			}
		};
		
		primaryStage.setScene(startScene);
		primaryStage.sizeToScene();
		primaryStage.show();
		
	}
	
	public synchronized void ChangeScene(){
		if (this.isGameSceneShown){
			this.primaryStage.setScene(startScene);
			System.out.println("To Config Screen");
		}
		else{
			this.primaryStage.setScene(gameScene);
			animation.start();
			System.out.println("To Game Screen");
		}
		this.isGameSceneShown = !this.isGameSceneShown;
	} 
	
}
