package by.skarulskaya.repository.impl;

import by.skarulskaya.service.impl.PyramidServiceImpl;
import by.skarulskaya.entity.Pyramid;
import by.skarulskaya.repository.Specification;

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
