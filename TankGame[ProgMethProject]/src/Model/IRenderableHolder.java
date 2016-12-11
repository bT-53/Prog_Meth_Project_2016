package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.sun.media.jfxmedia.AudioClip;

import javafx.scene.image.Image;

public class IRenderableHolder {
	
	private static final IRenderableHolder instance = new IRenderableHolder();
	private List<IRenderable> entities;
	private Comparator<IRenderable> comparator;
	public static Image bg, ATKSpeedIcon, ATKIcon, speedIcon, bulletIcon;
	public static AudioClip shootingSound;
	public static AudioClip deathSound;
	private static String shoot = "shootingSound.wav";
	private static String death = "shootingSound.wav" ;
	
	public IRenderableHolder() {
		entities = new ArrayList<>();
		comparator = (IRenderable o1, IRenderable o2) -> {
			if (o1.getZ() > o2.getZ())
				return 1;
			return -1;
		};
	}
	static{
		loadResource();
	}
	
	public void addEntity(IRenderable e) {
		entities.add(e);
		Collections.sort(entities, comparator);
	}
	
	private static void loadResource() {
		// TODO Auto-generated method stub
		bg = new Image(ClassLoader.getSystemResource("bg.png").toString());
		ATKSpeedIcon = new Image(ClassLoader.getSystemResource("ATKspeed.png").toString());
		ATKIcon = new Image(ClassLoader.getSystemResource("ATK.png").toString());
		speedIcon = new Image(ClassLoader.getSystemResource("Speed.png").toString());
		bulletIcon = new Image(ClassLoader.getSystemResource("Bullet.png").toString());
		}

	public List<IRenderable> getEntities() {
		return entities;
	}
	
	public static IRenderableHolder getInstance(){
		return instance;
	}
}
