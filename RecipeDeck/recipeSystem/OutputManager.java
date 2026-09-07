package recipeSystem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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
             Files.writeString(Path.of(path), content);
       }catch(IOException e) {
			System.out.println("Can't write " + path + ": " + e.getMessage());
		}
	}
}
