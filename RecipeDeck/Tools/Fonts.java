package Tools;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.BufferedInputStream;
import java.io.InputStream;

public class Fonts {
	private static GraphicsEnvironment ge;
   	private static Font newFont;
   	
	public static Font AllowExternalFont(String fontPath) {
        try (InputStream fontInput = new BufferedInputStream(Fonts.class.getResourceAsStream(fontPath))) {
        	ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        	newFont = Font.createFont(Font.TRUETYPE_FONT, fontInput);
        	ge.registerFont(newFont);
        }catch(Exception e) {
        	if(e.getMessage().contains("Stream closed")) {
        		// Just check to get reed of "Stream Closed" failure;
        	}else {
        		System.out.println("Failed to Setup: " + e.getMessage());
        	}
        }
        return newFont;
	}
}
