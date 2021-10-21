package observer;

public interface Observable {
    void attach();
    void detach();
    void notifyObservers();
}
