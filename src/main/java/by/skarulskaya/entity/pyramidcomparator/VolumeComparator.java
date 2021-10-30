package by.skarulskaya.entity.pyramidcomparator;

import by.skarulskaya.service.impl.PyramidServiceImpl;
import by.skarulskaya.entity.Pyramid;

import java.util.Comparator;
import java.util.OptionalDouble;

public class VolumeComparator implements Comparator<Pyramid> {
    @Override
    public int compare(Pyramid o1, Pyramid o2) {
        PyramidServiceImpl service = new PyramidServiceImpl();
        OptionalDouble volume1 = service.calculateVolume(o1);
        OptionalDouble volume2 = service.calculateVolume(o2);
        if(!volume1.isPresent() || !volume2.isPresent()) {
            return 0;
        }
        return Double.compare(volume1.getAsDouble(), volume2.getAsDouble());
    }
}
