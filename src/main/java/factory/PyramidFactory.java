package factory;

import entity.Point;
import entity.Pyramid;

public interface PyramidFactory {
    Pyramid create(Point point1, Point point2, Point point3, Point point4, Point top);
}
