package info.dailypractice.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import info.dailypractice.entity.BookConfiguration;
import info.dailypractice.entity.HyperlinksList;
import info.dailypractice.entity.HyperlinksWithDescriptionList;
import info.dailypractice.pdf.Book;
import info.dailypractice.pdf.BookPage;
import info.dailypractice.service.BookConfigurationProvider;
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

@ShellComponent
public class TypstFileGenerator {
    public static final String TYPST_FILE_EXTENSION = "typ";
    @Autowired
    private Book book;
    @Autowired
    private ObjectMapper objectMapper;


    private BookConfigurationProvider getBookConfigurationProvider(String dataFilepath) throws IOException {
        BookConfigurationProvider bookConfigurationProvider = objectMapper
                .readValue(new File(dataFilepath), BookConfigurationProvider.class);
        return bookConfigurationProvider;
    }

    @ShellMethod("generate html page for books")
    public void generateBookHomePage(String dataFilepath) throws IOException, RuntimeException, TemplateException {
        BookConfigurationProvider bookConfigurationProvider = getBookConfigurationProvider(dataFilepath);
        validateBookConfigurationProvider(bookConfigurationProvider);
        processTemplateFile(bookConfigurationProvider);
    }

    @ShellMethod("generate typst file for book")
    public void generateBookTypeSetting(String dataFilepath) throws IOException, RuntimeException {

        BookConfigurationProvider bookConfigurationProvider = getBookConfigurationProvider(dataFilepath);

        bookConfigurationProvider.getBookConfigurationList().
                forEach(bookConfiguration -> {
                    try {
                        doProcess(bookConfiguration);
                    } catch (TemplateException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    private void doProcess(BookConfiguration bc) throws TemplateException, IOException {
        validateBookConfiguration(bc);
        generateTypstFile(bc);
    }

    private static void validateBookConfiguration(BookConfiguration bc) throws FileNotFoundException {
        if (!Files.exists(Path.of(bc.getTemplateFileAbsolutePath()))) {
            System.out.println("File does not exist: " + bc.getTemplateFileAbsolutePath());
            throw new FileNotFoundException(bc.getTemplateFileAbsolutePath());
        }
    }

    private void generateTypstFile(BookConfiguration bc) throws IOException, TemplateException {
        Path template = Paths.get(bc.getTemplateFileAbsolutePath());
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


        try (OutputStream outputStream = new FileOutputStream(
                Paths.get(bc.getOutputFileAbsolutePath(),
                                bc.getBookName() + "." + TYPST_FILE_EXTENSION)
                        .toString());
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8)) {
            String information = MessageFormat.format("Processing template for: {0} -  Output File: {1}", bc.getBookName(), bc.getOutputFileAbsolutePath());
            System.out.println(information);


            book.setBookConfiguration(bc);
            Map data = new HashMap();
            data.put("book", book);

            temp.process(data, outputStreamWriter);
        }
    }

    private static void validateBookConfigurationProvider(BookConfigurationProvider bcp) throws FileNotFoundException {
        if (!Files.exists(Path.of(bcp.getTemplateFileAbsolutePath()))) {
            System.out.println("File does not exist: " + bcp.getTemplateFileAbsolutePath());
            throw new FileNotFoundException(bcp.getTemplateFileAbsolutePath());
        }
    }

    private void processTemplateFile(BookConfigurationProvider bcp) throws IOException, TemplateException {
        Path template = Paths.get(bcp.getTemplateFileAbsolutePath());
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

        FileUtils.createDirectory(bcp.getOutputFileAbsolutePath());

        try (OutputStream outputStream = new FileOutputStream(Paths.get(bcp.getOutputFileAbsolutePath()).toString());
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8)) {
            String information = MessageFormat.format("Processing template for: {0} -  Output File: {1}", bcp.getTemplateFileAbsolutePath(), bcp.getOutputFileAbsolutePath());
            System.out.println(information);

            Map data = new HashMap();
            data.put("bcp", bcp);

            temp.process(data, outputStreamWriter);
        }
    }

}

