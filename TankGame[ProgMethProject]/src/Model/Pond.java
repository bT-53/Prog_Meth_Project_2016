package Model;

public class Pond extends Obstacle implements BulletPassable {
	
	public Pond(int x, int y) {
		super(x, y);
	}
	
	@Override
	public int getZ() {
		return 0;
	}
}
