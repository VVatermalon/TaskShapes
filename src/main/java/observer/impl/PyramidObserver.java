package observer.impl;

import entity.Pyramid;
import observer.Observer;
import observer.PyramidEvent;
import service.impl.PyramidServiceImpl;
import warehouse.WareHouse;

import java.util.OptionalDouble;

public class PyramidObserver implements Observer {
    @Override
    public void parameterChanged(PyramidEvent event) {
        PyramidServiceImpl service = new PyramidServiceImpl();
        Pyramid pyramid = event.getSource();
        int id = pyramid.getPyramidId();
        OptionalDouble fullArea = service.calculateFullArea(pyramid);
        OptionalDouble volume = service.calculateVolume(pyramid);
        WareHouse instance = WareHouse.getInstance();
        instance.putParameters(id, fullArea.getAsDouble(), volume.getAsDouble());
    }
}
