package ui;

import java.util.List;

import Logic.GameManager;
import Main.Main;
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
import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;


public class GameScreen extends StackPane{
	
	private Canvas canvas;
	private Image bg;
	private Player player1, player2;
	private static int frameWidth = 500;
	private static int frameHeight = 500;
	private static int maxWidth = 1920 ; 
	private static int maxHeight = 1160;
	private int[] currentX, currentY , speed;
	
	public GameScreen(){
		super();
		currentX = new int[2];
		currentY = new int[2];
		speed = new int[2];
		this.setPrefSize(GameUtility.GAMESCREEN_WIDTH, GameUtility.GAMESCREEN_HEIGHT);
		
		
		player2 = new Player("SA",400,300,GameUtility.UP); 
		IRenderableHolder.getInstance().addEntity(player2);
		player1 = new Player("Natty", 250, 250,GameUtility.UP);
		IRenderableHolder.getInstance().addEntity(player1);
		IRenderableHolder.getInstance().addEntity(new Pond(100,150));
		IRenderableHolder.getInstance().addEntity(new WeakObstacle(100,100));
		IRenderableHolder.getInstance().addEntity(new ATKItem(250,300));
		IRenderableHolder.getInstance().addEntity(new SpeedItem(150,300));
		IRenderableHolder.getInstance().addEntity(new ATKSpeedItem(350,300));
		IRenderableHolder.getInstance().addEntity(new BulletItem(50,300));
		
		for(int y = -20; y <= maxHeight + 20; y += 40){
			if(y == -20 || y == maxHeight +20){
				for(int x = 20; x <= maxWidth - 20; x += 40){
					IRenderableHolder.getInstance().addEntity(new StrongObstacle(x,y));
				}
			}else{
				IRenderableHolder.getInstance().addEntity(new StrongObstacle(-20,y));
				IRenderableHolder.getInstance().addEntity(new StrongObstacle(maxWidth +20,y));
			}
		}
		findPlayer();
		
		System.out.println(player1.getName()+player2.getName());
		System.out.println(currentX[0] + " "+ currentX[1]);

		this.bg = IRenderableHolder.bg;
		
		System.out.println(bg.getHeight()+" "+bg.getWidth());
		this.canvas = new Canvas(GameUtility.GAMESCREEN_WIDTH, GameUtility.GAMESCREEN_HEIGHT);
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
			if(!InputUtility.getTriggeredKeyShoot1()){
				InputUtility.setTriggeredKeyShoot1(true);
				player1.attack();
			}
		}
		if(InputUtility.getKeyShoot2()){
			if(!InputUtility.getTriggeredKeyShoot2()){
				InputUtility.setTriggeredKeyShoot2(true);
				player2.attack();
			}
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
		
		Platform.runLater(()->{
			if (player1.isDestroyed() && player2.isDestroyed()) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("GAME END!!");
				alert.setHeaderText(null);
				alert.setContentText("DRAW");
				Main.instance.animation.stop();
				alert.showAndWait();
			}
			else if (player1.isDestroyed()) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("GAME END!!");
				alert.setHeaderText(null);
				alert.setContentText(player2.getName() + " WINS");
				Main.instance.animation.stop();
				alert.showAndWait();
			}
			else if (player2.isDestroyed()) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("GAME END!!");
				alert.setHeaderText(null);
				alert.setContentText(player1.getName() + " WINS");
				Main.instance.animation.stop();
				alert.showAndWait();
			}
		});
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
			InputUtility.setTriggeredKeyShoot1(false);
		}
		if(code.toString().equals("SPACE")){
			InputUtility.setKeyShoot2(false);
			InputUtility.setTriggeredKeyShoot2(false);
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
		gc.clearRect(0, 0, GameUtility.GAMESCREEN_WIDTH, GameUtility.GAMESCREEN_HEIGHT);
		paintFrame1(gc);
		paintFrame2(gc);
		paintUI(gc);

	}
	
	private void paintFrame1(GraphicsContext gc){ //draw frame1 the right frame
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
	
	private void paintFrame2(GraphicsContext gc){//draw frame2 the left frame
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
	
	private void paintUI(GraphicsContext gc){
		gc.setFill(Color.LEMONCHIFFON);
		gc.fillRect(0, 0, 1150, 50);
		gc.fillRect(0, 50, 50, 500);
		gc.fillRect(550, 50, 50, 500);
		gc.fillRect(1100, 50, 50, 500);
		gc.fillRect(0, 550, 1150, 50);
	}
	
	public void findPlayer(){ //use to find player and capture in the frame
		int i = 0;
		for(IRenderable r : IRenderableHolder.getInstance().getEntities()){
			
			if(r instanceof Player){
				Player p = (Player) r;
				currentX[i] = p.getX()- frameWidth/2;
				currentY[i] = p.getY()- frameHeight/2;
				speed[i] = p.getSpeed();
				
				if(currentX[i] < 0) currentX[i] = 0;
				else if(currentX[i] + frameWidth > maxWidth) currentX[i] = maxWidth - frameWidth;
				if(currentY[i] < 0) currentY[i] = 0;
				else if(currentY[i] + frameHeight > maxHeight ) currentY[i] = maxHeight - frameHeight;
				
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
		if(x - currentX + 20 < 0 || x - currentX - 20 > frameWidth) return false;
		else if(y - currentY +20 < 0 || y - currentY -20 > frameHeight) return false;
		return true;
	}

	
	
	
}