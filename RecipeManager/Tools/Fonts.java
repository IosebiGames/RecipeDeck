package Tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

public class Fonts {
	private InputStream fontInput;
	private File fontFile;
	private GraphicsEnvironment ge;
   	private Font newFont;
   	
	public Font AllowExternalFont(String fontPath) {
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
