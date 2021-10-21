package factory;

import entity.Point;
import entity.Pyramid;

import java.util.List;

public interface PyramidFactory {
    Pyramid create(List<Integer> cord);
    Pyramid create();
}
