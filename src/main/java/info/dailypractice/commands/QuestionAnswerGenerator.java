package info.dailypractice.commands;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import info.dailypractice.entity.AgaraMudhaliConfiguration;
import info.dailypractice.entity.QuestionAnswerKural;
import info.dailypractice.entity.QuestionAnswerKuralConfiguration;
import info.dailypractice.entity.ThirukkuralAgaraMudhali;
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
import java.util.*;
import java.util.stream.IntStream;

@ShellComponent
public class QuestionAnswerGenerator {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ThirukkuralService thirukkuralService;

    @ShellMethod("generate thirukkural Question Answer")
    public void generateThirukkuralQuestionAnswer(String dataFilepath) throws IOException, RuntimeException, TemplateException {
        List<QuestionAnswerKuralConfiguration> questionAnswerKuralConfigurationList = objectMapper.readValue(new File(dataFilepath), new TypeReference<>() {
        });

        IntStream.range(0, questionAnswerKuralConfigurationList.size()).forEach(i -> {
            QuestionAnswerKuralConfiguration questionAnswerKuralConfiguration = questionAnswerKuralConfigurationList.get(i);
            try {
                setOutputFilename(questionAnswerKuralConfiguration, i);
                doProcess(questionAnswerKuralConfiguration);
            } catch (IOException | TemplateException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void validateConfiguration(QuestionAnswerKuralConfiguration questionAnswerKuralConfiguration) throws FileNotFoundException {

        if (!Files.exists(Path.of(questionAnswerKuralConfiguration.getTemplateFileAbsolutePath()))) {
            System.out.println("File does not exist: " + questionAnswerKuralConfiguration.getTemplateFileAbsolutePath());
            throw new FileNotFoundException(questionAnswerKuralConfiguration.getTemplateFileAbsolutePath());
        }
    }

    private void setOutputFilename(QuestionAnswerKuralConfiguration questionAnswerKuralConfiguration, int index) {
        String fileNumber = String.format("%03d", (index + 1));
        String filename = questionAnswerKuralConfiguration.getOutputFilename() + fileNumber + ".html";
        questionAnswerKuralConfiguration.setOutputFilename(filename);
    }

    private void doProcess(QuestionAnswerKuralConfiguration questionAnswerKuralConfiguration) throws IOException, TemplateException {
        System.out.println("processing: " + questionAnswerKuralConfiguration);
        validateConfiguration(questionAnswerKuralConfiguration);
        List<QuestionAnswerKural> questionAnswerKuralList = questionAnswerKuralConfiguration.getQuestionAnswerKuralList();

        LinkedHashMap<Integer, List<ThirukkuralAgaraMudhali>> questionThirukkuralDetailsResultMap = new LinkedHashMap<>();

        IntStream.range(0, questionAnswerKuralConfiguration.getQuestionAnswerKuralList().size()).forEach(i -> {
            QuestionAnswerKural questionAnswerKural = questionAnswerKuralConfiguration.getQuestionAnswerKuralList().get(i);
            List<ThirukkuralAgaraMudhali> answerThirukkuralDetails = thirukkuralService.getThirukkuralDetails(questionAnswerKuralConfiguration.getFirstKuralId(),
                    questionAnswerKuralConfiguration.getLastKuralId(),
                    questionAnswerKural.getAnswerKuralIds());
            questionThirukkuralDetailsResultMap.put(i, answerThirukkuralDetails);
        });

        generateHtmlFile(questionAnswerKuralConfiguration, questionThirukkuralDetailsResultMap);
    }

    private void generateHtmlFile(QuestionAnswerKuralConfiguration qac, HashMap<Integer, List<ThirukkuralAgaraMudhali>> questionThirukkuralDetailsResultMap) throws TemplateException, IOException {
        processTemplateFile(qac, questionThirukkuralDetailsResultMap);
    }

    private void processTemplateFile(QuestionAnswerKuralConfiguration qac, HashMap<Integer, List<ThirukkuralAgaraMudhali>> questionThirukkuralDetailsResultMap) throws IOException, TemplateException {
        Path template = Paths.get(qac.getTemplateFileAbsolutePath());
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

        FileUtils.createDirectory(qac.getOutputFileAbsolutePath());

        try (OutputStream outputStream = new FileOutputStream(Paths.get(qac.getOutputFileAbsolutePath(), qac.getOutputFilename()).toString());
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8)) {
            String information = MessageFormat.format("Processing template for: {0} -  Output File: {1}", qac.getTitle(), qac.getOutputFileAbsolutePath());
            System.out.println(information);

            Map<String, Object> data = new HashMap<>();

            data.put("qac", qac);
            data.put("questionThirukkuralDetailsResultMap", questionThirukkuralDetailsResultMap);

            temp.process(data, outputStreamWriter);

        }
    }


}
