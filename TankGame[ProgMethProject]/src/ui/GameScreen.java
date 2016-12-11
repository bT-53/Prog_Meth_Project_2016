package ui;

import java.util.List;

import Logic.GameManager;
import Model.ATKItem;
import Model.ATKSpeedItem;
import Model.Bullet;
import Model.BulletItem;
import Model.Entity;
import Model.IRenderable;
import Model.IRenderableHolder;
import Model.Player;
import Model.Pond;
import Model.SpeedItem;
import Model.StrongObstacle;
import Model.WeakObstacle;
import Utility.GameUtility;
import Utility.InputUtility;
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
	private Player player1, player2;
	private static int frameWidth, frameHeight;
	private static int maxWidth = 1920 ; 
	private static int maxHeight = 1160;
	private int[] currentX, currentY , speed;
	
	public GameScreen(){
		super();
		currentX = new int[2];
		currentY = new int[2];

		speed = new int[2];
		this.setPrefSize(1150, 600);
		frameHeight = 500;
		frameWidth = 500;
		
		player2 = new Player("SA",400,300,GameUtility.UP); 
		IRenderableHolder.getInstance().addEntity(player2);
		player1 = new Player("Natty", 250, 250,GameUtility.UP);
		IRenderableHolder.getInstance().addEntity(player1);
		IRenderableHolder.getInstance().addEntity(new Pond(100,150));
		IRenderableHolder.getInstance().addEntity(new WeakObstacle(100,100));
		IRenderableHolder.getInstance().addEntity(new Bullet(player1,300,300));
		IRenderableHolder.getInstance().addEntity(new ATKItem(250,300));
		IRenderableHolder.getInstance().addEntity(new SpeedItem(150,300));
		IRenderableHolder.getInstance().addEntity(new ATKSpeedItem(350,300));
		IRenderableHolder.getInstance().addEntity(new BulletItem(50,300));
		
		for(int y = -20; y <= 1180; y += 40){
			if(y == -20 || y == 1180){
				for(int x = 20; x <= 1900; x += 40){
					IRenderableHolder.getInstance().addEntity(new StrongObstacle(x,y));
				}
			}else{
				IRenderableHolder.getInstance().addEntity(new StrongObstacle(-20,y));
				IRenderableHolder.getInstance().addEntity(new StrongObstacle(1940,y));
			}
		}
		findPlayer();
		
		System.out.println(player1.getName()+player2.getName());
		System.out.println(currentX[0] + " "+ currentX[1]);

		
		this.bg = IRenderableHolder.bg;
		
		System.out.println(bg.getHeight()+" "+bg.getWidth());
		this.canvas = new Canvas(1150,600);
		canvas.setVisible(true);			
		
		
		this.getChildren().add(canvas);
		
	}
	
	public void update(){
		frameUpdate(player1,0);
		frameUpdate(player2,1);
		
		if(InputUtility.getKeyDown1()){
			player1.setDirection(GameUtility.DOWN);
			player1.move();
		}
		else if(InputUtility.getKeyLeft1()){
			player1.setDirection(GameUtility.LEFT);
			player1.move();
		}
		else if(InputUtility.getKeyRight1()){
			player1.setDirection(GameUtility.RIGHT);
			player1.move();
		}
		else if(InputUtility.getKeyUp1()){
			player1.setDirection(GameUtility.UP);
			player1.move();
		}
		if(InputUtility.getKeyDown2()){
			player2.setDirection(GameUtility.DOWN);
			player2.move();
		}
		else if(InputUtility.getKeyLeft2()){
			player2.setDirection(GameUtility.LEFT);
			player2.move();
		}
		else if(InputUtility.getKeyRight2()){
			player2.setDirection(GameUtility.RIGHT);
			player2.move();
		}
		else if(InputUtility.getKeyUp2()){
			player2.setDirection(GameUtility.UP);
			player2.move();
		}
		if(InputUtility.getKeyShoot1()){
			player1.attack();	
		}
		if(InputUtility.getKeyShoot2()){
			player2.attack();
		}
		List<IRenderable> entities = IRenderableHolder.getInstance().getEntities();
		for (int i = entities.size()-1; i>=0; i--) {
			if (entities.get(i) instanceof Bullet) {
				((Bullet) entities.get(i)).move();
			}
		}
		GameManager.checkCollision();
		for (int i = entities.size()-1; i>=0; i--) {
			if (entities.get(i).isDestroyed()) {
				entities.remove(i);
			}
		}
	}
	
	public void keyPressed(KeyCode code) {
		// TODO Auto-generated method stub
		if(code.toString().equals("UP")){
			InputUtility.setKeyUp1(true);
		}else if(code.toString().equals("DOWN")){
			InputUtility.setKeyDown1(true);
		}else if(code.toString().equals("RIGHT")){
			InputUtility.setKeyRight1(true);
		}else if(code.toString().equals("LEFT")){
			InputUtility.setKeyLeft1(true);
		}
		if(code.toString().equals("W")){
			InputUtility.setKeyUp2(true);
		}else if(code.toString().equals("S")){
			InputUtility.setKeyDown2(true);
		}else if(code.toString().equals("D")){
			InputUtility.setKeyRight2(true);
		}else if(code.toString().equals("A")){
			InputUtility.setKeyLeft2(true);
		}
		if(code.toString().equals("ENTER")){
			InputUtility.setKeyShoot1(true);
		}
		if(code.toString().equals("SPACE")){
			InputUtility.setKeyShoot2(true);
		}
	}
	
	public void keyReleased(KeyCode code){
		if(code.toString().equals("UP")){
			InputUtility.setKeyUp1(false);
		}else if(code.toString().equals("DOWN")){
			InputUtility.setKeyDown1(false);
		}else if(code.toString().equals("RIGHT")){
			InputUtility.setKeyRight1(false);
		}else if(code.toString().equals("LEFT")){
			InputUtility.setKeyLeft1(false);
		}
		if(code.toString().equals("W")){
			InputUtility.setKeyUp2(false);
		}else if(code.toString().equals("S")){
			InputUtility.setKeyDown2(false);
		}else if(code.toString().equals("D")){
			InputUtility.setKeyRight2(false);
		}else if(code.toString().equals("A")){
			InputUtility.setKeyLeft2(false);
		}
		if(code.toString().equals("ENTER")){
			InputUtility.setKeyShoot1(false);
		}
		if(code.toString().equals("SPACE")){
			InputUtility.setKeyShoot2(false);
		}
	}
	
	public void frameUpdate(Player player,int frameNuber){
		int newX = currentX[frameNuber];
		int newY = currentY[frameNuber];
		newX = player.getX() - 250;
		newY = player.getY() - 250;
		if(newX >= 0 && newX + frameWidth <= maxWidth){
			currentX[frameNuber] = newX;
		}
		if(newY >= 0 && newY + frameHeight <= maxHeight){
			currentY[frameNuber] = newY;
		}
	}
	
	public void paintComponenet(){
		GraphicsContext gc = this.canvas.getGraphicsContext2D();
		gc.clearRect(0, 0, 1150, 600);
		paintFrame1(gc);
		paintFrame2(gc);
		paintUI(gc);
//		System.out.println(""+currentX[1]+" "+currentX[0]);
//		gc.setFill(Color.BEIGE);
//		gc.fillRect(500, 0, 10, 500);
//		gc.fillRect(235, 235, 30, 30);
//		gc.fillOval(270, 270, 12, 12);
		
		
	}
	
	public void paintFrame1(GraphicsContext gc){ //draw frame1
		WritableImage shownFrame1 = new WritableImage(bg.getPixelReader(), currentX[0], currentY[0],frameWidth , frameHeight);
		gc.drawImage(shownFrame1, 600, 50);
		for(IRenderable r : IRenderableHolder.getInstance().getEntities()){
			Entity p = (Entity)r;
			
			if(isInFrame(p.getX(), p.getY(), currentX[0], currentY[0])){
				int x = 600 + p.getX() - currentX[0];
				int y = 50 +  p.getY() - currentY[0];
				p.draw(gc, x, y);
			}
		}
	}
	
	public void paintFrame2(GraphicsContext gc){//draw frame2
		WritableImage shownFrame2 = new WritableImage(bg.getPixelReader(), currentX[1], currentY[1],frameWidth , frameHeight);
		gc.drawImage(shownFrame2, 50, 50);
		for(IRenderable r : IRenderableHolder.getInstance().getEntities()){
			Entity p = (Entity)r;
			
			if(isInFrame(p.getX(), p.getY(), currentX[1], currentY[1])){
				int x = 50 + p.getX() - currentX[1];
				int y = 50 +  p.getY() - currentY[1];
				p.draw(gc, x, y);
			}
		}
	}
	
	public void paintUI(GraphicsContext gc){
		gc.setFill(Color.BLUE);
		gc.fillRect(0, 0, 1150, 50);
		gc.setStroke(Color.AZURE);
		gc.setLineWidth(10);
		gc.strokeRect(0, 0, 1150, 50);
		gc.setFill(Color.LEMONCHIFFON);
		gc.fillRect(0, 55, 50, 500);
		gc.fillRect(550, 55, 50, 500);
		gc.fillRect(1100, 55, 50, 500);
		gc.fillRect(0, 550, 1150, 50);
	}
	
	public void findPlayer(){ //use to find player and capture in the frame
		int i = 0;
		for(IRenderable r : IRenderableHolder.getInstance().getEntities()){
			
			if(r instanceof Player){
				Player p = (Player) r;
				currentX[i] = p.getX()-250;
				currentY[i] = p.getY()-250;
				speed[i] = p.getSpeed();
				
				if(currentX[i] < 0) currentX[i] = 0;
				else if(currentX[i] + 500 > 1920) currentX[i] = 1920 - 500;
				if(currentY[i] < 0) currentY[i] = 0;
				else if(currentY[i] + 500 > 1138 ) currentY[i] = 1138 - 500;
				
				if(i == 0){
					player1 = p;
				}else if(i == 1){
					player2 = p;
				}
				i++;
			}
		}
	}
	
	public boolean isInFrame(int x, int y, int currentX, int currentY){
		if(x - currentX + 20 < 0 || x - currentX - 20 > 500) return false;
		else if(y - currentY +20 < 0 || y - currentY -20 > 500) return false;
		return true;
	}

	
	
	
}