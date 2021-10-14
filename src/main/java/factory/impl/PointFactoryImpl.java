package factory.impl;

import entity.Point;
import entity.Pyramid;
import factory.PointFactory;

public class PointFactoryImpl implements PointFactory {
    public Point create(double x, double y, double z) {
        return new Point(x, y, z);
    }
}
