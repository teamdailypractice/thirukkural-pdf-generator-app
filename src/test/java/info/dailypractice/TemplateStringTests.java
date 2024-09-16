package info.dailypractice;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.MessageFormat;

public class TemplateStringTests {

    @Test
    public void templateStringVariableSubstitute() throws IOException {

        int age = 45;
        String message = """
                Welcome! {0}
                Hello! {1}
                """;

        String finalMessage = MessageFormat.format(message, "mani", age);
        System.out.println(finalMessage);
    }
}
