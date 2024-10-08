package info.dailypractice.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

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

    public static void copyDirectory(Path sourceDirectory, Path targetDirectory) throws IOException {
        // Walk through the file tree of the source directory
        Files.walk(sourceDirectory)
                .forEach(source -> {
                    Path target = targetDirectory.resolve(sourceDirectory.relativize(source));
                    try {
                        // If the source is a directory, create the directory in the target location
                        if (Files.isDirectory(source)) {
                            Files.createDirectories(target);
                        } else {
                            // Copy the file from source to target, replacing any existing file
                            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
                        }
                    } catch (IOException e) {
                        System.err.println("Error copying: " + source + " to " + target + ". " + e);
                    }
                });
    }
}
