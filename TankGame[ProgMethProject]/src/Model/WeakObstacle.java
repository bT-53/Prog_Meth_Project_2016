package Model;

import javafx.scene.canvas.GraphicsContext;

public class WeakObstacle extends Entity{
	
	public WeakObstacle(int x, int y) {
		super(1, x, y); //is destroyed in one hit, effects with WeakOvstacle
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		
	}
	
	@Override
	public void hit(int dmg) {
		hp = 0;
	}
}
