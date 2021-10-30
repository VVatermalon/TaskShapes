package by.skarulskaya.service;

import by.skarulskaya.entity.Point;
import by.skarulskaya.entity.Pyramid;

import java.util.OptionalDouble;

public interface PyramidService {
    OptionalDouble calculateVolume(Pyramid pyramid);
    OptionalDouble calculateFullArea(Pyramid pyramid);
    OptionalDouble calculateVolumeRatio(Pyramid pyramid, double Z);
    boolean isPyramid(Point bottomCenter, Point top, int length);
    boolean isBottomInCoordinatePlane(Pyramid pyramid);
}
