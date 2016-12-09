package Model;

import javafx.scene.canvas.GraphicsContext;

public abstract class Item extends Entity implements BulletPassable{
	
	public Item(int x, int y) {
		super(1, x, y);
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		
	}
	
	@Override
	public int getZ() {
		return 0;
	}
	
	@Override
	public void hit(int dmg) {
		//nothing happen
	}
	
	public abstract void collect(Player player);
}
