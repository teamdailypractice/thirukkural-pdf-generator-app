package info.dailypractice;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;

public class FreeMarkerTemplateTests {

    @Test
    public void testListIndex() throws IOException {
        String templateString = """
                <#assign ages = [100, 200, 300]>
                <#list ages as age >
                ${age}
                </#list>
                """;
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_33);
//        Template t =  new Template();
//        Template template = cfg.getTemplate();
//        StringWriter writer = new StringWriter();
//        template.dump(writer);
//        System.out.println(writer.toString());
    }
}
