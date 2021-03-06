package by.skarulskaya.reader;

import by.skarulskaya.exception.PyramidCustomException;

import java.util.List;

public interface CustomFileReader {
    List<String> readFromFile(String src) throws PyramidCustomException;
}
