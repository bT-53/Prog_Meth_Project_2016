package Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class ATKItem extends Item{
	
	public ATKItem(int x, int y) {
		super(x, y);
	}
	
	@Override
	public void draw(GraphicsContext gc, int x, int y) {
		gc.setFill(Color.RED);
		gc.fillRoundRect(x-WIDTH/2, y-HEIGHT/2, WIDTH, HEIGHT, 10, 10);
		gc.setStroke(Color.WHITE);
		gc.setLineWidth(1);
		gc.strokeRoundRect(x-WIDTH/2, y-HEIGHT/2, WIDTH, HEIGHT, 10, 10);
		Image image = IRenderableHolder.ATKIcon;
		gc.drawImage(image, x-WIDTH/2, y-HEIGHT/2);
	}
	
	@Override
	public void collect(Player player) {
		player.increaseATK(1);
		hp = 0;
	}
}
