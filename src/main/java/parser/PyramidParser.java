package parser;

import entity.Pyramid;

import java.util.List;

public interface PyramidParser {
    List<Pyramid> parse(List<String> input);
}
