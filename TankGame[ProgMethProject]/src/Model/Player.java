package Model;

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
	public void hit() {
		
	}
	
	@Override
	public void move() {
		
	}
	
	@Override
	public void rotate(int dir) {
		
	}
	
	public void attack() { // shoot the bullet
		
	}
	
	public int getHP() {
		return hp;
	}
	
	public void increaseHP(int incHP) {
		hp += incHP;
	}
}
