package Tools;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import main.App;
import sound.Sound;

public class Decorator implements java.awt.event.ActionListener {
    private App app;
    private boolean showingNext = false;
    private Timer imageTimer;
    private int counter = 0;
    private JMenuItem Burgerpick, Drinkpick;
    private JPopupMenu popup1, popup2;
    private int addings = 0;
    private ResourceLoader rl;
    private ActionListener burgerAL, burgerAL2;
    private Fonts f;
    
    public Decorator(App app) {
        this.app = app;
        this.rl = new ResourceLoader();
    	this.Burgerpick = new JMenuItem("Select (60$)");
    	this.Drinkpick = new JMenuItem("Select (90$)");
    	this.popup1 = new JPopupMenu();
    	this.popup2 = new JPopupMenu();
    	this.f = new Fonts();
    }
    public void decorate() {
    	     f.AllowExternalFont("src/fonts/Inter_bold.ttf");
    		 this.burgerAL = e -> {
 			   if(e.getSource()==Burgerpick) {
 				   addings += 60;
 				   app.labelList.get(12).setText("" + addings + " $");
 				   new Sound().playSound("/sound/click_sound.wav");
 	 			   Burgerpick.setText("Can't Select twice or more, product is too expensive.");
 				   Burgerpick.setEnabled(false);
 				   app.buttonList.get(5).setEnabled(true);
 				   app.buttonList.get(5).addActionListener(this);
 				   savePaymentDetail(addings);
 				   app.labelList.get(19).setVisible(false);
 		    	   app.buttonList.get(5).setVisible(true);
 			   }
             };
             this.burgerAL2 = e -> {
 		       if(e.getSource()==Burgerpick) {
 				   addings += 60;
 				   app.labelList.get(12).setText("" + addings + " $");
 				   new Sound().playSound("/sound/click_sound.wav");
 				   app.labelList.get(19).setVisible(false);
 		    	   app.buttonList.get(5).setVisible(true);
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
    					app.labelList.get(12).setText("" + addings + " $");
    					new Sound().playSound("/sound/click_sound.wav");
    					savePaymentDetail(addings);
    				}
    			}        	
    		});
    		popup1.add(Burgerpick);
    		popup1.setFocusable(false);
    		
    		popup2.add(Drinkpick);
    		popup2.setFocusable(false);
    		
    		app.labelList.get(2).setToolTipText("Burgers");
    		app.labelList.get(2).setIcon(new ImageIcon(rl.getImage("/images/Burger.png")));
    		app.labelList.get(2).setBorder(BorderFactory.createLineBorder(Color.black));
    		app.labelList.get(2).setComponentPopupMenu(popup1);
    		app.labelList.get(1).setToolTipText("Salads");
    		app.labelList.get(1).setIcon(new ImageIcon(rl.getImage("/images/TomatoSalad.png")));
    		app.labelList.get(1).setBorder(BorderFactory.createLineBorder(Color.black));
    		app.labelList.get(1).setComponentPopupMenu(popup2);
    		app.labelList.get(10).setFont(new Font("Inter", Font.BOLD, 15));
    }
    public void actionPerformed(ActionEvent e) {
    		Burgerpick.setText("Pick (60$)");
    		Burgerpick.setEnabled(true);
    		Burgerpick.removeActionListener(burgerAL);
    		Burgerpick.addActionListener(burgerAL2);

    		if(!showingNext) {
        		app.labelList.get(2).setIcon(new ImageIcon(rl.getImage("/images/Steak.png")));
			    app.labelList.get(1).setIcon(new ImageIcon(rl.getImage("/images/ChickenSalad.png")));
				
                app.labelList.get(2).setToolTipText("Steak");
                app.labelList.get(1).setToolTipText("Chicken Salad");
                app.buttonList.get(5).setText("Back");
                showingNext = true;
                
                counter = 0;

                imageTimer = new Timer(1000, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        counter++;
                        if(counter == 5) {
                            app.labelList.get(1).setIcon(new ImageIcon(rl.getImage("/images/IceCream.png")));
						    app.labelList.get(1).setToolTipText("Ice Cream");
                        }
                        if(counter == 12) {
                            app.labelList.get(1).setIcon(new ImageIcon(rl.getImage("/images/ChickenSalad.png")));
							app.labelList.get(1).setToolTipText("Chicken Salad");
                            counter = 0; 
                        }
                    }
                });
              imageTimer.start();
            } else {
            	Burgerpick.addActionListener(burgerAL);
            	Burgerpick.setText("Can't Select twice or more, product is too expensive.");
            	Burgerpick.setEnabled(false);
            	
                app.labelList.get(2).setIcon(new ImageIcon(rl.getImage("/images/Burger.png")));
			    app.labelList.get(1).setIcon(new ImageIcon(rl.getImage("/images/TomatoSalad.png")));
				
                app.labelList.get(2).setToolTipText("Burgers");
                app.labelList.get(1).setToolTipText("Salads");
                app.buttonList.get(5).setText("Next");
                showingNext = false;
                
                if (imageTimer != null) {
                    imageTimer.stop();
                    counter = 0;
                }
            }
      }
    private void savePaymentDetail(int sum) {
    	try {
			System.setOut(new PrintStream("payment.txt"));
			System.out.println(String.valueOf(sum));
		}catch(FileNotFoundException e) {
			System.out.println("Can't save details: " + e.getMessage());
		}
    }
}
