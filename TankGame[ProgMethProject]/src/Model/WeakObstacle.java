package Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class WeakObstacle extends Obstacle{
	
	public WeakObstacle(int x, int y) {
		super(x, y);
	}
	
	@Override
	public void draw(GraphicsContext gc, int x, int y) {
		gc.setFill(Color.BROWN);
		gc.fillOval(x - WIDTH/2 , y - HEIGHT/2, WIDTH, HEIGHT);
	}
	
	@Override
	public void hit(int dmg) {
		hp -= dmg;
	}
	
	@Override
	public boolean isDestroyed() {
		return hp <= 0;
	}
	
}
