package Logic;

import java.util.List;

import Model.ATKItem;
import Model.ATKSpeedItem;
import Model.Bullet;
import Model.BulletItem;
import Model.BulletPassable;
import Model.Entity;
import Model.HPItem;
import Model.IRenderable;
import Model.IRenderableHolder;
import Model.Item;
import Model.Player;
import Model.SpeedItem;
import Model.WeakObstacle;
import Utility.GameUtility;
import Utility.Geometry;
import Utility.RandomUtility;

public class GameManager {
	
	private static boolean isCollide(Entity e1, Entity e2) {
		//TODO: wait for width and size of each entity
		if (Geometry.isPointInRect(e1.getX(), e1.getY(), e2.getX() - 10, e2.getY() - 10, e2.getX() + 10, e2.getY() + 10)) {
			return true;
		}
		if (Geometry.isPointInRect(e1.getX(), e1.getY(), e2.getX() - 10, e2.getY() - 10, e2.getX() + 10, e2.getY() + 10)) {
			return true;
		}
		if (Geometry.isPointInRect(e1.getX(), e1.getY(), e2.getX() - 10, e2.getY() - 10, e2.getX() + 10, e2.getY() + 10)) {
			return true;
		}
		if (Geometry.isPointInRect(e1.getX(), e1.getY(), e2.getX() - 10, e2.getY() - 10, e2.getX() + 10, e2.getY() + 10)) {
			return true;
		}
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
				//TODO: wait for width and size of each entity
				if (((Player) e1).getDirection() == GameUtility.UP) {
					e1.setY(e2.getY() + 10);
				}
				else if (((Player) e1).getDirection() == GameUtility.RIGHT) {
					e1.setX(e2.getX() - 10);
				}
				else if (((Player) e1).getDirection() == GameUtility.DOWN) {
					e1.setY(e2.getY() - 10);
				}
				else if (((Player) e1).getDirection() == GameUtility.LEFT) {
					e1.setX(e2.getX() + 10);
				}
			}
		}
		else if (e2 instanceof Player) {
			if (e1 instanceof Item) {
				((Item) e1).collect((Player)e2);
			}
			else if (e1 instanceof Entity) {
				//TODO: wait for width and size of each entity
				if (((Player) e2).getDirection() == GameUtility.UP) {
					e2.setY(e1.getY() + 10);
				}
				else if (((Player) e2).getDirection() == GameUtility.RIGHT) {
					e2.setX(e1.getX() - 10);
				}
				else if (((Player) e2).getDirection() == GameUtility.DOWN) {
					e2.setY(e1.getY() - 10);
				}
				else if (((Player) e2).getDirection() == GameUtility.LEFT) {
					e2.setX(e1.getX() + 10);
				}
			}
		}
	}
	
	public static void checkCollision() {
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

	public static void buildObstacle() {
		//TODO: wait for width and size of each entity & number of obstacle (range)
		int obstaclesNumber = RandomUtility.random(10, 20);
		while (obstaclesNumber > 0) {
			int x = RandomUtility.random(25);
			int y = RandomUtility.random(25);
			while (true) { // TODO: check if can place here
				x = RandomUtility.random(25);
				y = RandomUtility.random(25);
				break;
			}
			WeakObstacle obstacle = new WeakObstacle(x, y);
			IRenderableHolder.getInstance().addEntity(obstacle);
			obstaclesNumber --;
		}
	}
	
	public static void buildItem() {
		//TODO: wait for width and size of each entity & number of obstacle (range)
		int x = RandomUtility.random(25);
		int y = RandomUtility.random(25);
		while (true) { // TODO: check if can place here
			x = RandomUtility.random(25);
			y = RandomUtility.random(25);
			break;
		}
		int type = RandomUtility.random(6);
		Item item;
		switch(type) {
		case 1: item = new ATKItem(x, y); break;
		case 2: item = new ATKSpeedItem(x, y); break;
		case 3: item = new BulletItem(x, y); break;
		case 4: item = new HPItem(x, y); break;
		case 5: item = new SpeedItem(x, y); break;
		default: return;
		}
		IRenderableHolder.getInstance().addEntity(item);
	}
	
}