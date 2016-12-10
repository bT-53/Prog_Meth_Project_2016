package Model;

import javafx.scene.canvas.GraphicsContext;

public class WeakObstacle extends Obstacle{
	
	public WeakObstacle(int x, int y) {
		super(x, y);
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		
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
