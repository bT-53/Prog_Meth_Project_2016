package Model;

import javafx.scene.canvas.GraphicsContext;

public class SpeedItem extends Item{
	
	public SpeedItem(int x, int y) {
		super(x, y);
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		
	}
	
	@Override
	public void collect(Player player) {
		player.increaseSpeed(1);
		hp = 0;
	}
}
