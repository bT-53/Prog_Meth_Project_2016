package Model;

import javafx.scene.canvas.GraphicsContext;

public abstract class Entity implements IRenderable{
	protected int hp;
	protected int x, y;
	
	public Entity(int hp, int x,int y) {
		this.hp = hp;
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean isDestroyed() {
		return hp <= 0;
	}
	
	@Override
	public int getZ() {
		return 1; //except Pond has z = 0.
	}
	
	@Override
	abstract public void draw(GraphicsContext gc);
	
	public void hit(int dmg) {
		hp -= dmg;
		if (hp < 0) {
			hp = 0;
		}
	}
}
