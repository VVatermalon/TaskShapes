package by.skarulskaya.observer.impl;

import by.skarulskaya.service.impl.PyramidServiceImpl;
import by.skarulskaya.warehouse.WareHouse;
import by.skarulskaya.entity.Pyramid;
import by.skarulskaya.observer.Observer;
import by.skarulskaya.observer.PyramidEvent;

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
