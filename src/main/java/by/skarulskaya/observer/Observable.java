package by.skarulskaya.observer;

public interface Observable {
    void attach();
    void detach();
    void notifyObservers();
}
