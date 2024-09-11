package info.dailypractice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import info.dailypractice.entity.BookConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BookConfigurationTests {

    String jsonData = """
            {
                "bookName": "thirukkural",
                "contentStructure": [
                  "lineNumber",
                  "line1"
                ],
                "templateFileAbsolutePath": "D:/git/spring-boot-learning/data-jpa-sqlite/data-in/templates/thirukkural/book.ftl",
                "outputFileAbsolutePath": "D:/git/spring-boot-learning/data-jpa-sqlite/data-out/thirukkural.typ"
              }
            """;

    @Test
    public void testJsonStringToBookConfiguration() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        BookConfiguration bookConfiguration = null;

        bookConfiguration = objectMapper.readValue(jsonData, BookConfiguration.class);
        System.out.println(bookConfiguration);
        Assertions.assertEquals("thirukkural", bookConfiguration.getBookName());
        Assertions.assertArrayEquals(new String[]{"lineNumber", "line1"}, bookConfiguration.getContentStructure().toArray(new String[0]));
        Assertions.assertEquals("D:/git/spring-boot-learning/data-jpa-sqlite/data-in/templates/thirukkural/book.ftl", bookConfiguration.getTemplateFileAbsolutePath());
        Assertions.assertEquals("D:/git/spring-boot-learning/data-jpa-sqlite/data-out/thirukkural.typ", bookConfiguration.getOutputFileAbsolutePath());

    }
}