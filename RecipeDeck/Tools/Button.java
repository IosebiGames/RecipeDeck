package Tools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import sound.Sound;

public class Button {
	public void createButton(JButton b, Rectangle rect, boolean focusableStatus, JPanel panel, boolean visible, Color bc, Color fc, boolean soundless) {
        b.setFocusable(focusableStatus);
        b.setBounds(rect.getBounds());
        Fonts.AllowExternalFont("src/fonts/Inter_bold.ttf");
        b.setFont(new Font("Inter", Font.BOLD, 12));
        b.setBackground(bc);
        b.setForeground(fc);
        b.setVisible(visible);
        b.putClientProperty("JButton.buttonType", "roundRect");
        b.putClientProperty("FlatLaf.background", Color.white);
        b.putClientProperty("FlatLaf.foreground", Color.black);
        
        for (ActionListener al : b.getActionListeners()) {
            b.removeActionListener(al);
        }
        panel.add(b);
        
        if(soundless == true) {
        	return;
        }else {
        	b.addActionListener(e -> {
        		if(e.getSource() == b) {
        			new Sound().playSound("/sound/click_sound.wav");
        		}
        	});
        }
	}
}
