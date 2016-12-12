package Model;

import Utility.SoundUtility;
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
	public int getZ() {
		return 1; //except Pond has z = 0.
	}
	
	@Override
	abstract public void draw(GraphicsContext gc, int x, int y);
	
	@Override
	public boolean isDestroyed() {
		return hp <= 0;
	}
	
	public void hit(int dmg) {
		hp -= dmg;
		if (hp < 0) {
			hp = 0;
		}
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	
}
