package repository.impl;

import entity.Pyramid;
import repository.Specification;
import service.impl.PyramidServiceImpl;

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
