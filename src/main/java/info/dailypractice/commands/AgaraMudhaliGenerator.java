package info.dailypractice.commands;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import info.dailypractice.entity.AgaraMudhaliConfiguration;
import info.dailypractice.entity.ThirukkuralAgaraMudhali;
import info.dailypractice.html.AgaraMudhaliService;
import info.dailypractice.service.AgaraMudhaliConfigurationProvider;
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
public class AgaraMudhaliGenerator {
    @Autowired
    private AgaraMudhaliService agaraMudhaliService;
    @Autowired
    private AgaraMudhaliConfigurationProvider agaraMudhaliConfigurationProvider;

    public AgaraMudhaliGenerator(AgaraMudhaliConfigurationProvider agaraMudhaliConfigurationProvider) {
        this.agaraMudhaliConfigurationProvider = agaraMudhaliConfigurationProvider;
    }

    public AgaraMudhaliGenerator() {
    }



    @ShellMethod("generate agaramudhali html files as per configuration")
    public void generateAgaraMudhaliFiles(String dataFilepath) throws IOException, RuntimeException {
        agaraMudhaliConfigurationProvider.getAgaraMudhaliConfiguration(dataFilepath).
                forEach(agaraMudhaliConfiguration -> {
                    try {
                        doProcess(agaraMudhaliConfiguration);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    private void doProcess(AgaraMudhaliConfiguration agaraMudhaliConfiguration) throws IOException, TemplateException {
        validateAgaraMudhaliConfiguration(agaraMudhaliConfiguration);

        for (int i = 0; i < agaraMudhaliConfiguration.getStartingCharacter().size(); i++) {
            AgaraMudhaliConfiguration amc = new AgaraMudhaliConfiguration();
            amc.setFirstKuralId(agaraMudhaliConfiguration.getFirstKuralId());
            amc.setLastKuralId(agaraMudhaliConfiguration.getLastKuralId());
            amc.setTemplateFileAbsolutePath(agaraMudhaliConfiguration.getTemplateFileAbsolutePath());
            amc.setStartingCharacter(List.of(agaraMudhaliConfiguration.getStartingCharacter().get(i)));
            amc.setCurrentItem(agaraMudhaliConfiguration.getStartingCharacter().get(i));
            String currentPageName = agaraMudhaliConfiguration.getOutputFilename() + (i + 1) + ".html";
            amc.setCurrrentPageName(currentPageName);
            int previousPage = i - 1;
            if(previousPage >= 0) {
                amc.setPreviousItem(agaraMudhaliConfiguration.getStartingCharacter().get(i-1));
                amc.setPreviousPageName(agaraMudhaliConfiguration.getOutputFilename() + (previousPage + 1) + ".html");
            }
            int nextPage = i + 2;
            if(nextPage <= agaraMudhaliConfiguration.getStartingCharacter().size()) {
                amc.setNextItem(agaraMudhaliConfiguration.getStartingCharacter().get(i+1));
                amc.setNextPageName(agaraMudhaliConfiguration.getOutputFilename() + (nextPage) + ".html");
            }

            amc.setOutputFilename(currentPageName);
            String outputFileAbsolutePath = Paths.get(agaraMudhaliConfiguration.getOutputFileAbsolutePath(), amc.getOutputFilename()).toString();
            amc.setOutputFileAbsolutePath(outputFileAbsolutePath);
            generateHtmlFile(amc);
        }
    }

    private void generateHtmlFile(AgaraMudhaliConfiguration amc) throws TemplateException, IOException {
        System.out.println("generating: " + amc.getStartingCharacter().getFirst());
        // Connect to db
        List<ThirukkuralAgaraMudhali> agaraMudhaliItems = agaraMudhaliService.getAgaraMudhaliItems(amc.getFirstKuralId(), amc.getLastKuralId(), amc.getStartingCharacter().getFirst());
        // populate to template object
        processTemplateFile(amc, agaraMudhaliItems);
        // loop through in template - if needed
        System.out.println("generated: " + amc.getStartingCharacter().getFirst());
    }

    private void validateAgaraMudhaliConfiguration(AgaraMudhaliConfiguration agaraMudhaliConfiguration) throws FileNotFoundException {

        if (!Files.exists(Path.of(agaraMudhaliConfiguration.getTemplateFileAbsolutePath()))) {
            System.out.println("File does not exist: " + agaraMudhaliConfiguration.getTemplateFileAbsolutePath());
            throw new FileNotFoundException(agaraMudhaliConfiguration.getTemplateFileAbsolutePath());
        }
    }

    private void processTemplateFile(AgaraMudhaliConfiguration amc, List<ThirukkuralAgaraMudhali> items) throws IOException, TemplateException {
        Path template = Paths.get(amc.getTemplateFileAbsolutePath());
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

        FileUtils.createDirectory(amc.getOutputFileAbsolutePath());

        try (OutputStream outputStream = new FileOutputStream(Paths.get(amc.getOutputFileAbsolutePath()).toString());
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8)) {
            String information = MessageFormat.format("Processing template for: {0} -  Output File: {1}", amc.getStartingCharacter().getFirst(),amc.getOutputFileAbsolutePath());
            System.out.println(information);

            Map data = new HashMap();
            data.put("items", items);
            data.put("amc", amc);
            temp.process(data, outputStreamWriter);
        }
    }
}
