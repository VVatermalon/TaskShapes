package repository;

import entity.Pyramid;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Repository {
    private List<Pyramid> pyramids;

    public boolean add(Pyramid pyramid) {
        return pyramids.add(pyramid);
    }

    public boolean addAll(Collection<? extends Pyramid> c) {
        return pyramids.addAll(c);
    }

    public boolean remove(Pyramid pyramid) {
        return pyramids.remove(pyramid);
    }

    public boolean removeAll(Collection<? extends Pyramid> c) {
        return pyramids.removeAll(c);
    }

    public Pyramid get(int index) {
        return pyramids.get(index);
    }

    public Pyramid set(int index, Pyramid pyramid) {
        return pyramids.set(index, pyramid);
    }

    public List<Pyramid> query(Specification specification) {
        List<Pyramid> result = pyramids.stream()
                .filter(specification::specify)
                .collect(Collectors.toList());
        return result;
    }
}
