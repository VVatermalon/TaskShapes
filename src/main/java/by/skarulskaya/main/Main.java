package by.skarulskaya.main;

import by.skarulskaya.entity.Pyramid;
import by.skarulskaya.entity.pyramidcomparator.VolumeComparator;
import by.skarulskaya.factory.impl.PyramidFactoryImpl;
import by.skarulskaya.parser.impl.PyramidParserImpl;
import by.skarulskaya.reader.impl.CustomFileReaderImpl;
import by.skarulskaya.repository.PyramidRepository;
import by.skarulskaya.repository.impl.MinAreaSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static final Logger logger = LogManager.getLogger();
    static final String FILE_SRC = "data.txt";

    public static void main(String[] args) {
        CustomFileReaderImpl reader = new CustomFileReaderImpl();
        List<String> readerResult = reader.readFromFile(FILE_SRC);
        logger.info(readerResult);
        PyramidParserImpl parser = new PyramidParserImpl();
        PyramidFactoryImpl factory = new PyramidFactoryImpl();
        List<Pyramid> pyramids = new ArrayList<>(0);
        for(String line: readerResult) {
            List<Integer> parserResult = parser.parse(line);
            logger.info(parserResult);
            Pyramid pyramid = factory.create(parserResult);
            pyramids.add(pyramid);
        }
        pyramids.forEach(Pyramid::attach);
        pyramids.forEach(p -> p.setSideLength(p.getSideLength() - 1));

        PyramidRepository repository = PyramidRepository.getInstance();
        repository.addAll(pyramids);
        logger.info(repository.sort(new VolumeComparator()));
        logger.info(repository.query(new MinAreaSpecification(10)));
    }
}
