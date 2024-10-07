package info.dailypractice.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import info.dailypractice.dto.ThirukkuralTopicDto;
import info.dailypractice.entity.ThirukkuralTopicsConfiguration;
import info.dailypractice.service.ThirukkuralService;
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
import java.util.List;
import java.util.Map;

@ShellComponent
public class ThirukkuralTopicsHomeGenerator {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ThirukkuralService thirukkuralService;

    @ShellMethod("generate thirukkural topics listing home page")
    public void generateThirukkuralTopicsHomePage(String dataFilepath) throws IOException, RuntimeException, TemplateException {

        ThirukkuralTopicsConfiguration thirukkuralTopicsConfiguration = objectMapper.readValue(new File(dataFilepath), ThirukkuralTopicsConfiguration.class);
        doProcess(thirukkuralTopicsConfiguration);
    }

    private void doProcess(ThirukkuralTopicsConfiguration thirukkuralTopicsConfiguration) throws IOException, TemplateException {
        validateConfiguration(thirukkuralTopicsConfiguration);
        processTemplateFile(thirukkuralTopicsConfiguration);
    }

    private void validateConfiguration(ThirukkuralTopicsConfiguration thirukkuralTopicsConfiguration) throws FileNotFoundException {

        if (!Files.exists(Path.of(thirukkuralTopicsConfiguration.getTemplateFileAbsolutePath()))) {
            System.out.println("File does not exist: " + thirukkuralTopicsConfiguration.getTemplateFileAbsolutePath());
            throw new FileNotFoundException(thirukkuralTopicsConfiguration.getTemplateFileAbsolutePath());
        }
    }

    private void processTemplateFile(ThirukkuralTopicsConfiguration thirukkuralTopicsConfiguration) throws IOException, TemplateException {
        Path template = Paths.get(thirukkuralTopicsConfiguration.getTemplateFileAbsolutePath());
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

        FileUtils.createDirectory(thirukkuralTopicsConfiguration.getOutputFileAbsolutePath());

        try (OutputStream outputStream = new FileOutputStream(Paths.get(thirukkuralTopicsConfiguration.getOutputFileAbsolutePath()).toString());
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8)) {
            String information = MessageFormat.format("Processing template for: {0} -  Output File: {1}", thirukkuralTopicsConfiguration.getTemplateFileAbsolutePath(), thirukkuralTopicsConfiguration.getOutputFileAbsolutePath());
            System.out.println(information);

            Map data = new HashMap();

            List<ThirukkuralTopicDto> thirukkuralTopicNames = thirukkuralService.getThirukkuralTopicNames(thirukkuralTopicsConfiguration.getFirstTopicId(),
                    thirukkuralTopicsConfiguration.getLastTopicId());
            data.put("thirukkuralTopicNames", thirukkuralTopicNames);
            data.put("thirukkuralTopicsConfiguration", thirukkuralTopicsConfiguration);

            temp.process(data, outputStreamWriter);
        }
    }

}

