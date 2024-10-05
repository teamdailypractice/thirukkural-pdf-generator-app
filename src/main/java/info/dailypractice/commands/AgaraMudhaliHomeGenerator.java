package info.dailypractice.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import info.dailypractice.entity.HyperlinksList;
import info.dailypractice.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

@ShellComponent
public class AgaraMudhaliHomeGenerator {
    @Autowired
    private ObjectMapper objectMapper;

    @ShellMethod("generate agaramudhali html files as per configuration")
    public void generateAgaraMudhaliHomePage(String dataFilepath) throws TemplateException, IOException {
        HyperlinksList hyperlinksList = objectMapper.readValue(new File(dataFilepath), HyperlinksList.class);
        doProcess(hyperlinksList);
    }

    private void doProcess(HyperlinksList hyperlinksList) throws IOException, TemplateException {
        validateConfiguration(hyperlinksList);
        processTemplateFile(hyperlinksList);
    }

    private void validateConfiguration(HyperlinksList hyperlinks) throws FileNotFoundException {

        if (!Files.exists(Path.of(hyperlinks.getTemplateFileAbsolutePath()))) {
            System.out.println("File does not exist: " + hyperlinks.getTemplateFileAbsolutePath());
            throw new FileNotFoundException(hyperlinks.getTemplateFileAbsolutePath());
        }
    }

    private void processTemplateFile(HyperlinksList hyperlinks) throws IOException, TemplateException {
        Path template = Paths.get(hyperlinks.getTemplateFileAbsolutePath());
        String templateFileDirectory = template.getParent().toString();
        String templateFilename = template.getFileName().toString();
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setDirectoryForTemplateLoading(new File(templateFileDirectory));
        // Recommended settings for new projects:
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setFallbackOnNullLoopVariable(false);

        Template temp = cfg.getTemplate(templateFilename);

        FileUtils.createDirectory(hyperlinks.getOutputFileAbsolutePath());

        try (OutputStream outputStream = new FileOutputStream(Paths.get(hyperlinks.getOutputFileAbsolutePath()).toString());
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8)) {
            String information = MessageFormat.format("Processing template for: {0} -  Output File: {1}", hyperlinks.getTemplateFileAbsolutePath(), hyperlinks.getOutputFileAbsolutePath());
            System.out.println(information);

            Map data = new HashMap();
            data.put("hyperlinks", hyperlinks);

            temp.process(data, outputStreamWriter);
        }
    }

}
