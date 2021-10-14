package service.impl;

import entity.Point;
import entity.Pyramid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.PyramidService;

import java.util.Arrays;
import java.util.OptionalDouble;

public class PyramidServiceImpl implements PyramidService {
    static final Logger logger = LogManager.getLogger();

    public boolean isPyramid(Point[] shape) {
        if (shape.length != 5) {
            return false;
        }
        for (int i = 0; i < shape.length - 1; i++) { // если есть одинаковые точки
            for (int k = i + 1; k < shape.length; k++) {
                if (shape[i].equalsIgnoreId(shape[k])) {
                    logger.warn("Same points " + Arrays.toString(shape));
                    return false;
                }
            }
        }
        if (Arrays.stream(shape).allMatch(p -> p.getX() == shape[0].getX()) // все точки в одной плоскости
                || Arrays.stream(shape).allMatch(p -> p.getY() == shape[0].getY())
                || Arrays.stream(shape).allMatch(p -> p.getZ() == shape[0].getZ())) {
            logger.warn("One plane " + Arrays.toString(shape));
            return false;
        }
        return Arrays.stream(shape).filter(p -> p.getX() == shape[0].getX()).count() == 4
                || Arrays.stream(shape).filter(p -> p.getY() == shape[0].getY()).count() == 4
                || Arrays.stream(shape).filter(p -> p.getZ() == shape[0].getZ()).count() == 4;
    }

    public boolean isBottomInCoordinatePlane(Pyramid pyramid) { // проверяю одну точку основания, тк все они в одной плоскости
        return pyramid.getPoints()[0].getX() == 0
                || pyramid.getPoints()[0].getY() == 0
                || pyramid.getPoints()[0].getZ() == 0;
    }

    public OptionalDouble calculateVolume(Pyramid pyramid) {
        if (pyramid == null) {
            return OptionalDouble.empty();
        }
        double bottomSide = Math.abs(pyramid.getPoints()[0].getY() - pyramid.getPoints()[1].getY());
        double bottomArea = bottomSide * bottomSide;
        double height = Math.abs(pyramid.getPoints()[0].getZ() - pyramid.getPoints()[4].getZ());
        return OptionalDouble.of((bottomArea * height) / 3);
    }

    public OptionalDouble calculateFullArea(Pyramid pyramid) {
        if (pyramid == null) {
            return OptionalDouble.empty();
        }
        double bottomSide = Math.abs(pyramid.getPoints()[0].getY() - pyramid.getPoints()[1].getY());
        double bottomArea = bottomSide * bottomSide;
        double height = Math.abs(pyramid.getPoints()[0].getZ() - pyramid.getPoints()[4].getZ());
        double apothem = Math.sqrt(Math.pow(bottomSide / 2, 2) + Math.pow(height, 2));
        return OptionalDouble.of((bottomArea * 4 * apothem) / 2 + bottomArea);
    }

    public OptionalDouble calculateVolumeRatio(Pyramid pyramid, double Z) { // плоскость параллельная OXY
        if (pyramid == null) {
            return OptionalDouble.empty();
        }
        double heightZ = pyramid.getPoints()[4].getZ();
        double minZ = pyramid.getPoints()[0].getZ();
        double maxZ = heightZ;
        if (minZ > maxZ) {
            double temp = minZ;
            minZ = maxZ;
            maxZ = temp;
        }
        if (Z < minZ || Z > maxZ || Z == heightZ) { // не выходит ли плоскость за границы пирамиды
            return OptionalDouble.empty();
        }
        double height = Math.abs(pyramid.getPoints()[0].getZ() - pyramid.getPoints()[4].getZ());
        double littleHeight = Math.abs(heightZ - Z);
        double k = height/littleHeight;
        return OptionalDouble.of(Math.pow(k, 3));
    }
}
