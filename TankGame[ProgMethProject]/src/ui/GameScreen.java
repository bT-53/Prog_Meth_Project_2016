package ui;

import Model.IRenderable;
import Model.IRenderableHolder;
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
	private int currentX, currentY,speed,directionX, directionY;
	private static int frameWidth, frameHeight;
	private static int maxWidth = 1920 ; 
	private static int maxHeight = 1138;
	private int currentX2, currentY2,speed2,directionX2, directionY2;
	
	
	public GameScreen(){
		super();
		this.setPrefSize(1010, 500);
		this.currentX = 100;
		this.currentY = 100;
		this.speed = 5;
		this.directionX = 0;
		this.directionY = 0;
		frameHeight = 500;
		frameWidth = 500;
		this.currentX2 = 500;
		this.currentY2 = 500;
		this.speed2 = 5;
		this.directionX2 = 0;
		this.directionY2 = 0;
		
		this.bg = IRenderableHolder.bg;
		
		System.out.println(bg.getHeight()+" "+bg.getWidth());
		this.canvas = new Canvas(1010,500);
		canvas.setVisible(true);			
		
		
		this.getChildren().add(canvas);
		
	}
	
	public void update(){
		int newX = currentX;
		int	newY = currentY;
		if(directionX == 0 && directionY == 0)return;
		else if(directionX == 1)newX += speed;
		else if(directionX == -1)newX -= speed;
		else if(directionY == 1)newY += speed;
		else if(directionY == -1)newY -= speed;
		
		
		if(newX + frameWidth <= maxWidth && newX >= 0){
			currentX = newX;
			System.out.println(currentX);
		}
		if(newY + frameHeight <= maxHeight && newY >= 0){
			currentY = newY;
			System.out.println(currentY);
		}
	}
	
	public void keyPressed(KeyCode k, boolean pressed){
		String keycode = k.toString();
		if(keycode.equals("UP")){
			this.directionX = 0;
			this.directionY = -1;
		}else if(keycode.equals("DOWN")){
			this.directionX = 0;
			this.directionY = 1;
		}else if(keycode.equals("RIGHT")){
			this.directionX = 1;
			this.directionY = 0;
		}else if(keycode.equals("LEFT")){
			this.directionX = -1;
			this.directionY = 0;
		}
	}
	
	public void keyReleased(KeyCode k, boolean released){
		this.directionX = 0;
		this.directionY = 0;
	}
	
	public void paintComponenet(){
		GraphicsContext gc = this.canvas.getGraphicsContext2D();
//		gc.setFill(Color.BLACK);
//		gc.clearRect(0, 0, this.canvas.getWidth(), this.canvas.getHeight());
//		gc.fillRect(0, 0, this.canvas.getWidth(), this.canvas.getHeight());
		
		
		gc.clearRect(0, 0, 1010, 500);
		WritableImage shownFrame1 = new WritableImage(bg.getPixelReader(), currentX, currentY,frameWidth , frameHeight);
		WritableImage shownFrame2 = new WritableImage(bg.getPixelReader(), currentX2, currentY2,frameWidth , frameHeight);
		gc.drawImage(shownFrame1, 0,0);
		gc.drawImage(shownFrame2, 510, 0);
		gc.setFill(Color.BEIGE);
		gc.fillRect(500, 0, 10, 500);
		gc.fillRect(235, 235, 30, 30);
		
		for(IRenderable renderable : IRenderableHolder.getInstance().getEntities()){
			renderable.draw(gc);
		}
	}
	
}
