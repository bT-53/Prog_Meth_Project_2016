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
		gameScene = new Scene(gameScreen,1010,500);	
//		Canvas canvas = new Canvas(1010,500);
//		GridPane root = new GridPane();
//		root.add(canvas, 0, 0);
//		Scene scene = new Scene(root,1010,500);
		
		

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
				GameManager.checkCollision();
				gameScreen.paintComponenet();
//				GraphicsContext gc = canvas.getGraphicsContext2D();
//				gc.setFill(Color.BLACK);
//				gc.fillRect(0, 0, 500, 500);
//				gc.fillRect(510, 0, 500, 500);
//				gc.setFill(Color.WHITE);
//				gc.fillRect(235, 235, 30, 30);
//				gc.drawImage(bg, 0, 0);
				
				
			}
		};
		animation.start();
		

		primaryStage.setScene(gameScene);
		primaryStage.sizeToScene();
		primaryStage.show();
		
	}
	
	
	
	
	
}