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
    private String duration;
    private long daysBetween;
    
    public TextBox() {
    	this.date = LocalDate.now();
	    this.lastDate = 1;
	    this.lastMonth = 11;
	    this.lastYear = 2026;
	    this.latestDate = date.getDayOfMonth();
	    this.latestMonth = date.getMonthValue();
	    this.latestYear = 2026;
	    this.lastDay = LocalDate.of(lastYear, lastMonth, lastDate);
	    this.currentDay = LocalDate.of(latestYear, latestMonth, latestDate);
	    this.daysBetween = ChronoUnit.DAYS.between(lastDay, currentDay);
	}
	public void load() {
		textPane = new JTextPane();
		textPane.setBounds(0, 0, 338, 123);
		textPane.setEditable(false);
		textPane.setFocusable(false);
		textPane.setBorder(BorderFactory.createLineBorder(Color.black));
		textPane.setContentType("text/html");	
	
		if(App.mode.equals("Dark")) {
			textPane.setForeground(Color.white);
		}else if(App.mode.equals("Light")) {
			textPane.setForeground(Color.black);
		}
		if(daysBetween < 30) {
			duration = String.valueOf(daysBetween + "d ago");
		    setInformation("<html><pre style='font-family:Inter; font-size:12px;'>"
			    	+ "                        What's New: " + "<br>"
			    	+ "                   - Recipe Management Added<br>"
			    	+ "                   - Added Theme Switching       <br>"
			    	+ "  Released: " + lastDate + "/" + lastMonth + "/" + lastYear + " (" + duration + ")"
			    	+ "</pre></html>");
		}else if(daysBetween > 30) {
			duration = String.valueOf("30d+ ago");
		    textPane.setToolTipText(String.valueOf(daysBetween));
		    duration = String.valueOf(daysBetween + "d ago");	
		    setInformation("<html><pre style='font-family:Inter; font-size:12px;'>"
		    		+ "                        What's New: " + "<br>"
		    		+ "                   - Recipe Management Added<br>"
		    		+ "                   - Added Theme Switching       <br>"
		    		+ "  Released: " + lastDate + "/" + lastMonth + "/" + lastYear + " (" + duration + ")"
		    		+ "</pre></html>");
		    
		}
	    App.panelList.get(4).add(textPane);
	}
	private void setInformation(final String info) {
		textPane.setText(info);
	}  
}
