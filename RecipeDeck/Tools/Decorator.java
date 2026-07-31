package Tools;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import main.App;
import recipeSystem.OutputManager;
import sound.Sound;
import startup.StartupScreen;

public class Decorator implements java.awt.event.ActionListener {
    private boolean showingNext = false;
    private Timer imageTimer;
    private int counter = 0;
    private JMenuItem Burgerpick, Drinkpick;
    private JPopupMenu popup1, popup2;
    public static int addings = 0;
    private ResourceLoader rl;
    private ActionListener burgerAL, burgerAL2;
    private Sound s;
    
    public Decorator() {
        this.rl = new ResourceLoader();
        if(Language.currentLanguage.equals("Armenian")) {
        	this.Burgerpick = new JMenuItem("Ընտրել (60$)");
        	this.Drinkpick = new JMenuItem("Ընտրել (90$)");
        }else {
        	this.Burgerpick = new JMenuItem("Select (60$)");
        	this.Drinkpick = new JMenuItem("Select (90$)");
        }
    	this.popup1 = new JPopupMenu();
    	this.popup2 = new JPopupMenu();
        this.s = new Sound();
    }
    public void decorate() {
    	    this.burgerAL = e -> {
    	    		 if(e.getSource()==Burgerpick) {
    	    			 addings += 60;
    	    			 App.labelList.get(12).setText("" + addings + " $");
    	    			 s.playSound("/sound/click_sound.wav");
    	    			 Burgerpick.setText("Can't Select twice or more, product is too expensive.");
    	    			 Burgerpick.setEnabled(false);
    	    			 App.buttonList.get(5).setEnabled(true);
    	    			 App.buttonList.get(5).addActionListener(this);
    	    			 OutputManager.write("src/output/payment.txt", String.valueOf(addings));
    	    			 App.labelList.get(19).setVisible(false);
    	    			 App.buttonList.get(5).setVisible(true);
    	    		 }
    	    	 };
    	    	 this.burgerAL2 = e -> {
    	    		 if(e.getSource()==Burgerpick) {
    	    			 addings += 60;
    	    			 App.labelList.get(12).setText("" + addings + " $");
    	    			 s.playSound("/sound/click_sound.wav");
    	    			 App.labelList.get(19).setVisible(false);
    	    			 App.buttonList.get(5).setVisible(true);
    	    		 }
    	    	 };
    	    	 Burgerpick.setEnabled(true);
    	    	 Burgerpick.setFocusable(false);
    	    	 if(App.mode.equals("Dark")) {
    	    		 Burgerpick.setForeground(Color.white);
    	    	 }else if(App.mode.equals("Light")) {
    	    		 Burgerpick.setForeground(Color.black);
    	    	 }
    	    	 Burgerpick.setFont(new Font("Inter", Font.BOLD, 15));
    	    	 Burgerpick.addActionListener(burgerAL);
    	    	 
    	    	 Drinkpick.setFocusable(false);
    	    	 if(App.mode.equals("Dark")) {
    	    		 Drinkpick.setForeground(Color.white);
    	    	 }else if(App.mode.equals("Light")) {
    	    		 Drinkpick.setForeground(Color.black);
    	    	 }
    	    	 Drinkpick.setFont(new Font("Inter", Font.BOLD, 15));
    	    	 Drinkpick.addActionListener(new ActionListener() {
    	    		 public void actionPerformed(ActionEvent e) {
    	    			 if(e.getSource()==Drinkpick) {
    	    				 addings += 90;
    	    				 App.labelList.get(12).setText("" + addings + " $");
    	    				 s.playSound("/sound/click_sound.wav");
    	    				 OutputManager.write("src/output/payment.txt", String.valueOf(addings));
    	    			 }
    	    		 }        	
    	    	 });
    	    	 popup1.add(Burgerpick);
    	    	 popup1.setFocusable(false);
    	    	 
    	    	 popup2.add(Drinkpick);
    	    	 popup2.setFocusable(false);
    	    	 
    	    	 if(Language.currentLanguage.equals("Armenian")) {
    	    		 App.labelList.get(2).setToolTipText("Բուրգերներ");
    	    		 App.labelList.get(1).setToolTipText("Աղցաններ");
    	    	 }else {
    	    		 App.labelList.get(2).setToolTipText("Burgers");
    	    		 App.labelList.get(1).setToolTipText("Salads");
    	    	 }
    	    	 App.labelList.get(2).setIcon(new ImageIcon(rl.getImage("/images/Burger.png")));
    	    	 App.labelList.get(2).setBorder(BorderFactory.createLineBorder(Color.black));
    	    	 App.labelList.get(2).setComponentPopupMenu(popup1);
    	    	 App.labelList.get(1).setIcon(new ImageIcon(rl.getImage("/images/TomatoSalad.png")));
    	    	 App.labelList.get(1).setBorder(BorderFactory.createLineBorder(Color.black));
    	    	 App.labelList.get(1).setComponentPopupMenu(popup2);
    	    	 App.labelList.get(10).setFont(new Font("Inter", Font.BOLD, 15));
    }
    public void actionPerformed(ActionEvent e) {
    	    if(Language.currentLanguage.equals("Armenian")) {
    	    	Burgerpick.setText("Ընտրել (60$)");
    	    }else {
    	    	Burgerpick.setText("Pick (60$)");
            }
    		Burgerpick.setEnabled(true);
    		Burgerpick.removeActionListener(burgerAL);
    		Burgerpick.addActionListener(burgerAL2);

    		if(!showingNext) {
    			App.labelList.get(2).setIcon(new ImageIcon(rl.getImage("/images/Steak.png")));
    			App.labelList.get(1).setIcon(new ImageIcon(rl.getImage("/images/ChickenSalad.png")));
				
			    if(StartupScreen.currentLanguage.equals("Armenian")) {
			    	App.labelList.get(2).setToolTipText("Սթեյք");
			    	App.labelList.get(1).setToolTipText("Հավի աղցան");
			    }else {
			    	App.labelList.get(2).setToolTipText("Steak");
			    	App.labelList.get(1).setToolTipText("Chicken Salad");
			    }
			    if(StartupScreen.currentLanguage.equals("Armenian")) {
			    	App.buttonList.get(5).setText("հետ");
	            }else {
	            	App.buttonList.get(5).setText("Back");
			    }
                showingNext = true;
                
                counter = 0;

                imageTimer = new Timer(1000, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        counter++;
                        if(counter == 5) {
                        	App.labelList.get(1).setIcon(new ImageIcon(rl.getImage("/images/IceCream.png")));
                        	if(StartupScreen.currentLanguage.equals("Armenian")) {
                        		App.labelList.get(1).setToolTipText("Պաղպաղակ");
                        	}else {
                        		App.labelList.get(1).setToolTipText("Ice-Cream");
                        	}
                        }
                        if(counter == 12) {
                        	App.labelList.get(1).setIcon(new ImageIcon(rl.getImage("/images/ChickenSalad.png")));
							if(Language.currentLanguage.equals("Armenian")) {
								App.labelList.get(1).setToolTipText("Հավի աղցան");
							}
                        	counter = 0; 
                        }
                    }
                });
              imageTimer.start();
            }else {
            	Burgerpick.addActionListener(burgerAL);
            	Burgerpick.setText("Can't Select twice or more, product is too expensive.");
            	Burgerpick.setEnabled(false);
            	
            	App.labelList.get(2).setIcon(new ImageIcon(rl.getImage("/images/Burger.png")));
            	App.labelList.get(1).setIcon(new ImageIcon(rl.getImage("/images/TomatoSalad.png")));
				
			    if(StartupScreen.currentLanguage.equals("Armenian")) {
			    	App.labelList.get(2).setToolTipText("Սթեյք");
			    	App.labelList.get(1).setToolTipText("աղցաններ");
	            }else {
	            	App.labelList.get(2).setToolTipText("Burgers");
	            	App.labelList.get(1).setToolTipText("Salads");
			    }
			    if(StartupScreen.currentLanguage.equals("Armenian")) {
			    	App.buttonList.get(5).setText("Հաջորդ");
			    }else {
			    	App.buttonList.get(5).setText("Next");
			    }
                showingNext = false;
                
                if(imageTimer != null) {
                    imageTimer.stop();
                    counter = 0;
                }
            }
      }
}
