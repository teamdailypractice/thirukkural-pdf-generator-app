package info.dailypractice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import info.dailypractice.entity.BookConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class BookConfigurationProvider {
    @Autowired
    private ObjectMapper objectMapper;

    public List<BookConfiguration> getBookConfiguration(String dataFilepath) throws IOException {
        List<BookConfiguration> BookConfigurations = new ArrayList<>();

        String data = Files.readAllLines(Path.of(dataFilepath), StandardCharsets.UTF_8)
                .stream().collect(Collectors.joining("\n"));
        try {
            List<BookConfiguration> pcs = objectMapper.readValue(data, new TypeReference<List<BookConfiguration>>() {
            });
            BookConfigurations.addAll(pcs);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return BookConfigurations;
    }
}
