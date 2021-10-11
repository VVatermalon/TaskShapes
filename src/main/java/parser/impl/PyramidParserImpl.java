package parser.impl;

import entity.Pyramid;
import parser.PyramidParser;

import java.util.ArrayList;
import java.util.List;

public class PyramidParserImpl implements PyramidParser {
    static final String SPLITTER = "//s, //,";
    public List<Pyramid> parse(List<String> input) {
        for (String line: input) {
            String[] splittedLine = line.trim().split(SPLITTER);
            if(splittedLine.length != 15) {
                return new ArrayList<>();
            }
            for (String part: splittedLine) {

            }
        }
    }
}
