package by.skarulskaya.repository.impl;

import by.skarulskaya.service.impl.PyramidServiceImpl;
import by.skarulskaya.entity.Pyramid;
import by.skarulskaya.repository.Specification;

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