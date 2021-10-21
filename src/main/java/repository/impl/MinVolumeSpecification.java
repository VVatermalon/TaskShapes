package repository.impl;

import entity.Pyramid;
import repository.Specification;
import service.impl.PyramidServiceImpl;

public class MinVolumeSpecification implements Specification {
    private double minVolumeValue;

    public MinVolumeSpecification(double minVolumeValue) {
        this.minVolumeValue = minVolumeValue;
    }

    @Override
    public boolean specify(Pyramid pyramid) {
        PyramidServiceImpl service = new PyramidServiceImpl();
        double actualVolume = service.calculateVolume(pyramid).getAsDouble();
        return actualVolume >= minVolumeValue;
    }
}
