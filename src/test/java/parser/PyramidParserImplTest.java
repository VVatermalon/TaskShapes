package parser;

import entity.Pyramid;
import factory.impl.PyramidFactoryImpl;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import parser.impl.PyramidParserImpl;

import static org.testng.Assert.*;

public class PyramidParserImplTest {
    static final PyramidParserImpl PARSER = new PyramidParserImpl();
    static final String NORMAL = "10 10 10   3 -4";
    static Pyramid normalPyramid;


    @BeforeMethod
    public void setUp() {
        PyramidFactoryImpl factory = new PyramidFactoryImpl();
        normalPyramid = factory.create();
    }

    @Test
    public void testParse() {
        PARSER.parse(NORMAL);
    }
}