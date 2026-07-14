package recipeSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import main.App;
import Tools.*;
import Tools.Button;
import Tools.Labels;
import Tools.Panel;
import sound.Sound;
import startup.StartupScreen;

public class MoreTab {
	private JFrame window;
    private App app;
    private Panel p;
    private Labels l;
	private Button b;
	private Timer resetTimer;
    private int counter = 0;
    private String[] text, labelTexts;
    public ArrayList<JLabel> labelList = new ArrayList<>();
    public ArrayList<JButton> buttonList = new ArrayList<>();
    public ArrayList<JPanel> PanelList = new ArrayList<>();
    private final String[] products = new String[] {"Unselected", "Meat", "Tomato Salad", "Chicken Salad", "Ice-Cream", "Burger"};
    private JComboBox<?> productBox = new JComboBox<>(products);
    
   public MoreTab(App app) {
		this.app = app;
		this.p = new Panel();
		this.l = new Labels();
		this.b = new Button();
	    this.labelTexts = new String[] {"Product: " + "Unselected", "Calories: " + "0g", "Vitamins: " + "None", "Fats: " + "0g", "Sodium: " + "0g", "Protein: " + "0g", "Water: " + "0g", "Allergens: " + "None", "See Nutritional details below:"};
    }
	public void openMoreTab() {
		for(int i = 0; i <= 8; i++) {
			labelList.add(new JLabel(labelTexts[i]));	
		}
		buttonList.add(new JButton("Request all Recipes"));
		buttonList.add(new JButton("Close"));
	    PanelList.add(new JPanel());
	    
		resetTimer = new Timer(1000, _ -> {
			counter++;
			if(counter == 4) {
				counter = 0;
				if(App.mode.equals("Dark")) {
					buttonList.get(1).setBackground(Color.black);
				}else if(App.mode.equals("Light")) {
					buttonList.get(1).setBackground(Color.white);
				}
				resetTimer.stop();
			}
		});
		resetTimer.start();
		
		window = Screen.createWindow("More Info", false, 306, 459, JFrame.DO_NOTHING_ON_CLOSE, new ImageIcon(getClass().getResource("/images/icon.png")).getImage(), new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			     Toolkit.getDefaultToolkit().beep();
			     buttonList.get(1).setBackground(Color.red);
			     resetTimer.start();
			     return;
			}
		});
		p.createPanel(PanelList.get(0), new Bounds(29, 92, 239, 311).getBounds(), false);
		b.createButton(buttonList.get(0), new Bounds(10, 216, 170, 41).getBounds(), false, PanelList.get(0), true, Color.white, Color.black, false);
		b.createButton(buttonList.get(1), new Bounds(10, 260, 170, 41).getBounds(), false, PanelList.get(0), true, Color.white, Color.black, false);
		checkData("FoodAllergens.txt", "FoodRecipes.txt");
		
		for(int i = 0; i <= 1; i++) {
			buttonList.get(i).setBackground(Color.white);
			buttonList.get(i).setForeground(Color.black);
		}
		l.createLabel(labelList.get(0), createFont("Inter", Font.BOLD, 15), Color.black, new Bounds(28, -19, 181, 63).getBounds(), false, null);
		l.createLabel(labelList.get(1), createFont("Inter", Font.BOLD, 15), Color.black, new Bounds(10, 51, 118, 51).getBounds(), false, PanelList.get(0));
		l.createLabel(labelList.get(2), createFont("Inter", Font.BOLD, 15), Color.black, new Bounds(10, 73, 177, 51).getBounds(), false, PanelList.get(0));
		l.createLabel(labelList.get(3), createFont("Inter", Font.BOLD, 15), Color.black, new Bounds(10, 136, 215, 41).getBounds(), false, PanelList.get(0));
		l.createLabel(labelList.get(4), createFont("Inter", Font.BOLD, 15), Color.black, new Bounds(10, 96, 165, 41).getBounds(), false, PanelList.get(0));
		l.createLabel(labelList.get(5), createFont("Inter", Font.BOLD, 15), Color.black, new Bounds(10, 116, 165, 41).getBounds(), false, PanelList.get(0));
		l.createLabel(labelList.get(6), createFont("Inter", Font.BOLD, 15), Color.black, new Bounds(10, 156, 175, 41).getBounds(), false, PanelList.get(0));
		l.createLabel(labelList.get(7), createFont("Inter", Font.BOLD, 15), Color.black, new Bounds(10, 176, 175, 41).getBounds(), false, PanelList.get(0));
		l.createLabel(labelList.get(8), createFont("Inter", Font.BOLD, 14), Color.black, new Bounds(12, 23, 290, 41).getBounds(), false, PanelList.get(0));
		
		productBox.setFocusable(false);
		productBox.setFont(createFont("Inter", Font.BOLD, 14));
		productBox.setBounds(new Bounds(88, 31, 170, 41).getBounds());
		productBox.addActionListener(e -> {
			  if(e.getSource()==productBox) {
				  switch(productBox.getSelectedIndex()) {
				  case 0: displayInfo("Calories: 0g", "Vitamins: None", "Protein: 0g", "Sodium: 0g", "Water: 0g", "Fat: 0g", "Allergens: None", "Product: " + "Unselected");
				    new Sound().playSound("/sound/click_sound.wav");
				    break;
				  case 1: displayInfo("Calories: 332g", "Vitamins: B12, B6, Iron", "Protein: 26g", "Water: 60mg", "Sodium: 50g", "Fat: 17g (Satured 7g)", "Allergens: 1", "Product: " + "Meat"); 
				    new Sound().playSound("/sound/click_sound.wav");
				    break;
				  case 2: displayInfo("Calories: 120g", "Vitamins: A, C, K, Folate", "Protein: 3g", "Sodium: 1.5g", "Water: 150g", "Fat: 4g", "Allergens: 1", "Product: " + "Tomato Salad"); 
				    new Sound().playSound("/sound/click_sound.wav");
				    break; 
				  case 3: displayInfo("Calories: 300g", "Vitamins: C, A, K, Folate", "Protein: 30mg", "Sodium: 350mg", "Water: 160g", "Fat: 4g", "Allergens: 1", "Product: " + "Chicken Salad"); 
				    new Sound().playSound("/sound/click_sound.wav");  
				    break;
				  case 4: displayInfo("Calories: 250g", "Vitamins: A, Calcium", "Protein: 6g", "Sodium: 350mg", "Water: 0.7g", "Fat: 14g", "Allergens: 1", "Product: " + "Ice-Cream"); 
				    new Sound().playSound("/sound/click_sound.wav"); 
				    break;
				  case 5: displayInfo("Calories: 500g", "Vitamins: C, K", "Protein: 15g", "Sodium: 400mg", "Water: 90g", "Fat: 25g", "Allergens: 2", "Product: " + "Burger"); 
				    new Sound().playSound("/sound/click_sound.wav");  
				    break;
				  }
			  }
		});
		buttonList.get(0).addActionListener(e -> {
            if(e.getSource()==buttonList.get(0)) {
            	OutputManager.write("FoodRecipes.txt", "Meats: beef, salt, pepper, garlic. \nBurger: beef patty, bun, lettuce, tomato. \nIce-Cream: milk, cream, sugar, egg yolks. \nTomato Salad: tomato, olive oil, salt, vinegar, onion. \nChicken Salad: mayonnaise, celery, lettuce. ");
            	OutputManager.write("FoodAllergens.txt", "Chicken Salad: Mayonnaise - can be allergic to some people, possible risk. \nlettuce - Pretty rare allergy. \nBurger: Tomato - can be allergic to some people, low risk but possible. \nlettuce - Pretty rare allergy. \nMeats: Meat - can be allergic to some people, low risk in Many Regons but possible. \npepper - Pretty rare allergy. \nIce-Cream Milk - very high risk for someone with lactose intolerance. \nEgg yolks - Possible but rare allergy. Tomato: can be allergic to some people, low risk but possible. \nTomato Salad: olivie oil - No allergy but risky for people with high-cholesterol or digestive issues. \nChicken Salad: Mayonnaise - can be allergic to some people, possible risk. \nlettuce - Pretty rare allergy.");
            	buttonList.get(0).setEnabled(false);
            }
		});
		buttonList.get(1).addActionListener(_ -> {
		    	displayInfo("Calories: 0g", "Vitamins: None", "Protein: 0g", "Sodium: 0g", "Water: 0g", "Fat: 0g", "Allergens: None", "Product: " + "Unselected");
		    	for(JButton b : app.buttonList) {
		    		  b.setEnabled(false);
		    		  buttonList.get(1).setEnabled(true);
		    		  RecipeHandler.timer.restart();
		    		  window.dispose();
		    	}
		});
		for(int labelIndex = 1; labelIndex <= 7; labelIndex++) {
			PanelList.get(0).add(labelList.get(1));
		}
		window.getContentPane().add(PanelList.get(0));
		window.getContentPane().add(labelList.get(0));
		window.getContentPane().add(productBox);
		if(App.mode.equals("Dark")) {
			StartupScreen.setMode("Dark",  null);
			for(int i = 0; i < labelList.size(); i++) {
				labelList.get(i).setForeground(Color.white);
			}
			buttonList.get(0).setForeground(Color.white);
			buttonList.get(0).setBackground(Color.black);
			buttonList.get(1).setForeground(Color.white);
			buttonList.get(1).setBackground(Color.black);
			window.setVisible(true);
			return;
		}else if(App.mode.equals("Light")) {
			StartupScreen.setMode("Light",  null);
			for(int i = 0; i < labelList.size(); i++) {
				labelList.get(i).setForeground(Color.black);				
			}
			buttonList.get(0).setForeground(Color.black);
			buttonList.get(0).setBackground(Color.white);
			buttonList.get(1).setForeground(Color.black);
			buttonList.get(1).setBackground(Color.white);
			window.setVisible(true);
			return;
		}
	}
	private Font createFont(String fontName, int type, int size) {
		return new Font(fontName, type, size);
	}
	private void displayInfo(String caloriesInf, String vitaminInf, String proteinInf, String sodiumInf, String waterInf, String fatInf, String allergenInf, String productInf) {
       text = new String[] {productInf, caloriesInf, vitaminInf, proteinInf, sodiumInf, fatInf, waterInf, allergenInf};
       for(int i = 0; i < text.length; i++) { 
            labelList.get(i).setText(text[i]);
       }
    }
	private void checkData(String allergenFile, String RecipeFile) {
		if(new File(allergenFile).exists() && new File(RecipeFile).exists()) {
			buttonList.get(0).setEnabled(false);
		    buttonList.get(0).setToolTipText("Data is already requested, please move file somewhere else and try again.");
		}else {
			buttonList.get(0).setEnabled(true);
			return;
		}
	}
}
