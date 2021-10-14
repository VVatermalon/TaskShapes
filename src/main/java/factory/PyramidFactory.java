package factory;

import entity.Point;
import entity.Pyramid;

import java.util.List;

public interface PyramidFactory {
    Pyramid createSimple(List<Integer> cord);
    Pyramid create();
}
