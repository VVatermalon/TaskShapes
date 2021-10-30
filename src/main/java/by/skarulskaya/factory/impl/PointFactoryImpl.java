package by.skarulskaya.factory.impl;

import by.skarulskaya.entity.Point;
import by.skarulskaya.factory.PointFactory;
import by.skarulskaya.util.IdGenerator;

public class PointFactoryImpl implements PointFactory {
    public Point create(double x, double y, double z) {
        int id = IdGenerator.GenerateId();
        return new Point(id, x, y, z);
    }
}
