package recipeSystem;

import javax.swing.*;

import Tools.Language;

import java.awt.Font;
import main.App;

public class RecipeHandler {
    private int counter = 0, allergenAmount = 0;
    public static Timer timer;
    
    public RecipeHandler() {
        timer = new Timer(1000, _ -> {
            counter++;
            if (counter == 10) {
                timer.stop();
                for (JButton b : App.buttonList) {
                    b.setEnabled(false);
                }
                counter = 0;
                allergenAmount = 0;
                
                for(int i = 4; i <= 8; i++) App.labelList.get(i).setText("");
                
                if(Language.currentLanguage.equals("Armenian")) {
                	App.labelList.get(9).setText("Ալերգեններ՝:");
                }else {
                	App.labelList.get(9).setText("Allergens:");
                }
                App.labelList.get(10).setText("0");

                for(int i = 0; i <= 4; i++) App.buttonList.get(i).setEnabled(true);
                for(int i = 0; i <= 5; i++) App.buttonList.get(i).setEnabled(true);
                
                App.buttonList.get(6).setVisible(false);
                App.buttonList.get(6).setEnabled(true);
            }
        });
    }
    public void startRecipeSystem() {
    	if(Language.currentLanguage.equals("Armenian")) {
    		for(int i = 4; i <= 8; i++) App.labelList.get(i).setFont(new Font("Verdana", Font.BOLD, 8));
    	}else {
    		for(int i = 4; i <= 8; i++) App.labelList.get(i).setFont(new Font("Inter", Font.BOLD, 12));
    	}
    	App.buttonList.get(6).addActionListener(_ -> {
            timer.stop();
            App.mt.openMoreTab();
            App.buttonList.get(6).setVisible(false);
            for (JButton b : App.buttonList) b.setEnabled(false);
            App.buttonList.get(5).setEnabled(true);
        });
    	App.buttonList.get(0).addActionListener(_ -> {
            if (!timer.isRunning()) {
                timer.start();
            }
            if(Language.currentLanguage.equals("Armenian")) {
            	App.labelList.get(4).setText("տավարի կոտլետ, բուլկի, սալաթ, Լոլիկ");
            }else {
            	App.labelList.get(4).setText("beef patty, bun, lettuce, tomato");
            }
            allergenAmount += 1;
            App.labelList.get(10).setText("" + allergenAmount);
            App.buttonList.get(0).setEnabled(false);
            App.buttonList.get(6).setVisible(true);
        });
        App.buttonList.get(1).addActionListener(_ -> {
            if(Language.currentLanguage.equals("Armenian")) {
            	App.labelList.get(5).setText("տավարի միս, աղ, պղպեղ, սխտոր");
            }else {
            	App.labelList.get(5).setText("beef, salt, pepper, garlic");
            }
            allergenAmount += 1;
            App.labelList.get(10).setText("" + allergenAmount);
            App.buttonList.get(1).setEnabled(false);
        });
        App.buttonList.get(2).addActionListener(_ -> {
            if(Language.currentLanguage.equals("Armenian")) {
            	App.labelList.get(6).setText("կաթ, կրեմ, շաքար, ձվի դեղնուցներ");
            }else {
            	App.labelList.get(6).setText("milk, cream, sugar, egg yolks");
            }
            allergenAmount += 1;
            App.labelList.get(10).setText("" + allergenAmount);
            App.buttonList.get(2).setEnabled(false);
        });
        App.buttonList.get(3).addActionListener(_ -> {
             if(Language.currentLanguage.equals("Armenian")) {
            	 App.labelList.get(7).setText("մայոնեզ, նեխուր, աղցան");
            }else {
            	App.labelList.get(7).setText("mayonnaise, celery, lettuce");
            }
            allergenAmount += 1;
            App.labelList.get(10).setText("" + allergenAmount);
            App.buttonList.get(3).setEnabled(false);
        });
        App.buttonList.get(4).addActionListener(_ -> {
            if(Language.currentLanguage.equals("Armenian")) {
            	App.labelList.get(8).setText("լոլիկ, ձիթապտղի յուղ, աղ, քացախ");
            }else {
            	App.labelList.get(8).setText("tomato, olive oil, salt, vinegar");
            }
            allergenAmount += 1;
            App.labelList.get(10).setText("" + allergenAmount);
            App.buttonList.get(4).setEnabled(false);
        });
    }
}
