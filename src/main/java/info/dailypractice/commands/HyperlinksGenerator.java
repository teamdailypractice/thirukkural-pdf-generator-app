package info.dailypractice.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import info.dailypractice.entity.HyperlinksList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.io.File;
import java.io.IOException;

@ShellComponent
public class HyperlinksGenerator {
    @Autowired
    private ObjectMapper objectMapper;

    @ShellMethod("generate home page with list of links")
    public void generateHomePage(String jsonFilePath) {
        // Specify the path of your JSON file or the JSON content
        try {
            // Read JSON file and convert to Java object
            HyperlinksList hyperlinksList = objectMapper.readValue(new File(jsonFilePath), HyperlinksList.class);

            // Print the converted object
            System.out.println(hyperlinksList);
            System.out.println(hyperlinksList.getTitle());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
