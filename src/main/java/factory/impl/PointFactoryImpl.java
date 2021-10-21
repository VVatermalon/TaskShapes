package factory.impl;

import entity.Point;
import entity.Pyramid;
import factory.PointFactory;
import util.IdGenerator;

public class PointFactoryImpl implements PointFactory {
    public Point create(double x, double y, double z) {
        int id = IdGenerator.GenerateId();
        return new Point(id, x, y, z);
    }
}
