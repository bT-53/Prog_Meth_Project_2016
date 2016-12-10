package Model;

import Utility.GameUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Player extends Entity implements Movable{
	public final static int WIDTH = 30;
	public final static int HEIGHT = 30;
	private String name;
	private int atk, atkspeed;
	private int bulletsLimit;
	private int speed;
	private int direction;
	private Color gunColor, tankColor;
	
	public Player(String name, int x, int y,int direction) {
		super(10, x, y); // 10 is now initial HP
		this.name = name;
		this.direction = direction;
		atk = 1;
		atkspeed = 2;
		bulletsLimit = 1;
		speed = 3;
		this.tankColor = Color.BLUE;
		this.gunColor = Color.RED;
	}
	
	public Player(String name, int x, int y,int direction, Color tankColor, Color gunColor) {
		super(10, x, y); // 10 is now initial HP
		this.name = name;
		this.direction = direction;
		atk = 1;
		atkspeed = 2;
		bulletsLimit = 1;
		speed = 3;
		this.tankColor = tankColor;
		this.gunColor = gunColor;
	}
	
	@Override
	public void draw(GraphicsContext gc, int x, int y) {
		gc.setFill(this.tankColor);
		gc.fillRect(x - WIDTH/2 , y - HEIGHT/2, 30, 30);
		drawGun(gc, x, y);
		drawWheel(gc, x, y);
	}
	
	public void drawGun(GraphicsContext gc, int x, int y){
		gc.setFill(this.gunColor);
		gc.fillOval(x - 7.5, y - 7.5, 16, 16);
		if(direction == GameUtility.UP){
			gc.fillRect(x - 4 , y - 20, 8, 20);
		}else if(direction == GameUtility.RIGHT){
			gc.fillRect(x, y-4, 20, 8);
		}else if(direction == GameUtility.DOWN){
			gc.fillRect(x - 4, y, 8, 20);
		}else if(direction == GameUtility.LEFT){
			gc.fillRect(x - 20, y - 4 , 20, 8);
		}
	}
	
	public void drawWheel(GraphicsContext gc, int x, int y){
		gc.setLineWidth(1);
		gc.setStroke(Color.AZURE);
		if(direction == GameUtility.UP || direction == GameUtility.DOWN){
			gc.strokeRect(x - WIDTH/2, y- HEIGHT/2, 4, HEIGHT);
			gc.strokeRect(x + WIDTH/2 - 4, y - HEIGHT/2, 4 , HEIGHT);
		}else if(direction == GameUtility.RIGHT || direction == GameUtility.LEFT){
			gc.strokeRect(x - WIDTH/2, y - HEIGHT/2, WIDTH, 4);
			gc.strokeRect(x - WIDTH/2d, y + HEIGHT/2 - 4, WIDTH , 4);
		}
	}
	
	@Override
	public void move() {
		x += GameUtility.DIR_X[direction] * speed;
		y += GameUtility.DIR_Y[direction] * speed;
	}
	
	@Override
	public void rotate(int dir) {
		direction = dir;
	}
	
	public void attack() { // shoot the bullet
		Bullet bullet = new Bullet(this, x, y, direction, atkspeed, atk);
		IRenderableHolder.getInstance().addEntity(bullet);
	}
	
	public int getHP() {
		return hp;
	}
	
	public void increaseHP(int addHP) {
		hp += addHP;
	}
	
	public int getATK() {
		return atk;
	}
	
	public void increaseATK(int addATK) {
		atk += addATK;
	}
	
	public int getBullets() {
		return bulletsLimit;
	}
	
	public void increaseBullets() {
		bulletsLimit++;
	}
	
	public int getATKSpeed() {
		return atkspeed;
	}
	
	public void increaseATKSpedd(int addATKSpeed) {
		atkspeed += addATKSpeed;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void increaseSpeed(int addSpeed) {
		speed += addSpeed;
	}
	
	public String getName(){
		return name;
	}
	
	public void setDirection(int direction){
		this.direction = direction;
	}
	
	public int getDirection(){
		return direction;
	}
}
