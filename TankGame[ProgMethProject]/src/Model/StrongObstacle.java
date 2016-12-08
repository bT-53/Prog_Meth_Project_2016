package Model;

import javafx.scene.canvas.GraphicsContext;

public class StrongObstacle extends Entity {
	
	public StrongObstacle(int x, int y) {
		super(100, x, y); //hp is no meaning in this case
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		
	}
	
	@Override
	public boolean isDestroyed() {
		return false;
	}
	
	@Override
	public void hit(int dmg) {
		//nothing happened
	}
	
}
