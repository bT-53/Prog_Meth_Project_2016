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
	
	public Player(String name, int x, int y,int direction) {
		super(10, x, y); // 10 is now initial HP
		this.name = name;
		this.direction = direction;
		atk = 1;
		atkspeed = 2;
		bulletsLimit = 1;
		speed = 5;
	}
	
	@Override
	public void draw(GraphicsContext gc, int x, int y) {
		gc.setFill(Color.BLUE);
		gc.fillRect(x - WIDTH/2 , y - HEIGHT/2, 30, 30);
		gc.setFill(Color.RED);
		gc.fillOval(x - 7.5, y - 7.5, 16, 16);
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
		Bullet bullet = new Bullet(this, x, y, direction);
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
