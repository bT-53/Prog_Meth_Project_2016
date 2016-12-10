package Logic;

import java.util.List;

import Model.Bullet;
import Model.BulletPassable;
import Model.Entity;
import Model.IRenderable;
import Model.IRenderableHolder;
import Model.Item;
import Model.Movable;
import Model.Player;

public class GameManager {
	
	private static boolean isCollide(Entity e1, Entity e2) {
		//TODO: check collide condition
		return false;
	}
	
	private static void collide(Entity e1, Entity e2) {
		if (e1 instanceof Bullet) {
			if (e2 instanceof BulletPassable) {
				// nothing happen
				return;
			}
			else {
				int dmg = ((Bullet)e1).getDamage();
				e1.hit(dmg);
				e2.hit(dmg);
			}
		}
		else if (e2 instanceof Bullet) {
			if (e1 instanceof BulletPassable) {
				// nothing happen
				return;
			}
			else {
				int dmg = ((Bullet)e2).getDamage();
				e1.hit(dmg);
				e2.hit(dmg);
			}
		}
		else if (e1 instanceof Player) {
			if (e2 instanceof Item) {
				((Item) e2).collect((Player)e1);
			}
			else if (e2 instanceof Entity) {
				//TODO: fix player's position
			}
		}
		else if (e2 instanceof Player) {
			if (e1 instanceof Item) {
				((Item) e1).collect((Player)e2);
			}
			else if (e1 instanceof Entity) {
				//TODO: fix player's position
			}
		}
	}
	
	public static void checkCollide() {
		List<IRenderable> entities = IRenderableHolder.getInstance().getEntities();
		for (int i=0; i<entities.size(); i++) {
			for (int j=i+1; j<entities.size(); j++) {
				Entity e1 = (Entity)entities.get(i);
				Entity e2 = (Entity)entities.get(j);
				if (isCollide(e1, e2)){
					collide(e1, e2);
				}
			}
		}
	}

}
