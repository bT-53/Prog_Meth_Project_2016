package Model;

import Utility.GameUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Bullet extends Entity implements Movable{
	public final static int WIDTH = 10;
	public final static int HEIGHT = 10;
	protected Player owner;
	int damage;
	int speed;
	int direction;
	
	public Bullet(Player player, int x, int y, int direction, int atkSpeed, int atk) {
		super(1, x, y);
		this.owner = player;
		damage = atk;
		this.direction = direction;
		speed = atkSpeed;
	}
	
	@Override
	public void draw(GraphicsContext gc, int x, int y ) {
		gc.setFill(Color.YELLOW);
		gc.fillOval(x - WIDTH/2 , y - HEIGHT/2, WIDTH, HEIGHT);
	}
	
	@Override
	public void hit(int dmg) {
		hp = 0;
	}
	
	@Override
	public void move() {
		x += GameUtility.DIR_X[direction] * speed;
		y += GameUtility.DIR_Y[direction] * speed;
	}
	
	@Override
	public void rotate(int dir) {
		//can't roate
	}
	
	public int getDamage() {
		return damage;
	}
	
	public int getSpeed() {
		return speed;
	}
}
