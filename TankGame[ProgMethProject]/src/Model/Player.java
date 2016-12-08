package Model;

import Logic.GameManager;
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
		direction += dir;
		if (direction >= 4) {
			direction -= 4;
		}
		else if (direction < 0) {
			direction += 4;
		}
	}
	
	public void attack() { // shoot the bullet
		if (bulletsLimit == 0) {
			return;
		}
		bulletsLimit--;
		Bullet bullet = new Bullet(this, x, y, direction);
		IRenderableHolder.instance.addEntity(bullet);
	}
	
	public void increaseBullets() {
		bulletsLimit++;
	}
	
	public int getHP() {
		return hp;
	}
	
	public void increaseHP(int addHP) {
		hp += addHP;
	}
}
