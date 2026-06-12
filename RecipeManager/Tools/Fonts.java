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
   	private boolean status;
   	
	public Font AllowExternalFont(String fontPath) {
        try {
        	fontFile = new File(fontPath);
        	fontInput = new FileInputStream(fontFile);
        	newFont = Font.createFont(Font.TRUETYPE_FONT, fontInput);
        	ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        }catch(Exception e) {
        	System.out.println("Failed to setup: " + e.getMessage());
        }
        status = ge.registerFont(newFont);
        //System.out.println("Registered: " + status);
        return newFont;
	}
}