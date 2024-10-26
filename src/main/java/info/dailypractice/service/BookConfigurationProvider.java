package info.dailypractice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import info.dailypractice.entity.BookConfiguration;
import info.dailypractice.entity.PdfFontSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookConfigurationProvider {
    private String title;
    private String templateFileAbsolutePath;
    private String outputFileAbsolutePath;
    private PdfFontSettings pdfFontSettings;
    private List<BookConfiguration> bookConfigurationList;
    private ObjectMapper jacksonObjectMapper;

    public BookConfigurationProvider(@Autowired ObjectMapper jacksonObjectMapper) {
        this.jacksonObjectMapper = jacksonObjectMapper;
    }

    public List<BookConfiguration> getBookConfiguration(String dataFilepath) throws IOException {
        List<BookConfiguration> BookConfigurations = new ArrayList<>();

        String data = Files.readAllLines(Path.of(dataFilepath), StandardCharsets.UTF_8)
                .stream().collect(Collectors.joining("\n"));
        try {
            List<BookConfiguration> pcs = jacksonObjectMapper.readValue(data, new TypeReference<List<BookConfiguration>>() {
            });
            BookConfigurations.addAll(pcs);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return BookConfigurations;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTemplateFileAbsolutePath() {
        return templateFileAbsolutePath;
    }

    public void setTemplateFileAbsolutePath(String templateFileAbsolutePath) {
        this.templateFileAbsolutePath = templateFileAbsolutePath;
    }

    public String getOutputFileAbsolutePath() {
        return outputFileAbsolutePath;
    }

    public void setOutputFileAbsolutePath(String outputFileAbsolutePath) {
        this.outputFileAbsolutePath = outputFileAbsolutePath;
    }

    public PdfFontSettings getPdfFontSettings() {
        return pdfFontSettings;
    }

    public void setPdfFontSettings(PdfFontSettings pdfFontSettings) {
        this.pdfFontSettings = pdfFontSettings;
    }

    public List<BookConfiguration> getBookConfigurationList() {
        return bookConfigurationList;
    }

    public void setBookConfigurationList(List<BookConfiguration> bookConfigurationList) {
        this.bookConfigurationList = bookConfigurationList;
    }

    @Override
    public String toString() {
        return "BookConfigurationProvider{" +
                "title='" + title + '\'' +
                ", templateFileAbsolutePath='" + templateFileAbsolutePath + '\'' +
                ", outputFileAbsolutePath='" + outputFileAbsolutePath + '\'' +
                ", bookConfigurationList=" + bookConfigurationList +
                '}';
    }
}
