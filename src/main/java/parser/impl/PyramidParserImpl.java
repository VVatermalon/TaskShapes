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
import java.util.stream.Collectors;

public class PyramidParserImpl implements PyramidParser {
    static final Logger logger = LogManager.getLogger();
    static final String SPLITTER = "\\s";
    static final String EXTRA_SPACE = "\\s+";
    static final String SPACE = " ";

    public List<Integer> parse(String input) {
        PyramidValidatorImpl validator = new PyramidValidatorImpl();
        List<Integer> output;

        if (validator.validate(input)) {
            output = Arrays.stream(input.trim().replaceAll(EXTRA_SPACE, SPACE).split(SPLITTER))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } else {
            output = new ArrayList<>(0);
            logger.warn("Line didn't parse: " + input);
        }
        return output;
    }
}
