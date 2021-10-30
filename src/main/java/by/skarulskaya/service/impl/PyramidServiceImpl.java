package by.skarulskaya.service.impl;

import by.skarulskaya.entity.Point;
import by.skarulskaya.entity.Pyramid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.skarulskaya.service.PyramidService;

import java.util.OptionalDouble;

public class PyramidServiceImpl implements PyramidService {
    static final Logger logger = LogManager.getLogger();

    public boolean isPyramid(Point bottomCenter, Point top, int length) {
        if (length <= 0) {
            logger.warn("Bottom side length is incorrect: " + length);
            return false;
        }
        if (bottomCenter.getZ() == top.getZ()) {
            logger.warn(new StringBuilder().append("One plane: ").append(bottomCenter).append(top));
            return false;
        }
        if (bottomCenter.getX() != top.getX() || bottomCenter.getY() != top.getY()) {
            logger.warn(new StringBuilder().append("Top is not perpendicular to OXY: ").append(bottomCenter).append(top));
            return false;
        }
        return true;
    }

    public boolean isBottomInCoordinatePlane(Pyramid pyramid) { // основание может быть параллельно только OXY
        return pyramid.getBottomCenter().getZ() == 0;
    }

    public OptionalDouble calculateVolume(Pyramid pyramid) {
        if (pyramid == null) {
            return OptionalDouble.empty();
        }
        double sideLength = pyramid.getSideLength();
        double bottomArea = sideLength * sideLength;
        double height = Math.abs(pyramid.getTop().getZ() - pyramid.getBottomCenter().getZ());
        return OptionalDouble.of((bottomArea * height) / 3);
    }

    public OptionalDouble calculateFullArea(Pyramid pyramid) {
        if (pyramid == null) {
            return OptionalDouble.empty();
        }
        double sideLength = pyramid.getSideLength();
        double bottomArea = sideLength * sideLength;
        double height = Math.abs(pyramid.getTop().getZ() - pyramid.getBottomCenter().getZ());
        double apothem = Math.sqrt(Math.pow(sideLength / 2, 2) + Math.pow(height, 2));
        return OptionalDouble.of(2 * sideLength * apothem + bottomArea);
    }

    public OptionalDouble calculateVolumeRatio(Pyramid pyramid, double Z) { // плоскость параллельная OXY
        if (pyramid == null) {
            return OptionalDouble.empty();
        }
        double heightZ = pyramid.getTop().getZ();
        double minZ = pyramid.getBottomCenter().getZ();
        double maxZ = heightZ;
        if (minZ > maxZ) {
            double temp = minZ;
            minZ = maxZ;
            maxZ = temp;
        }
        if (Z < minZ || Z > maxZ || Z == heightZ) { // не выходит ли плоскость за границы пирамиды
            return OptionalDouble.empty();
        }
        double height = Math.abs(pyramid.getTop().getZ() - pyramid.getBottomCenter().getZ());
        double littleHeight = Math.abs(heightZ - Z);
        double k = height/littleHeight;
        return OptionalDouble.of(Math.pow(k, 3));
    }
}
