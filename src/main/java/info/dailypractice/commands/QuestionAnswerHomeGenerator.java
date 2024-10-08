package info.dailypractice.commands;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import info.dailypractice.entity.HyperlinksWithCountList;
import info.dailypractice.entity.HyperlinksWithDescription;
import info.dailypractice.entity.QuestionAnswerHomePageConfiguration;
import info.dailypractice.entity.QuestionAnswerKuralConfiguration;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@ShellComponent
public class QuestionAnswerHomeGenerator {
    @Autowired
    private ObjectMapper objectMapper;

    @ShellMethod("generate thirukkural Question Answer")
    public void generateThirukkuralQuestionAnswerHome(String qaHomePageConfigurationFilepath, String qaConfigurationFilepath) throws IOException, RuntimeException, TemplateException {
        QuestionAnswerHomePageConfiguration questionAnswerHomePageConfiguration = objectMapper.readValue(new File(qaHomePageConfigurationFilepath), QuestionAnswerHomePageConfiguration.class);

        List<QuestionAnswerKuralConfiguration> questionAnswerKuralConfigurationList = objectMapper.readValue(new File(qaConfigurationFilepath), new TypeReference<>() {
        });

        ArrayList<HyperlinksWithDescription> hyperlinksWithDescriptionList = new ArrayList<>();

        IntStream.range(0, questionAnswerKuralConfigurationList.size()).forEach(i -> {
            System.out.println(i);
            QuestionAnswerKuralConfiguration questionAnswerKuralConfiguration = questionAnswerKuralConfigurationList.get(i);
            HyperlinksWithDescription hyperlinksWithDescription = new HyperlinksWithDescription();

//            The htmls files are present in the same directory. so href can be only the filename
            String fileNumber = String.format("%03d", (i + 1));
            String url = questionAnswerKuralConfiguration.getOutputFilename() + fileNumber + ".html";
            hyperlinksWithDescription.setUrl(url);
            hyperlinksWithDescription.setText(questionAnswerKuralConfiguration.getTitle());
            hyperlinksWithDescription.setDescription(questionAnswerKuralConfiguration.getCategory());
            hyperlinksWithDescriptionList.add(hyperlinksWithDescription);
        });

        doProcess(questionAnswerHomePageConfiguration, hyperlinksWithDescriptionList);
    }

    private void doProcess(QuestionAnswerHomePageConfiguration questionAnswerHomePageConfiguration, List<HyperlinksWithDescription> hyperlinksWithDescriptionList) throws IOException, TemplateException {
        validateConfiguration(questionAnswerHomePageConfiguration);
        processTemplateFile(questionAnswerHomePageConfiguration, hyperlinksWithDescriptionList);
        Path sourcePath = Paths.get(questionAnswerHomePageConfiguration.getTemplateFileAbsolutePath());
        copyStylesDirectoryToOutput(questionAnswerHomePageConfiguration, sourcePath);
    }

    private static void copyStylesDirectoryToOutput(QuestionAnswerHomePageConfiguration questionAnswerHomePageConfiguration, Path sourcePath) throws IOException {
        Path stylesSourceDirectory = Paths.get(sourcePath.getParent().toString(), "styles");
        Path targetPath = Paths.get(questionAnswerHomePageConfiguration.getOutputFileAbsolutePath());
        Path stylesTargetDirectory = Paths.get(targetPath.getParent().toString(), "styles");
        FileUtils.copyDirectory(stylesSourceDirectory,stylesTargetDirectory);
    }

    private void processTemplateFile(QuestionAnswerHomePageConfiguration questionAnswerHomePageConfiguration, List<HyperlinksWithDescription> hyperlinksWithDescriptionList) throws IOException, TemplateException {
        Path template = Paths.get(questionAnswerHomePageConfiguration.getTemplateFileAbsolutePath());
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

        FileUtils.createDirectory(questionAnswerHomePageConfiguration.getOutputFileAbsolutePath());

        try (OutputStream outputStream = new FileOutputStream(Paths.get(questionAnswerHomePageConfiguration.getOutputFileAbsolutePath()).toString());
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8)) {
            String information = MessageFormat.format("Processing template for: {0} -  Output File: {1}", questionAnswerHomePageConfiguration.getTemplateFileAbsolutePath(), questionAnswerHomePageConfiguration.getOutputFileAbsolutePath());
            System.out.println(information);

            Map data = new HashMap();
            data.put("qahc", questionAnswerHomePageConfiguration);
            data.put("hyperlinksWithDescriptionList", hyperlinksWithDescriptionList);

            temp.process(data, outputStreamWriter);
        }
    }

    private void validateConfiguration(QuestionAnswerHomePageConfiguration questionAnswerHomePageConfiguration) throws FileNotFoundException {
        if (!Files.exists(Path.of(questionAnswerHomePageConfiguration.getTemplateFileAbsolutePath()))) {
            System.out.println("File does not exist: " + questionAnswerHomePageConfiguration.getTemplateFileAbsolutePath());
            throw new FileNotFoundException(questionAnswerHomePageConfiguration.getTemplateFileAbsolutePath());
        }
    }
}
