package Model;

import javafx.scene.canvas.GraphicsContext;

public class BulletItem extends Item{
	
	public BulletItem(int x, int y) {
		super(x, y);
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		
	}
	
	@Override
	public void collect(Player player) {
		player.increaseBullets();
		hp = 0;
	}
}
