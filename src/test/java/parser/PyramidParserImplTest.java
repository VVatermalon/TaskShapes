package parser;

import entity.Pyramid;
import factory.impl.PyramidFactoryImpl;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import parser.impl.PyramidParserImpl;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class PyramidParserImplTest {
    static final PyramidParserImpl PARSER = new PyramidParserImpl();
    @DataProvider
    public Object[][] parserInput() {
        return new Object[][]{
                {"10 10 10   3 -4", new Integer[]{10, 10, 10, 3, -4}},
                {"10 10 10   3 3 -4", new Integer[0]}
        };
    }

    @Test(dataProvider = "parserInput")
    public void testParse(String input, Integer[] expectedArray) {
        List<Integer> expected = Arrays.asList(expectedArray);
        List<Integer> actual = PARSER.parse(input);
        assertEquals(actual, expected);
    }
}