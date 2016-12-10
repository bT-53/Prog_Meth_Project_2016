package Model;

import javafx.scene.canvas.GraphicsContext;

public class Obstacle extends Entity {
	
	public Obstacle(int x, int y) {
		super(1, x, y);
	}
	
	@Override
	public void hit(int dmg) {
		//nothing happen
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		
	}
	
	@Override
	public boolean isDestroyed() {
		return false;
	}
}
