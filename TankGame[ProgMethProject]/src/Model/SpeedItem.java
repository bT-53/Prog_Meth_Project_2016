package Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class SpeedItem extends Item{
	
	public SpeedItem(int x, int y) {
		super(x, y);
	}
	
	@Override
	public void draw(GraphicsContext gc,int x,int y) {
		gc.setFill(Color.YELLOW);
		gc.fillRoundRect(x-WIDTH/2, y-HEIGHT/2, WIDTH, HEIGHT, 10, 10);
	}
	
	@Override
	public void collect(Player player) {
		player.increaseSpeed(1);
		hp = 0;
	}
}
