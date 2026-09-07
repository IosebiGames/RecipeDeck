package Tools;

import javax.swing.*;
import java.awt.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

import main.App;

public class TextBox {
	private JTextPane textPane;
    private int lastDate, latestDate, lastMonth, latestMonth, lastYear, latestYear;
    private LocalDate lastDay, currentDay;
    private LocalDate date;
    
    public TextBox() {
    	this.date = LocalDate.now();
	    this.lastDate = 7;
	    this.lastMonth = 9;
	    this.lastYear = 2026;
	    this.latestDate = date.getDayOfMonth();
	    this.latestMonth = date.getMonthValue();
	    this.latestYear = 2026;
	    this.lastDay = LocalDate.of(lastYear, lastMonth, lastDate);
	    this.currentDay = LocalDate.of(latestYear, latestMonth, latestDate);
    }
	public void validate() {
		textPane = new JTextPane();
		textPane.setBounds(0, 0, 338, 123);
		textPane.setEditable(false);
		textPane.setFocusable(false);
		textPane.setBorder(BorderFactory.createLineBorder(Color.black));
	
		if(App.mode.equals("Dark")) {
			textPane.setForeground(Color.white);
		}else if(App.mode.equals("Light")) {
			textPane.setForeground(Color.black);
		}
		App.panelList.get(4).add(textPane);
		textPane.setContentType("text/html");	
	
	    setInformation("<html><pre style='font-family:Inter; font-size:12px;'>"
				+ "                        What's New: " + "<br>"
				+ "                   - Recipe Management Added<br>"
				+ "                   - Fixed Size of Images         <br>"
				+ "  Released: " + lastDate + "/" + lastMonth + "/" + lastYear + " (" + String.valueOf(ChronoUnit.DAYS.between(lastDay, currentDay) + "d ago)")
				+ "</pre></html>");
	}
	private void setInformation(final String info) {
		textPane.setText(info);
	}  
}
