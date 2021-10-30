package by.skarulskaya.repository.impl;

import by.skarulskaya.service.impl.PyramidServiceImpl;
import by.skarulskaya.entity.Pyramid;
import by.skarulskaya.repository.Specification;

public class MaxAreaSpecification implements Specification {
    private double maxAreaValue;

    public MaxAreaSpecification(double maxAreaValue) {
        this.maxAreaValue = maxAreaValue;
    }

    @Override
    public boolean specify(Pyramid pyramid) {
        PyramidServiceImpl service = new PyramidServiceImpl();
        double actualVolume = service.calculateFullArea(pyramid).getAsDouble();
        return actualVolume <= maxAreaValue;
    }
}
