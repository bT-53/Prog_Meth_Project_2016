package Model;

import javafx.scene.canvas.GraphicsContext;

public class ATKItem extends Item{
	
	public ATKItem(int x, int y) {
		super(x, y);
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		
	}
	
	@Override
	public void collect(Player player) {
		player.increaseATK(1);
		hp = 0;
	}
}
