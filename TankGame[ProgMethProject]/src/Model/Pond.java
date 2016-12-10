package Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Pond extends Obstacle implements BulletPassable {
	
	public Pond(int x, int y) {
		super(x, y);
	}
	
	@Override
	public int getZ() {
		return 0;
	}
	
	@Override
	public void draw(GraphicsContext gc, int x, int y ) {
		gc.setFill(Color.BLUE);
		gc.fillOval(x - WIDTH/2 , y - HEIGHT/2, WIDTH, HEIGHT);
	}
}
