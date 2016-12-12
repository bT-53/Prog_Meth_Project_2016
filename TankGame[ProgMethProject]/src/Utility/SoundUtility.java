package Utility;

import Model.IRenderableHolder;
import javafx.scene.media.AudioClip;

public class SoundUtility {
	private static AudioClip shootingSound = IRenderableHolder.shootingSound;
	private static AudioClip deathSound = IRenderableHolder.deathSound;
	
	public static void playSound(String sound){
		if(shootingSound == null || deathSound == null) return;
		if(sound.equals("shoot")){
			shootingSound.play();
		}else if(sound.equals("death")){
			deathSound.play();
		}
	}
}
