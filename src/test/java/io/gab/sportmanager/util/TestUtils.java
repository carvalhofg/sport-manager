package io.gab.sportmanager.util;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Objects;

@Component
public class TestUtils {

    public byte[] convertFileToByte(String filePath) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource(filePath)).getFile());
        return Files.readAllBytes(file.toPath());
    }
}
