package by.skarulskaya.factory;

import by.skarulskaya.entity.Point;

public interface PointFactory {
    Point create(double x, double y, double z);
}
