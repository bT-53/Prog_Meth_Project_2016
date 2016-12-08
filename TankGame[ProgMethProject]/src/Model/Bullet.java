package Model;

import Utility.GameUtility;
import javafx.scene.canvas.GraphicsContext;

public class Bullet extends Entity implements Movable{
	
	private Player owner;
	private int damage;
	private int speed;
	private int direction;
	
	public Bullet(Player player, int x, int y, int direction) {
		super(1, x, y);
		this.owner = player;
		damage = 1;
		this.direction = direction;
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		
	}
	
	@Override
	public void hit(int dmg) {
		hp = 0;
		owner.increaseBullets();
	}
	
	@Override
	public void move() {
		x += GameUtility.DIR_X[direction] * speed;
		y += GameUtility.DIR_Y[direction] * speed;
	}
	
	@Override
	public void rotate(int dir) {
		// can't rotate
	}
}
