package main;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import Tools.*;
import recipeSystem.MoreTab;
import recipeSystem.RecipeHandler;
import startup.StartupScreen;

public class App {
	public Screen screen = new Screen();
	public Separators sp = new Separators();
	public Labels lb = new Labels();
	public TextBox tb = new TextBox(); 
    public Bounds b = new Bounds();
    private Panel panel = new Panel();
    private RecipeHandler rh = new RecipeHandler();
    public static MoreTab mt = new MoreTab();
    private Button button = new Button();
    private Decorator dec = new Decorator();
    public static List<JLabel> labelList = new ArrayList<>();
    public static List<JButton> buttonList = new ArrayList<>();
    public static List<JPanel> panelList = new ArrayList<>();
    public static String mode = "Light";

    public App() { 
	    for(int i = 0; i <= 4; i++) {
		   panelList.add(new JPanel());
	    }
    	screen.createWindow();
        
		for(int i = 0; i < panelList.size(); i++) {
	        panel.createPanel(panelList.get(i), new Bounds(Bounds.panelXPostions[i], Bounds.panelYPostions[i], 338, Bounds.panelHeightPostions[i]).getBounds(), false);
		}
		if(Language.currentLanguage.equals("Armenian")) {
			lb.createLabel(labelList.get(0), new Font("Inter", Font.BOLD, 29), new Color(225, 178, 89), new Bounds(10, 4, 318, 54).getBounds(), false, panelList.get(0));
		}else {
			lb.createLabel(labelList.get(0), new Font("Inter", Font.BOLD, 29), new Color(225, 178, 89), new Bounds(48, 4, 260, 54).getBounds(), false, panelList.get(0));
		}
		lb.createLabel(labelList.get(1), null, null, new Bounds(179, 57, 151, 144).getBounds(), false, panelList.get(0));
		lb.createLabel(labelList.get(2), null, null, new Bounds(10, 57, 151, 144).getBounds(), false, panelList.get(0));
		if(Language.currentLanguage.equals("English")) {
			if(mode.equals("Dark")) {
				lb.createLabel(labelList.get(3), new Font("Inter", Font.BOLD, 31), new Color(20, 238, 206), new Bounds(100, 11, 291, 54).getBounds(), false, panelList.get(1));
			}else if(mode.equals("Light")) {
				lb.createLabel(labelList.get(3), new Font("Inter", Font.BOLD, 31), new Color(9, 121, 105), new Bounds(100, 11, 291, 54).getBounds(), false, panelList.get(1));
			}
		}else {
			if(mode.equals("Dark")) {
				lb.createLabel(labelList.get(3), new Font("Inter", Font.BOLD, 22), new Color(20, 238, 206), new Bounds(30, 11, 291, 54).getBounds(), false, panelList.get(1));
			}else if(mode.equals("Light")) {
				lb.createLabel(labelList.get(3), new Font("Inter", Font.BOLD, 31), new Color(9, 121, 105), new Bounds(30, 11, 291, 54).getBounds(), false, panelList.get(1));
			}
		}
		if(Language.currentLanguage.equals("Armenian")) {
			lb.createLabel(labelList.get(4), null, null, new Bounds(104, 94, 256, 18).getBounds(), false, panelList.get(1));
			lb.createLabel(labelList.get(5), null, null, new Bounds(104, 124, 256, 18).getBounds(), false, panelList.get(1));
			if(Language.currentLanguage.equals("Armenian")) {
				lb.createLabel(labelList.get(6), null, null, new Bounds(140, 153, 256, 18).getBounds(), false, panelList.get(1));
			}else {
				lb.createLabel(labelList.get(6), null, null, new Bounds(112, 153, 256, 18).getBounds(), false, panelList.get(1));
			}
			lb.createLabel(labelList.get(7), null, null,  new Bounds(140, 181, 256, 23).getBounds(), false, panelList.get(1));
			lb.createLabel(labelList.get(8), null, null, new Bounds(140, 213, 256, 23).getBounds(), false, panelList.get(1));
		}else {
		    lb.createLabel(labelList.get(4), null, null, new Bounds(104, 94, 176, 18).getBounds(), false, panelList.get(1));
			lb.createLabel(labelList.get(5), null, null, new Bounds(104, 124, 176, 18).getBounds(), false, panelList.get(1));
			lb.createLabel(labelList.get(6), null, null, new Bounds(112, 153, 176, 18).getBounds(), false, panelList.get(1));
			lb.createLabel(labelList.get(7), null, null,  new Bounds(140, 181, 166, 23).getBounds(), false, panelList.get(1));
			lb.createLabel(labelList.get(8), null, null, new Bounds(140, 213, 166, 23).getBounds(), false, panelList.get(1));
		}
		lb.createLabel(labelList.get(9), new Font("Inter", Font.BOLD, 31), Color.red, new Bounds(93, 11, 210, 54).getBounds(), false, panelList.get(2));
		lb.createLabel(labelList.get(10), null, null, new Bounds(93, 63, 145, 16).getBounds(), false, panelList.get(2));
		
		if(Language.currentLanguage.equals("Armenian")) {
			lb.createLabel(labelList.get(11), new Font("Inter", Font.BOLD, 27), new Color(255, 165, 0), new Bounds(10, 5, 318, 40).getBounds(), false, panelList.get(3));
		}else {
			lb.createLabel(labelList.get(11), new Font("Inter", Font.BOLD, 31), new Color(255, 165, 0), new Bounds(86, 5, 171, 40).getBounds(), false, panelList.get(3));
		}
		lb.createLabel(labelList.get(12), new Font("Inter", Font.BOLD, 18), new Color(255, 165, 0), new Bounds(96, 44, 136, 14).getBounds(), false, panelList.get(3));
		
		if(Language.currentLanguage.equals("Armenian")) {
			if(mode.equals("Light")) {
				lb.createLabel(labelList.get(19), new Font("Verdana", Font.BOLD, 12), Color.black, new Bounds(20, 214, 315, 40).getBounds(), false, panelList.get(0));
			}else if(mode.equals("Dark")) {
				lb.createLabel(labelList.get(19), new Font("Verdana", Font.BOLD, 12), Color.white, new Bounds(20, 214, 315, 40).getBounds(), false, panelList.get(0));
			}
		}else {
			if(mode.equals("Light")) {
				lb.createLabel(labelList.get(19), new Font("Inter", Font.BOLD, 15), Color.black, new Bounds(70, 214, 210, 40).getBounds(), false, panelList.get(0));
			}else if(mode.equals("Dark")) {
				lb.createLabel(labelList.get(19), new Font("Inter", Font.BOLD, 15), Color.white, new Bounds(70, 214, 210, 40).getBounds(), false, panelList.get(0));
			}
		}
		button.createButton(buttonList.get(0), new Bounds(10, 93, 86, 23).getBounds(), false, panelList.get(1), true, Color.white, Color.black, false);
		button.createButton(buttonList.get(1), new Bounds(10, 124, 86, 23).getBounds(), false, panelList.get(1), true, Color.white, Color.black, false);
		if(Language.currentLanguage.equals("Armenian")) {
			button.createButton(buttonList.get(2), new Bounds(10, 153, 126, 23).getBounds(), false, panelList.get(1), true, Color.white, Color.black, false);
		}else {
			button.createButton(buttonList.get(2), new Bounds(10, 153, 96, 23).getBounds(), false, panelList.get(1), true, Color.white, Color.black, false);
		}
		button.createButton(buttonList.get(3), new Bounds(10, 183, 126, 23).getBounds(), false, panelList.get(1), true, Color.white, Color.black, false);
		button.createButton(buttonList.get(4), new Bounds(10, 213, 126, 23).getBounds(), false, panelList.get(1), true, Color.white, Color.black, false);
		button.createButton(buttonList.get(5), new Bounds(108, 209, 130, 40).getBounds(), false, panelList.get(0), false, Color.white, Color.black, false);
		button.createButton(buttonList.get(6), new Bounds(113, 133, 210, 40).getBounds(), false, panelList.get(2), false, Color.white, Color.black, false);

		for(int i = 0; i < Bounds.yPostions.length; i++) {
			sp.createSeparator(labelList.get(13+i), new Bounds(336, Bounds.yPostions[i], 115, 42).getBounds(), true);
		}
		dec.decorate();
	    rh.startRecipeSystem();
	    tb.validate(); 	    
    }
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(() -> {
			StartupScreen.setMode(mode, "User Runtime");
		});
	 }
 }
