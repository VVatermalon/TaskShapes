package repository.impl;

import entity.Pyramid;
import repository.Specification;
import service.impl.PyramidServiceImpl;

public class MaxVolumeSpecification implements Specification {
    private double maxVolumeValue;

    public MaxVolumeSpecification(double maxVolumeValue) {
        this.maxVolumeValue = maxVolumeValue;
    }

    @Override
    public boolean specify(Pyramid pyramid) {
        PyramidServiceImpl service = new PyramidServiceImpl();
        double actualVolume = service.calculateVolume(pyramid).getAsDouble();
        return actualVolume <= maxVolumeValue;
    }
}