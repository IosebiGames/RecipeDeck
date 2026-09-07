package sound;

import kuusisto.tinysound.TinySound;

public class Sound {
	private static kuusisto.tinysound.Sound clickSound;
	
	public Sound(String path) {
		clickSound = TinySound.loadSound(getClass().getResource(path));
		TinySound.init();		
	}
	public static void playSound() {
		clickSound.play();
	}
}
