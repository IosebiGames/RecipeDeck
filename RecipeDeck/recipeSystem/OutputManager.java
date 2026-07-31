package recipeSystem;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import Tools.Language;

public class OutputManager {
	public static void write(String path, String content) {
		try (BufferedWriter writer = Files.newBufferedWriter(Path.of(path))) {
              if(Language.currentLanguage.equals("Armenian")) {
            	  writer.write(content);
            	  writer.newLine();
            	  writer.write("Armenian");
              }else if(Language.currentLanguage.equals("English")) {
            	  writer.write(content);
                  writer.newLine();
            	  writer.write("English");
              }
		   writer.close();
		}catch(IOException e) {
			System.out.println("Can't write " + path + ": " + e.getMessage());
		}
	}
	public static void write(String path, String content, boolean Armenian) {
		try (BufferedWriter writer = Files.newBufferedWriter(Path.of(path))) {
               if(Armenian) {
            	   writer.write(content);
            	   writer.newLine();
            	   writer.write("Armenian");
               }else {
            	   writer.write(content);
            	   writer.newLine();
            	   writer.write("English");
               }
            writer.close();
		}catch(IOException e) {
			System.out.println("Can't write " + path + ": " + e.getMessage());
		}
	}	
}
