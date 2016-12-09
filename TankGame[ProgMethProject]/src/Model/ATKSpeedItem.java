package Model;

import javafx.scene.canvas.GraphicsContext;

public class ATKSpeedItem extends Item{
	
	public ATKSpeedItem(int x, int y) {
		super(x, y);
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		
	}
	
	@Override
	public void collect(Player player) {
		player.increaseATKSpedd(1);
		hp = 0;
	}
	
}
