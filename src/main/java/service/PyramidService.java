package service;

import entity.Point;
import entity.Pyramid;

import java.util.OptionalDouble;

public interface PyramidService {
    OptionalDouble calculateVolume(Pyramid pyramid);
    OptionalDouble calculateFullArea(Pyramid pyramid);
    OptionalDouble calculateVolumeRatio(Pyramid pyramid, double Z);
    boolean isPyramid(Point[] shape);
    boolean isBottomInCoordinatePlane(Pyramid pyramid);
}