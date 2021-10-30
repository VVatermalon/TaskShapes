package by.skarulskaya.reader.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.skarulskaya.reader.CustomFileReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomFileReaderImpl implements CustomFileReader {
    static final Logger logger = LogManager.getLogger();

    public List<String> readFromFile(String src) {
        try {
            ArrayList<String> output = new ArrayList<>(0);
            if (src == null) {
                logger.error("Null parameter");
                return output;
            }
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            URL resource = classLoader.getResource(src);
            if (resource == null) {
                logger.error("Null parameter");
                return output;
            }
            output = Files.lines(Paths.get(resource.toURI()))
                    .collect(Collectors.toCollection(ArrayList::new));
            return output;
        } catch (IOException | URISyntaxException e) {
            logger.error(e);
            return new ArrayList<>(0);
        }
    }
}
