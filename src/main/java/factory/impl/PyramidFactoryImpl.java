package factory.impl;

import entity.Point;
import entity.Pyramid;
import factory.PyramidFactory;

public class PyramidFactoryImpl implements PyramidFactory {
    public Pyramid create(Point point1, Point point2, Point point3, Point point4, Point top) {
        return new Pyramid(new Point[]{point1, point2, point3, point4, top});
    }
    public Pyramid create() {
        return new Pyramid(new Point[] {new Point(-10, 0, 0), new Point(10, 0, 0),
                new Point(0, -10, 0), new Point(0, 10, 0), new Point(0, 0, 10)});
    }
}
