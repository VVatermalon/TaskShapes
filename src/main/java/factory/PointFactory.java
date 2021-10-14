package factory;

import entity.Point;
import entity.Pyramid;

public interface PointFactory {
    Point create(double x, double y, double z);
}
