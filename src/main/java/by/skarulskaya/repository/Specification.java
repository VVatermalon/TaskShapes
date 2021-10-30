package by.skarulskaya.repository;

import by.skarulskaya.entity.Pyramid;

public interface Specification {
    boolean specify(Pyramid pyramid);
}
