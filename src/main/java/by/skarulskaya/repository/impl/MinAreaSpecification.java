package by.skarulskaya.repository.impl;

import by.skarulskaya.service.impl.PyramidServiceImpl;
import by.skarulskaya.entity.Pyramid;
import by.skarulskaya.repository.Specification;

public class MinAreaSpecification implements Specification {
    private double minAreaValue;

    public MinAreaSpecification(double minAreaValue) {
        this.minAreaValue = minAreaValue;
    }

    @Override
    public boolean specify(Pyramid pyramid) {
        PyramidServiceImpl service = new PyramidServiceImpl();
        double actualVolume = service.calculateFullArea(pyramid).getAsDouble();
        return actualVolume >= minAreaValue;
    }
}
