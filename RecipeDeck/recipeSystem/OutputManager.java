package recipeSystem;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class OutputManager {
	public static void write(String name, String content) {
		try (BufferedWriter writer = Files.newBufferedWriter(Path.of(name))) {
		      writer.write(content);
		      writer.close();
		}catch(IOException e) {
			System.out.println("Can't write " + name + ": " + e.getMessage());
		}
	}
}