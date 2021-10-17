package parser.impl;

import entity.Pyramid;
import factory.impl.PyramidFactoryImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import parser.PyramidParser;
import validator.impl.PyramidValidatorImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PyramidParserImpl implements PyramidParser {
    static final Logger logger = LogManager.getLogger();
    static final String SPLITTER = "\\s";

    public List<Pyramid> parse(List<String> input) {
        PyramidValidatorImpl validator = new PyramidValidatorImpl();
        PyramidFactoryImpl factory = new PyramidFactoryImpl();
        ArrayList<Integer> cordPyramid = new ArrayList<>(0);
        ArrayList<Pyramid> output = new ArrayList<>(0);

        for (String line : input) {
            if (validator.validate(line)) {
                String[] stringNumbers = line.trim().split(SPLITTER);
                for (String number : stringNumbers) {
                    int parsedNumber = Integer.parseInt(number);
                    cordPyramid.add(parsedNumber);
                }
                Pyramid pyramid = factory.createSimple(cordPyramid);
                output.add(pyramid);
                cordPyramid.clear();
            } else {
                logger.warn("Line didn't parsed: " + line);
            }
        }
        return output;
    }
}
