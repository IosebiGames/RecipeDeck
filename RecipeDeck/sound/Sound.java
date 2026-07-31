package sound;

import kuusisto.tinysound.TinySound;

public class Sound {
	private kuusisto.tinysound.Sound clickSound;
	
	public Sound() {
		TinySound.init();		
	}
	public void playSound(String path) {
		clickSound = TinySound.loadSound(getClass().getResource(path));
		clickSound.play();
	}
}
