package recipeSystem;

import javax.swing.*;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import Tools.Language;
import main.App;

public class RecipeHandler {
    private int counter = 0, allergenAmount = 0;
    public static Timer timer;
    private String recipe;
    
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
                if(!new File("src/output/UserRecipe.txt").exists()) {
                	App.buttonList.get(7).setEnabled(true);
                	App.buttonList.get(8).setEnabled(true);
                }else {
                	App.buttonList.get(8).setEnabled(true);
                	App.buttonList.get(9).setEnabled(true);
                	App.buttonList.get(10).setEnabled(true);
                }
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
        if(new File("src/output/UserRecipe.txt").exists()) {
           	App.buttonList.get(9).setEnabled(true);
           	App.buttonList.get(10).setEnabled(true);
        	App.buttonList.get(7).setEnabled(false);
        }else if(!new File("src/output/UserRecipe.txt").exists()) {
        	App.buttonList.get(9).setEnabled(false);
        	App.buttonList.get(10).setEnabled(false);
        }
        App.buttonList.get(7).addActionListener(_ -> {
             recipe = JOptionPane.showInputDialog(null, "Please enter Recipe that you wish to save.", "RecipeDeck", JOptionPane.QUESTION_MESSAGE);
             if(recipe == null) {
                recipe = "";
             }
             if(recipe.isBlank()) {
             	JOptionPane.showMessageDialog(null, "Please fill the Box to save Recipe.", "RecipeDeck", JOptionPane.PLAIN_MESSAGE);
             }else if(recipe.length() < 10) {
            	 JOptionPane.showMessageDialog(null, "Following Recipe is too short. No less than 10 characters.", "RecipeDeck", JOptionPane.PLAIN_MESSAGE);
             }else if(recipe.length() > 110) {
            	 JOptionPane.showMessageDialog(null, "Following Recipe is too long. No more than 110 characters.", "RecipeDeck", JOptionPane.PLAIN_MESSAGE);
             }
             else {
                OutputManager.writeUserRecipe("src/output/UserRecipe.txt", recipe);
                App.buttonList.get(7).setEnabled(false);
                App.buttonList.get(9).setEnabled(true);
                App.buttonList.get(10).setEnabled(true);
             }
        });
        App.buttonList.get(8).addActionListener(_ -> {
        	if(new File("src/output/UserRecipe.txt").exists()) {
        		try (BufferedReader br = new BufferedReader(new FileReader("src/output/UserRecipe.txt"))) {
        			JOptionPane.showMessageDialog(null, br.readLine(), "RecipeDeck", JOptionPane.PLAIN_MESSAGE);
        			br.close();
        		}catch(IOException e) {
        			System.out.println("Can't load User saved Recipe: " + e.getMessage());        		
        		}
        	}else {
        		JOptionPane.showMessageDialog(null, "You haven't saved any Recipe yet.", "RecipeDeck", JOptionPane.PLAIN_MESSAGE);
        	}
        });
        App.buttonList.get(9).addActionListener(_ -> {
        	recipe = JOptionPane.showInputDialog(null, "Enter new Recipes:", "RecipeDeck", JOptionPane.PLAIN_MESSAGE);
            if(recipe == null) {
                recipe = "";
             }
             if(recipe.isBlank()) {
               	JOptionPane.showMessageDialog(null, "Please fill the box for new Recipe.", "RecipeDeck", JOptionPane.PLAIN_MESSAGE);
             }else if(recipe.length() < 10) {
                JOptionPane.showMessageDialog(null, "Following Recipe is too short. No less than 10 characters.", "RecipeDeck", JOptionPane.PLAIN_MESSAGE);
             }else if(recipe.length() > 110) {
                JOptionPane.showMessageDialog(null, "Following Recipe is too long. No more than 110 characters.", "RecipeDeck", JOptionPane.PLAIN_MESSAGE);
             }else {
                OutputManager.writeUserRecipe("src/output/UserRecipe.txt", recipe);
             }
        });
        App.buttonList.get(10).addActionListener(_ -> {
             if(Files.exists(Path.of("src/output/UserRecipe.txt"))) {
            	 App.buttonList.get(7).setEnabled(true);
            	 App.buttonList.get(9).setEnabled(false);
            	 App.buttonList.get(10).setEnabled(false);
            	 try {
					Files.delete(Path.of("src/output/UserRecipe.txt"));
				 } catch(IOException e) {
					System.out.println("Failed to delete custom Recipe: " + e.getMessage());
				 }
             }
        });
     }
}
