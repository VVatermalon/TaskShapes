package by.skarulskaya.factory.impl;

import by.skarulskaya.service.impl.PyramidServiceImpl;
import by.skarulskaya.entity.Point;
import by.skarulskaya.entity.Pyramid;
import by.skarulskaya.factory.PyramidFactory;
import by.skarulskaya.util.IdGenerator;

import java.util.List;

public class PyramidFactoryImpl implements PyramidFactory {
    public Pyramid create(List<Integer> cord) {
        if (cord == null || cord.size() != 5) {
            return create();
        }
        PointFactoryImpl factory = new PointFactoryImpl();
        Point bottom = factory.create(cord.get(0), cord.get(1), cord.get(2));
        Point top = factory.create(cord.get(0), cord.get(1), cord.get(4));
        int length = cord.get(3);

        final PyramidServiceImpl service = new PyramidServiceImpl();
        if(service.isPyramid(bottom, top, length)) {
            int id = IdGenerator.GenerateId();
            return new Pyramid(id, bottom, top, length);
        }
        else {
            return create();
        }
    }

    public Pyramid create(int bottomX, int bottomY, int bottomZ, int bottomSideLength, int topZ) {
        PointFactoryImpl factory = new PointFactoryImpl();
        Point bottom = factory.create(bottomX, bottomY, bottomZ);
        Point top = factory.create(bottomX, bottomY, topZ);

        final PyramidServiceImpl service = new PyramidServiceImpl();
        if(service.isPyramid(bottom, top, bottomSideLength)) {
            int id = IdGenerator.GenerateId();
            return new Pyramid(id, bottom, top, bottomSideLength);
        }
        else {
            return create();
        }
    }

    public Pyramid create() {
        PointFactoryImpl factory = new PointFactoryImpl();
        Point bottom = factory.create(0, 0, 0);
        Point top = factory.create(0, 0, 5);
        int length = 5;
        int id = IdGenerator.GenerateId();
        return new Pyramid(id, bottom, top, length);
    }
}
