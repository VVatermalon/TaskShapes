package by.skarulskaya.reader;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.skarulskaya.reader.impl.CustomFileReaderImpl;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class CustomFileReaderImplTest {
    static final CustomFileReaderImpl READER = new CustomFileReaderImpl();
    @DataProvider
    public Object[][] readerInput() {
        return new Object[][]{
                {"dataTest.txt", new String[]{"0 0 0 +5 10", "-2 -2 -2 3 -3", "4 3 1 4 15", "0j 0 0 4 20"}},
                {"emptyTest.txt", new String[0]},
                {"emptyyyyTest.txt", new String[0]},
                {null , new String[0]}
        };
    }

    @Test(dataProvider = "readerInput")
    public void readFromFileTest(String src, String[] expectedArray) {
        List<String> actual = READER.readFromFile(src);
        List<String> expected = Arrays.asList(expectedArray);
        assertEquals(actual, expected);
    }
}