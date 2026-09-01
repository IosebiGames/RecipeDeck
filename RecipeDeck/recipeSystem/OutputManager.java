package recipeSystem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import Tools.Decorator;
import Tools.Language;

public class OutputManager {
	public static void writeUserRecipe(String path, String userRecipe) {
		try {
            Files.writeString(Path.of(path), userRecipe);
		}catch(IOException e) {
			System.out.println("Can't write " + path + ": " + e.getMessage());
		}
	}
	public static void write(String path, String content) {
		try {
            if(Language.currentLanguage.equals("Armenian")) {
            	  Files.writeString(Path.of(path), content + "\nArmenian");
            }else if(Language.currentLanguage.equals("English")) {
            	  Files.writeString(Path.of(path), content + "\nEnglish");
            }
		}catch(IOException e) {
			System.out.println("Can't write " + path + ": " + e.getMessage());
		}
	}
	public static void write(String path, String content, boolean Armenian) {
		 try {
               if(Armenian) {
               	  Files.writeString(Path.of(path), content + "\nArmenian");
               }else {
               	  Files.writeString(Path.of(path), content + "\nEnglish");
               }
    	}catch(IOException e) {
			System.out.println("Can't write " + path + ": " + e.getMessage());
		}
	}
	public static void translate(boolean Armenian) {
		if(Armenian) {
		   write("src/output/payment.txt", String.valueOf(Decorator.addings), true);	
		}else {
           write("src/output/payment.txt", String.valueOf(Decorator.addings), false);
	   }  
	}
}
