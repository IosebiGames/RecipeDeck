package Tools;

import javax.swing.*;
import java.awt.*;

public class Panel {
	public static void createPanel(JPanel panel, Rectangle rect, boolean focusableStatus) {
		panel.setLayout(null);
		panel.setBounds(rect.getBounds());
		panel.setFocusable(focusableStatus);
	    addBorder(panel);
	    Screen.window.add(panel);
	}
	private static void addBorder(JPanel panel) {
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
	}
}
