package sound;

import kuusisto.tinysound.TinySound;

public class Sound {
	private static kuusisto.tinysound.Sound clickSound;
	
	public Sound(String path) {
		TinySound.init();		
		clickSound = TinySound.loadSound(getClass().getResource(path));
	}
	public static void playSound() {
		clickSound.play();
	}
}
