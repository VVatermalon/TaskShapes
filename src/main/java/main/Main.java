package main;

import entity.Point;
import entity.Pyramid;
import factory.impl.PointFactoryImpl;
import factory.impl.PyramidFactoryImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reader.impl.CustomFileReaderImpl;

import java.util.List;

public class Main {
    static final Logger logger = LogManager.getLogger();
    static final String FILE_SRC = "data.txt";

    public static void main(String[] args) {
        CustomFileReaderImpl reader = new CustomFileReaderImpl();
        List<String> readerResult = reader.readFromFile(FILE_SRC);
        logger.info(readerResult);
        PointFactoryImpl pointFactory = new PointFactoryImpl();
        Point point1 = pointFactory.create(5, 0, 0);
        Point point2 = pointFactory.create(-5, 0, 0);
        Point point3 = pointFactory.create(0, 5, 0);
        Point point4 = pointFactory.create(0, -5, 0);
        Point point5 = pointFactory.create(0, 0, 5);

        logger.info(point1.toString());
        logger.info(point2.equals(point3));

        PyramidFactoryImpl pyramidFactory = new PyramidFactoryImpl();
        Pyramid pyramid = pyramidFactory.create(point1, point2, point3, point4, point5);
        Pyramid pyramidEmpty = new Pyramid(null);
        logger.info(pyramidEmpty.toString());
        logger.info(pyramid.equals(pyramidEmpty));
    }
}
