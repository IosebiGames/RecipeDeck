package Tools;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import main.App;

public class Language {
	private static String[] EnglishLabel = {"Foods & Drinks", "", "", "Recipes", "", "", "", "", "", "Allergens:", "0", "Total Cost:", "0" + "$", "", "", "", "", "", "", "Please Select Any Product."};
	private static String[] ArmenianLabel = {"Կերակուր և ըպելիք", "", "", "Բաղադրատոմսեր", "", "", "", "", "", "Ալերգեններ:", "0", "Ընդհանուր արժեքը:", "0" + "$", "", "", "", "", "", "", "Խնդրում ենք ընտրել ցանկացած ապրանք."};
	private static String[] EnglishButtonTexts = {"Burger", "Steak", "Ice-Cream", "Chicken Salad", "Tomato Salad", "Next", "More"};
	private static  String[] ArmenianButtonTexts = {"Բուրգեր", "Սթեյք", "Պաղպաղակ", "Հավի աղցան", "Լոլիկի աղցան", "Հաջորդը", "Ավելին"};

	public static String currentLanguage;
	private static String[] EnglishProducts = new String[] {"Unselected", "Meat", "Tomato Salad", "Chicken Salad", "Ice-Cream", "Burger"};
	private static String[] ArmenianProducts = new String[] {"չընտրված", "Միս", "Լոլիկի աղցան", "Հավի աղցան", "Պաղպաղակ", "Սթեյք"};
	private static String[] EnglishLabelText = new String[] {"Product: " + "Unselected", "Calories: " + "0g", "Vitamins: " + "None", "Fats: " + "0g", "Sodium: " + "0g", "Protein: " + "0g", "Water: " + "0g", "Allergens: " + "None", "See Nutritional details below:"};
	private static String[] ArmenianLabelText = new String[] {"Ապրանք: " + "չընտրված", "Կալորիականություններ: " + "0g", "Վիտամիններ: " + "Ոչ մեկը", "Ճարպեր: " + "0g", "Նատրիում: " + "0g", "Սպիտակուցներ: " + "0g", "Ջուր: " + "0g", "Ալերգեններ: " + "Ոչ մեկը", "Սննդային արժեքի մանրամասները տե՛ս ստորև:"};
	private static String[] returnable, returnable2;

	public static void translate(String language) {
		if(language.equals("English")) {
			for(String labelText : EnglishLabel) {
				App.labelList.add(new JLabel(labelText));
			}for(String buttonText : EnglishButtonTexts) {
				App.buttonList.add(new JButton(buttonText));
			}
			currentLanguage = "English";
		}else if(language.equals("Armenian")) {
			for(String labelText : ArmenianLabel) {
				App.labelList.add(new JLabel(labelText));
			}for(String buttonText : ArmenianButtonTexts) {
				App.buttonList.add(new JButton(buttonText));
			}
			currentLanguage = "Armenian";
		}
	}
    public void adapt() {
    	App.labelList.get(0).setFont(new Font("Inter", Font.BOLD, 17));
    	App.labelList.get(19).setFont(new Font("Inter", Font.BOLD, 11));
    	App.labelList.get(19).setBounds(new Bounds(15, 214, 340, 40).getBounds());
    	App.labelList.get(11).setFont(new Font("Inter", Font.BOLD, 17));
    	App.labelList.get(11).setBounds(new Bounds(36, 5, 271, 40).getBounds());
    	App.labelList.get(3).setFont(new Font("Inter", Font.BOLD, 18));
    	App.labelList.get(3).setBounds(new Bounds(30, 11, 291, 40).getBounds());
    	App.labelList.get(6).setBounds(new Bounds(120, 153, 176, 18).getBounds());
    }
    public static String[] initProducts(String language) {
    	if(language.equals("Armenian")) {
    		returnable = ArmenianProducts;
    	}else if(language.equals("English")) {
    		returnable = EnglishProducts;
    	}
    	return returnable;
    }
    public static String[] initLabelText(String language) {
    	if(language.equals("Armenian")) {
    		returnable2 = ArmenianLabelText;
    	}else if(language.equals("English")) {
    		returnable2 = EnglishLabelText;
    	}
    	return returnable2;
    }
}