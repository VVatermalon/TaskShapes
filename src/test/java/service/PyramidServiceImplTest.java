package service;

import entity.Point;
import entity.Pyramid;
import factory.impl.PyramidFactoryImpl;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.impl.PyramidServiceImpl;

import javax.swing.text.html.Option;
import java.util.OptionalDouble;

import static org.testng.Assert.*;

public class PyramidServiceImplTest {
    @DataProvider
    public Object[][] isPyramidData() {
        return new Object[][]{
                {new Point(-2, 0, 0, 0), new Point(-3, 0, 0 , 2), 2, true},
                {new Point(-4, 0, 0, 0), new Point(-5, 0, 0 , 2), -1, false},
                {new Point(-8, 0, 0, 0), new Point(-9, 0, 0 , 0), 2, false},
                {new Point(-11, 0, 0, 0), new Point(-12, 0, 2 , 0), 2, false}
        };
    }

    @Test(dataProvider = "isPyramidData")
    public void isPyramidTest(Point bottom, Point top, int length, boolean expected) {
        PyramidServiceImpl service = new PyramidServiceImpl();
        boolean actual = service.isPyramid(bottom, top, length);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] volumeData() {
        return new Object[][]{
                {new Pyramid(-20, new Point(-13, 0, 0, 0), new Point(-14, 0, 0 , 9), 5), OptionalDouble.of(75)},
                {null, OptionalDouble.empty()}
        };
    }

    @Test(dataProvider = "volumeData")
    public void testCalculateVolume(Pyramid input, OptionalDouble expected) {
        PyramidServiceImpl service = new PyramidServiceImpl();
        OptionalDouble actual = service.calculateVolume(input);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] volumeArea() {
        return new Object[][]{
                {new Pyramid(-21, new Point(-22, 0, 0, 0), new Point(-23, 0, 0 , 3), 8), OptionalDouble.of(144)},
                {null, OptionalDouble.empty()}
        };
    }

    @Test(dataProvider = "volumeArea")
    public void testCalculateFullArea(Pyramid input, OptionalDouble expected) {
        PyramidServiceImpl service = new PyramidServiceImpl();
        OptionalDouble actual = service.calculateFullArea(input);
        assertEquals(actual, expected);
    }
}