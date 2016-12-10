package Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class ATKSpeedItem extends Item{
	
	public ATKSpeedItem(int x, int y) {
		super(x, y);
	}
	
	@Override
	public void draw(GraphicsContext gc, int x, int y) {
		gc.setFill(Color.ORANGE);
		gc.fillOval(x - WIDTH/2 , y - HEIGHT/2, WIDTH, HEIGHT);
	}
	
	@Override
	public void collect(Player player) {
		player.increaseATKSpedd(1);
		hp = 0;
	}
	
}
