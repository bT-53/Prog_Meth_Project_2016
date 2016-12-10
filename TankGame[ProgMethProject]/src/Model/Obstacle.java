package Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Obstacle extends Entity {
	public final static int WIDTH = 40;
	public final static int HEIGHT = 40;
	public Obstacle(int x, int y) {
		super(1, x, y);
	}
	
	@Override
	public void hit(int dmg) {
		//nothing happen
	}
	
	@Override
	public void draw(GraphicsContext gc, int x, int y ) {
		gc.setFill(Color.GRAY);
		gc.fillOval(x - WIDTH/2 , y - HEIGHT/2, WIDTH, HEIGHT);
	}
	
	@Override
	public boolean isDestroyed() {
		return false;
	}
}
