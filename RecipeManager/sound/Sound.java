package sound;

import javax.sound.sampled.*;
import Tools.ResourceLoader;

public class Sound {
	private Clip clip;
	
    public void playSound(String path) {
      try {
    	clip = AudioSystem.getClip();
    	clip.open(AudioSystem.getAudioInputStream(getClass().getResource(ResourceLoader.getSoundFile(path))));	
    	clip.start();
        clip.addLineListener(e -> {
    	if(e.getType() == LineEvent.Type.STOP) { 
    	      clip.close();
        }});
     }catch(Exception e) {
         System.out.println("Failed to play the sound: " + e.getMessage()); 	 
     }
   }
}
