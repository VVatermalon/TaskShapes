package by.skarulskaya.warehouse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.StringFormattedMessage;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class WareHouse {
    static final Logger logger = LogManager.getLogger();
    private static final WareHouse instance = new WareHouse();
    private final Map<Integer, PyramidParameter> pyramidMap = new HashMap<>();

    private WareHouse() {}

    public static WareHouse getInstance() {
        return instance;
    }

    public Optional<PyramidParameter> getParameters(int id) {
        return Optional.ofNullable(pyramidMap.get(id));
    }

    public void putParameters(int id, double area, double volume) {
        PyramidParameter parameter = new PyramidParameter(area, volume);
        pyramidMap.put(id, parameter);
        logger.info(new StringFormattedMessage("Pyramid changed id: %d, area: %f, volume: %f", id, area, volume));
    }

    public void updateParameters(int id, double area, double volume) { // нужен вообще?
        if(pyramidMap.containsKey(id)) {
            PyramidParameter parameter = pyramidMap.get(id);
            parameter.setArea(area);
            parameter.setVolume(volume);
        }
        else {
            logger.warn("No such key for update in WareHouse " + id);
        }
    }
}
