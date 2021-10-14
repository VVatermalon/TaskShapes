package main;

import entity.Pyramid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import parser.impl.PyramidParserImpl;
import reader.impl.CustomFileReaderImpl;
import service.impl.PyramidServiceImpl;

import java.util.List;

public class Main {
    static final Logger logger = LogManager.getLogger();
    static final String FILE_SRC = "data.txt";

    public static void main(String[] args) {
        CustomFileReaderImpl reader = new CustomFileReaderImpl();
        List<String> readerResult = reader.readFromFile(FILE_SRC);
        logger.info(readerResult);
        PyramidParserImpl parser = new PyramidParserImpl();
        List<Pyramid> pyramids = parser.parse(readerResult);
        PyramidServiceImpl service = new PyramidServiceImpl();
        pyramids.forEach(p->logger.info(service.isPyramid(p.getPoints())));
    }
}
