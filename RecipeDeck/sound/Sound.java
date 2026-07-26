package sound;

import kuusisto.tinysound.TinySound;

public class Sound {
	private kuusisto.tinysound.Sound clickSound;

	public void playSound(String path) {
		TinySound.init();		
		clickSound = TinySound.loadSound(getClass().getResource(path));
		clickSound.play();
	}
}
