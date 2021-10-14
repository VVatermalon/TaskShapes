package factory.impl;

import entity.Point;
import entity.Pyramid;
import factory.PyramidFactory;

import java.util.List;

public class PyramidFactoryImpl implements PyramidFactory {
    public Pyramid createSimple(List<Integer> cord) {
        if (cord == null || cord.size() != 5) {
            return create();
        }
        PointFactoryImpl factory = new PointFactoryImpl();
        double halfLength = cord.get(3) / 2.;
        Point one = factory.create(cord.get(0) - halfLength, cord.get(1) - halfLength, cord.get(2));
        Point two = factory.create(cord.get(0) - halfLength, cord.get(1) + halfLength, cord.get(2));
        Point three = factory.create(cord.get(0) + halfLength, cord.get(1) + halfLength, cord.get(2));
        Point four = factory.create(cord.get(0) + halfLength, cord.get(1) - halfLength, cord.get(2));
        Point top = factory.create(cord.get(0), cord.get(1), cord.get(4));
        return new Pyramid(new Point[]{one, two, three, four, top});
    }

    public Pyramid create() {
        return new Pyramid(new Point[]{new Point(-4, -4, 0), new Point(-4, 4, 0),
                new Point(4, 4, 0), new Point(4, -4, 0), new Point(0, 0, 8)});
    }
}
