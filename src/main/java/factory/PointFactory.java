package factory;

import entity.Point;
import entity.Pyramid;

public interface PointFactory {
    Point create(int x, int y, int z);
}
