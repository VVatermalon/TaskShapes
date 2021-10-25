package repository.impl;

import entity.Pyramid;
import repository.Specification;
import service.impl.PyramidServiceImpl;

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
