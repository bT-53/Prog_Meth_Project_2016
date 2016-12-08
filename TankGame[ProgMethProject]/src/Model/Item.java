package Model;

import javafx.scene.canvas.GraphicsContext;

public abstract class Item extends Entity implements BulletPassable{
	
	public Item(int x, int y) {
		super(100, x, y);
	}
	
	@Override
	public int getZ() {
		return 0; // should be lower than a bullet.
	}
	
	@Override
	public abstract void draw(GraphicsContext gc);
	
	@Override
	public void hit(int dmg) {
		//nothing happen
	}
	
	public abstract void collect(Player player);
}
