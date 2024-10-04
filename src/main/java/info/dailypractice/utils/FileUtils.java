package info.dailypractice.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {

    public static void createDirectory(String path) throws IOException {

        Path directoryPath = Paths.get(path);
        if (directoryPath.isAbsolute()) {
            Path directoryToBeCreated = directoryPath;
            if (directoryPath.getFileName().toString().contains(".")) {
                directoryToBeCreated = directoryPath.getParent();
            }
            if (!Files.exists(directoryToBeCreated)) {
                Files.createDirectories(directoryToBeCreated);
                System.out.println("Directory created: " + directoryToBeCreated);
            } else {
                System.out.println("Directory already exists: " + directoryToBeCreated);
            }
        } else {
            throw new IOException("Path: " + path + " is not absolute.");
        }

    }
}
