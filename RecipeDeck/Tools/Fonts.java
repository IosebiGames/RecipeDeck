package Tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

public class Fonts {
	private static InputStream fontInput;
	private static File fontFile;
	private static GraphicsEnvironment ge;
   	private static Font newFont;
   	
	public static Font AllowExternalFont(String fontPath) {
        try {
        	fontFile = new File(fontPath);
        	fontInput = new FileInputStream(fontFile);
        	ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        	newFont = Font.createFont(Font.TRUETYPE_FONT, fontInput);
        	ge.registerFont(newFont);
        }catch(Exception e) {
        	System.out.println("Failed to setup: " + e.getMessage());
        }
        return newFont;
	}
}
