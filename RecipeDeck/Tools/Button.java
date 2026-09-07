package Tools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Button {
	public static void createButton(JButton b, Rectangle rect, boolean focusableStatus, JPanel panel, boolean visible, Color bc, Color fc) {
        b.setFocusable(focusableStatus);
        b.setBounds(rect.getBounds());
        Fonts.AllowExternalFont("RecipeDeck/src/fonts/Inter_bold.ttf");
        b.setFont(new Font("Inter", Font.BOLD, 12));
        b.setBackground(bc);
        b.setForeground(fc);
        b.setVisible(visible);
        b.putClientProperty("JButton.buttonType", "roundRect");
        b.putClientProperty("FlatLaf.background", Color.white);
        b.putClientProperty("FlatLaf.foreground", Color.black);
        
        for(ActionListener al : b.getActionListeners()) {
            b.removeActionListener(al);
        }
        if(panel == null) {
            Screen.window.add(b);
        }else {
            panel.add(b);
       }
 	}
 }
