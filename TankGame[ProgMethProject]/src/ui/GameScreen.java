package ui;

import Model.Entity;
import Model.IRenderable;
import Model.IRenderableHolder;
import Model.Player;
import Utility.GameUtility;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;


public class GameScreen extends StackPane{
	
	private Canvas canvas;
	private Image bg;
//	private int currentX, currentY,speed,directionX, directionY;
	private static int frameWidth, frameHeight;
	private static int maxWidth = 1920 ; 
	private static int maxHeight = 1138;
//	private int currentX2, currentY2,speed2,directionX2, directionY2;
	private int[] currentX, currentY , directionX , directionY, speed;
	
	public GameScreen(){
		super();
		currentX = new int[2];
		currentY = new int[2];
		directionX = new int[2];
		directionY = new int[2];
		speed = new int[2];
		this.setPrefSize(1010, 500);
		this.currentX[0] = 100;
		this.currentY[0] = 100;
		this.speed[0] = 5;
		this.directionX[0] = 0;
		this.directionY[0] = 0;
		frameHeight = 500;
		frameWidth = 500;
		this.currentX[1] = 500;
		this.currentY[1] = 500;
		this.speed[1] = 5;
		this.directionX[1] = 0;
		this.directionY[1] = 0;
		Player player1 = new Player("Natty", 250, 250,GameUtility.UP);
		IRenderableHolder.getInstance().addEntity(player1);
		Player player2 = new Player("SA",900,900,GameUtility.UP); 
		IRenderableHolder.getInstance().addEntity(player2);
		

		
		this.bg = IRenderableHolder.bg;
		
		System.out.println(bg.getHeight()+" "+bg.getWidth());
		this.canvas = new Canvas(1010,500);
		canvas.setVisible(true);			
		
		
		this.getChildren().add(canvas);
		
	}
	
	public void update(){
		int newX = currentX[0];
		int	newY = currentY[0];
		if(directionX[0] == 0 && directionY[0] == 0)return;
		else if(directionX[0] == 1)newX += speed[0];
		else if(directionX[0] == -1)newX -= speed[0];
		else if(directionY[0] == 1)newY += speed[0];
		else if(directionY[0] == -1)newY -= speed[0];
		
		
		if(newX + frameWidth <= maxWidth && newX >= 0){
			currentX[0] = newX;
			System.out.println(currentX);
		}
		if(newY + frameHeight <= maxHeight && newY >= 0){
			currentY[0] = newY;
			System.out.println(currentY);
		}
	}
	
	public void keyPressed(KeyCode k, boolean pressed){
		String keycode = k.toString();
		if(keycode.equals("UP")){
			this.directionX[0] = 0;
			this.directionY[0] = -1;
		}else if(keycode.equals("DOWN")){
			this.directionX[0] = 0;
			this.directionY[0] = 1;
		}else if(keycode.equals("RIGHT")){
			this.directionX[0] = 1;
			this.directionY[0] = 0;
		}else if(keycode.equals("LEFT")){
			this.directionX[0] = -1;
			this.directionY[0] = 0;
		}
	}
	
	public void keyReleased(KeyCode k, boolean released){
		this.directionX[0] = 0;
		this.directionY[0] = 0;
	}
	
	public void paintComponenet(){
		GraphicsContext gc = this.canvas.getGraphicsContext2D();
		gc.clearRect(0, 0, 1010, 500);
		WritableImage shownFrame1 = new WritableImage(bg.getPixelReader(), currentX[0], currentY[0],frameWidth , frameHeight);
		WritableImage shownFrame2 = new WritableImage(bg.getPixelReader(), currentX[1], currentY[1],frameWidth , frameHeight);
		gc.drawImage(shownFrame1, 0,0);
		gc.drawImage(shownFrame2, 510, 0);
		gc.setFill(Color.BEIGE);
		gc.fillRect(500, 0, 10, 500);
		gc.fillRect(235, 235, 30, 30);
		
		
	}
	
//	public void findPlayer(){ //use to find player and capture in the frame
//		for(IRenderable r : IRenderableHolder.getInstance().getEntities()){
//			int i = 0;
//			if(r instanceof Player){
//				Player p = (Player) r;
//				currentX[i] = p.getX()-250;
//				currentY[i] = p.getY()-250;
//				speed[i] = p.getSpeed();
//				i++;
//			}
//		}
//	}
	
}
