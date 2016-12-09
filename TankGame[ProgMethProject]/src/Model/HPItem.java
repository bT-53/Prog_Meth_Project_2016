package Model;

import javafx.scene.canvas.GraphicsContext;

public class HPItem extends Item{
	
	public HPItem(int x, int y) {
		super(x, y);
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		
	}
	
	@Override
	public void collect(Player player) {
		player.increaseHP(1);
		hp = 0;
	}
}
