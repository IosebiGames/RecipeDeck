package recipeSystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class OutputManager {
	private static String content, mode;
	
	public static void writeUserRecipe(String path, String userRecipe) {
		try {
            Files.writeString(Path.of(path), userRecipe);
		}catch(IOException e) {
			System.out.println("Can't write " + path + ": " + e.getMessage());
		}
	}
	public static void write(String path, String content) {
		try {
             Files.writeString(Path.of(path), content);
       }catch(IOException e) {
			System.out.println("Can't write " + path + ": " + e.getMessage());
		}
	}
	public static String read(String path) {
		   try(BufferedReader br = new BufferedReader(new FileReader(path))){
				content = br.readAllAsString();
				if(content.equals("Dark")) {
					mode = "Dark";
				}else if(content.equals("Light")) {
					mode = "Light";
				}
				if(content != null) {
					br.close();
				}
			}catch(IOException e) {
				System.out.println("Can't read theme type: " + e.getMessage());
			}
		return mode;
	}
}
