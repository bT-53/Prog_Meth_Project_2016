package Model;

import Utility.GameUtility;
import javafx.scene.canvas.GraphicsContext;

public class Player extends Entity implements Movable{
	
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
		speed = 1;
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		
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
	
	public int getBUllets() {
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
	
	public int getDirection() {
		return direction;
	}
}
