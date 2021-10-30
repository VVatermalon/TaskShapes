package by.skarulskaya.observer;

import by.skarulskaya.entity.Pyramid;

import java.util.EventObject;

public class PyramidEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public PyramidEvent(Pyramid source) {
        super(source);
    }

    @Override
    public Pyramid getSource() {
        return (Pyramid) super.getSource();
    }
}
