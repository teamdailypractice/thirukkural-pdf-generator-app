package info.dailypractice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import info.dailypractice.entity.AgaraMudhaliConfiguration;
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
public class AgaraMudhaliConfigurationProvider {
    @Autowired
    private ObjectMapper objectMapper;

    public List<AgaraMudhaliConfiguration> getAgaraMudhaliConfiguration(String dataFilepath) throws IOException {
        List<AgaraMudhaliConfiguration> agaraMudhaliConfigurations = new ArrayList<>();

        String data = Files.readAllLines(Path.of(dataFilepath), StandardCharsets.UTF_8)
                .stream().collect(Collectors.joining("\n"));
        try {
            List<AgaraMudhaliConfiguration> pcs = objectMapper.readValue(data, new TypeReference<List<AgaraMudhaliConfiguration>>() {
            });
            agaraMudhaliConfigurations.addAll(pcs);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return agaraMudhaliConfigurations;
    }
}
