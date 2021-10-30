package by.skarulskaya.factory;

import by.skarulskaya.entity.Pyramid;

import java.util.List;

public interface PyramidFactory {
    Pyramid create(List<Integer> cord);
    Pyramid create();
}
