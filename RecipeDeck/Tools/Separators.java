package Tools;

import javax.swing.*;
import java.awt.*;

public class Separators {
	public static void createSeparator(JLabel Seperatorlabel, Rectangle rect, boolean opaqueStatus) {
		Seperatorlabel.setBounds(rect.getBounds());
		Seperatorlabel.setIcon(new ImageIcon(Separators.class.getResource("/images/seperator_dark_icon.png")));
		Seperatorlabel.setOpaque(opaqueStatus);
		Screen.window.add(Seperatorlabel);
	}
}
