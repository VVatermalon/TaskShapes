package by.skarulskaya.entity.pyramidcomparator;

import by.skarulskaya.entity.Pyramid;
import by.skarulskaya.service.impl.PyramidServiceImpl;

import java.util.Comparator;
import java.util.OptionalDouble;

public class AreaComparator implements Comparator<Pyramid> {
    @Override
    public int compare(Pyramid o1, Pyramid o2) {
        PyramidServiceImpl service = new PyramidServiceImpl();
        OptionalDouble area1 = service.calculateFullArea(o1);
        OptionalDouble area2 = service.calculateFullArea(o2);
        if(!area1.isPresent() || !area2.isPresent()) {
            return 0;
        }
        return Double.compare(area1.getAsDouble(), area2.getAsDouble());
    }
}
