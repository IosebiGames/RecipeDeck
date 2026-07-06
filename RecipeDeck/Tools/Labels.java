package Tools;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

public class Labels {
	public void createLabel(JLabel label, Font font, Color foregroundColor, Rectangle rect, boolean focusableStatus, JPanel partPanel) {
		label.setBounds(rect.getBounds());
		label.setFocusable(focusableStatus);
		label.setForeground(foregroundColor);
		label.setFont(font);
		Screen.window.add(label);
		if (partPanel != null) {
			partPanel.add(label);
		}
	}
}
